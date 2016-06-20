
package org.usfirst.frc.team5414.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

import org.usfirst.frc.team5414.robot.commands.Auto_CrossDefense_EndinNeutral;
import org.usfirst.frc.team5414.robot.commands.Auto_Shooter_Spy;
import org.usfirst.frc.team5414.robot.commands.AutoCross_Defense_TurnTower;
import org.usfirst.frc.team5414.robot.commands.Auto_CrossDefenseMoat;
import org.usfirst.frc.team5414.robot.commands.Auto_CrossDefense_Adjacent;
import org.usfirst.frc.team5414.robot.commands.RotationStation;
import org.usfirst.frc.team5414.robot.commands.ShooterStartHigh;
import org.usfirst.frc.team5414.robot.commands.SpyScoreNeutral;
import org.usfirst.frc.team5414.robot.commands.TriggerReset;
import org.usfirst.frc.team5414.robot.commands.triggerHoldPosition;

import java.util.Arrays;
//import java.util.stream.Collector;

import org.usfirst.frc.team5414.robot.commands.AutoCrossNeutral;
import org.usfirst.frc.team5414.robot.commands.AutoCrossNeutralCollect;
import org.usfirst.frc.team5414.robot.commands.AutoDoNothing;
import org.usfirst.frc.team5414.robot.commands.AutoGyro;
import org.usfirst.frc.team5414.robot.commands.AutoLowDestroy;
import org.usfirst.frc.team5414.robot.commands.AutoScanner;
import org.usfirst.frc.team5414.robot.commands.AutoScannerRight;
import org.usfirst.frc.team5414.robot.commands.AutoShoot;
import org.usfirst.frc.team5414.robot.commands.AutoSpyBoxLow;
import org.usfirst.frc.team5414.robot.commands.AutoSpyNeutralCollect;
import org.usfirst.frc.team5414.robot.commands.Auto_CrossDefense;
import org.usfirst.frc.team5414.robot.commands.DriveForward;
import org.usfirst.frc.team5414.robot.subsystems.Collector;
import org.usfirst.frc.team5414.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5414.robot.subsystems.Electrical;
import org.usfirst.frc.team5414.robot.subsystems.ShooterWheel;
import org.usfirst.frc.team5414.robot.subsystems.Intake;
import org.usfirst.frc.team5414.robot.subsystems.Manipulator;
import org.usfirst.frc.team5414.robot.subsystems.Pneumatics;
//import org.usfirst.frc.team5414.robot.subsystems.Shooter;
import org.usfirst.frc.team5414.robot.subsystems.Shootertrigger;
import org.usfirst.frc.team5414.robot.subsystems.ShovelLaFries;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

//	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static Collector collector;
	public static Drivetrain drivetrain;
	public static Pneumatics pneumatics;
	public static Compressor compressor;
	public static Manipulator manipulator;
	public static ShooterWheel shooter;
	public static Electrical electrical;
	public static Shootertrigger trigger;
	public static Intake intake;
	public static ShovelLaFries shovellafries;
//	public static Shooter shooter;
	
	public static OI oi;
	final int gyroChannel = 3;
//	public static double g_dkp;
//	public static double g_dist;
	public static double g_speed;
	public static double g_encoder;
	public static int g_exp;
//	public static double g_time;
	double angleSetpoint = 0.0;
	final double pGain = .006;
	final double voltsPerDegreePerSecond = .0128;
	
	
	boolean currentButtonState=false;
	
	static NetworkTable table;
	private final NetworkTable grip = NetworkTable.getTable("GRIP");
	
//	AnalogGyro gyro;
	Preferences prefs;
    Command autonomousCommand;
    SendableChooser chooser;
    public SendableChooser triggerchooser;
    CameraServer server;
    USBCamera targetCam;
    String test="";
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
//    	pneumatics = new Pneumatics();

    	table = NetworkTable.getTable("GRIP/myContoursReport");
    	drivetrain = new Drivetrain();
    	collector = new Collector();
    	shooter = new ShooterWheel();
    	trigger = new Shootertrigger();
    	intake = new Intake();
    	electrical = new Electrical();
    	shovellafries = new ShovelLaFries();
//    	manipulator = new Manipulator();
    	NetworkTable.initialize();

    	prefs = Preferences.getInstance();
    	g_speed = prefs.getDouble("g_speed", 0.0);
    	g_encoder = prefs.getDouble("g_encoder", 20);
    	g_exp = prefs.getInt("exp", 1);
    	SmartDashboard.putNumber("Exp", g_exp);
    	
    	//For testing with camera on Rio:
    	try{
        	targetCam = new USBCamera("cam3");
        	targetCam.setBrightness(1);
        	targetCam.setExposureAuto();
//        	targetCam.setExposureManual(6);
        	targetCam.setWhiteBalanceAuto();
        	
        	targetCam.updateSettings();
    	    server = CameraServer.getInstance();
    	    server.setQuality(50);
    	    server.startAutomaticCapture(targetCam);
//    		the camera name (ex "cam0") can be found through the roborio web interface
    	}catch(Exception e){
    		System.out.println("No camera");
    	}

   	
		oi = new OI();
		//gyro = new AnalogGyro(gyroChannel);
//		Robot.pneumatics.compress();
        table = NetworkTable.getTable("GRIP/myContoursReport");
        double[] areas = table.getNumberArray("area", new double[0]);
        for (double area:areas) 
        {
        	SmartDashboard.putNumber("Area", area);
        }
    	SmartDashboard.putNumber("(pref) speed", g_speed);
    	SmartDashboard.putNumber("(pref) encoder counts", g_encoder);
		
		SmartDashboard.putData(drivetrain);
        chooser = new SendableChooser();
        chooser.addDefault("Cross Defense", new Auto_CrossDefense());
        chooser.addObject("Cross Defense, Moat", new Auto_CrossDefenseMoat());
//        chooser.addObject("Cross Defense, End in neutral zone", new Auto_CrossDefense_EndinNeutral());
//        chooser.addObject("Cross Defense, Turn towards tower", new AutoCross_Defense_TurnTower());
//        chooser.addObject("Spy to Low Goal to Neutral", new SpyScoreNeutral());
//        chooser.addObject("Spy to Low Goal", new AutoSpyBoxLow());
//        chooser.addObject("Spy to Neutral and Collect", new AutoSpyNeutralCollect());
//        chooser.addObject("Cross Defense, End in Neutral Zone, and Collect", new AutoCrossNeutralCollect());
//        chooser.addObject("Cross Defense and End in Neutral Zone", new AutoCrossNeutral());
        chooser.addObject("Destroy Low in Auto", new AutoLowDestroy());
        chooser.addObject("Cross Defense Adjacent", new Auto_CrossDefense_Adjacent());
        chooser.addObject("Shoot Spy Zone", new Auto_Shooter_Spy());
        chooser.addObject("AutoShoot", new AutoShoot());
        chooser.addObject("AutoScanner(Left)", new AutoScanner());
        chooser.addObject("AutoScanner(Right)", new AutoScannerRight());
        chooser.addObject("no", new AutoDoNothing());
        
        triggerchooser = new SendableChooser();
        triggerchooser.addDefault("On", new triggerHoldPosition());
        triggerchooser.addObject("Off", new TriggerReset());
        
        
        
        
        
        SmartDashboard.putData("Auto mode", chooser);        
//        if(!(prefs.containsKey("g_dkp")))
//        {
//        	prefs.putDouble("g_dkp", 4.8);
//        }
//        if(!(prefs.containsKey("g_speed")))
//        {
//        	prefs.putDouble("g_speed", 0.6);
//        }
    	
    	
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    	g_exp = prefs.getInt("exp", 1);

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	autonomousCommand = (Command) chooser.getSelected();
    	autonomousCommand.start();
    	
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	if(autonomousCommand != null) {
    		autonomousCommand.cancel();
    	}
//        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        test="Keys: ";
        currentButtonState = oi.getJoystick1().getRawButton(5);
        
        SmartDashboard.putNumber("Framerate", NetworkTable.getTable("GRIP").getNumber("myNumber", Double.NaN));
    	SmartDashboard.putBoolean("HasArea",  table.containsKey("area"));
    	
    	for (String i: NetworkTable.getTable("GRIP").getKeys())
    		test+=i+", ";
    	test+="\n";
    	SmartDashboard.putString("Keys", test);
    	if(currentButtonState)
    	{
    		try {
				SmartDashboard.putString("Area: ", Arrays.toString(table.getNumberArray("area", new double[0])));
				SmartDashboard.putBoolean("Errored", false);
				SmartDashboard.putString("CenterX: ", Arrays.toString(table.getNumberArray("centerX", new double[0]))); 
				SmartDashboard.putString("CenterY", Arrays.toString(table.getNumberArray("centerY",new double[0])));
			} catch (Exception e) {
				SmartDashboard.putBoolean("Errored", true);
			}
    	}
         //server = CameraServer.getInstance();
       // server.setQuality(50);
        //the camera name (ex "cam0") can be found through the roborio web interface
        //server.startAutomaticCapture("cam0");
		
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
	public static boolean containsArea(){
		double[] thing  = table.getNumberArray("area", new double[0]);
		SmartDashboard.putString("areaThing", Arrays.toString(thing));
		SmartDashboard.putNumber("Thing length", thing.length);
		return thing.length==0;
	}
	public static double centerX(){
		double x = 0;
		double[] center = table.getNumberArray("centerX", new double[0]);
		if(center.length==1){
			x = center[0];
		}
		return x;
	}
    
}
