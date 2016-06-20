 package org.usfirst.frc.team5414.robot;

import org.usfirst.frc.team5414.robot.commands.Align;
import org.usfirst.frc.team5414.robot.commands.AlignTracker;
import org.usfirst.frc.team5414.robot.commands.AutoScanner;
import org.usfirst.frc.team5414.robot.commands.ChevalDown;
import org.usfirst.frc.team5414.robot.commands.ChevalDownHoldCG;
import org.usfirst.frc.team5414.robot.commands.ChevalUp;
import org.usfirst.frc.team5414.robot.commands.CollectorIn;
import org.usfirst.frc.team5414.robot.commands.CollectorOut;
import org.usfirst.frc.team5414.robot.commands.CollectorStop;
import org.usfirst.frc.team5414.robot.commands.DriveForward;
import org.usfirst.frc.team5414.robot.commands.IntakeIn;
import org.usfirst.frc.team5414.robot.commands.IntakeOut;
import org.usfirst.frc.team5414.robot.commands.IntakeStop;

import org.usfirst.frc.team5414.robot.commands.LEDOn;
import org.usfirst.frc.team5414.robot.commands.ManipulateDown;
import org.usfirst.frc.team5414.robot.commands.ManipulateUp;
import org.usfirst.frc.team5414.robot.commands.ManipulatorStop;
import org.usfirst.frc.team5414.robot.commands.ScanTele;
import org.usfirst.frc.team5414.robot.commands.ServoPanLeft;
import org.usfirst.frc.team5414.robot.commands.ServoPanRight;
import org.usfirst.frc.team5414.robot.commands.ShootBoulder;
import org.usfirst.frc.team5414.robot.commands.ShooterStartHigh;
import org.usfirst.frc.team5414.robot.commands.ShooterStartLow;
import org.usfirst.frc.team5414.robot.commands.ShooterStart_Voltage;
import org.usfirst.frc.team5414.robot.commands.ShooterStop;
import org.usfirst.frc.team5414.robot.commands.ShooterVoltage;
import org.usfirst.frc.team5414.robot.commands.ShooterWheelHighRetractCG;
import org.usfirst.frc.team5414.robot.commands.ShooterWheelLowRetractCG;
import org.usfirst.frc.team5414.robot.commands.SolBack;
import org.usfirst.frc.team5414.robot.commands.SolFire;
import org.usfirst.frc.team5414.robot.commands.TriggerReset;
import org.usfirst.frc.team5414.robot.commands.TriggerStart;
import org.usfirst.frc.team5414.robot.commands.encoderTesting;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team5414.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick stick = new Joystick(0);		//Joystick in Driver Station Spot 0
	private Joystick stick2 = new Joystick(1);		//Joystick in Driver Station Spot 1
	
	public OI()
	{
//		JoystickButton l1 = new JoystickButton(stick, 5);
//		JoystickButton r1 = new JoystickButton(stick, 6); 
//		JoystickButton a = new JoystickButton(stick, 5);
		//Stick 2 Controls
		JoystickButton CollectorInStick2 = new JoystickButton(stick2, RobotMap.CollectorRetract);
		JoystickButton CollectorOutStick2 = new JoystickButton(stick2, RobotMap.CollectorExtend);
		JoystickButton IntakeStick2 = new JoystickButton(stick2, RobotMap.Intake);
		JoystickButton OuttakeStick2 = new JoystickButton(stick2, RobotMap.Outtake);
		JoystickButton IntakeOutakeStopStick2 = new JoystickButton(stick2, RobotMap.IntakeStop);
		
		JoystickButton ShooterWheelHigh2 = new JoystickButton(stick2, RobotMap.ShooterWheelHigh);
		JoystickButton ShooterWheelLow2 = new JoystickButton(stick2, RobotMap.ShooterWheelLow);
		JoystickButton ShooterWheelV2 = new JoystickButton(stick2, RobotMap.ShooterWheelVolt);
		JoystickButton ShooterActuate2 = new JoystickButton(stick2, RobotMap.ShooterActuate);
//		JoystickButton ShooterAlign = new JoystickButton(stick2, RobotMap.ShooterAlign);
//		JoystickButton AllignTracker = new JoystickButton(stick2, RobotMap.AlignTrack);
//		JoystickButton TriggerOn2 = new JoystickButton(stick2, RobotMap.TriggerOn);
//		JoystickButton TriggerOff2 = new JoystickButton(stick2, RobotMap.TriggerOff);
		
		
		
		//Stick 1 Controls
		JoystickButton CollectorInStick = new JoystickButton(stick, RobotMap.CollectorRetract);
		JoystickButton CollectorOutStick = new JoystickButton(stick, RobotMap.CollectorExtend);
		JoystickButton IntakeStick = new JoystickButton(stick, RobotMap.Intake);
		JoystickButton OuttakeStick = new JoystickButton(stick, RobotMap.Outtake);
		JoystickButton IntakeOutakeStopStick = new JoystickButton(stick, RobotMap.IntakeStop);
		JoystickButton Chevalup = new JoystickButton(stick, RobotMap.ChevalUp);
		JoystickButton Chevaldown = new JoystickButton(stick, RobotMap.ChevalDown);
		JoystickButton LED = new JoystickButton(stick, 5);
//		JoystickButton ShooterWheel = new JoystickButton(stick, RobotMap.ShooterWheelHigh); // ----------
//	    JoystickButton ShooterWheelV = new JoystickButton(stick, RobotMap.ShooterWheelVolt);
		JoystickButton ShooterActuate = new JoystickButton(stick, RobotMap.ShooterActuate);
//		
//		JoystickButton TriggerOn = new JoystickButton(stick, RobotMap.TriggerOn);
//		JoystickButton TriggerOff = new JoystickButton(stick, RobotMap.TriggerOff);
//		
		
		
		  
		
//		a.whenPressed(new ServoPanLeft());
//		b.whenPressed(new ServoPanRight());
		
//		Stick2(Operator) Commands		
		CollectorInStick2.whileHeld(new CollectorIn());			//Collector Retract
		CollectorOutStick2.whileHeld(new CollectorOut());			//Collector Extend
		CollectorInStick2.whenReleased(new CollectorStop());		//Collector Retract Stop
		CollectorOutStick2.whenReleased(new CollectorStop());		//Collector Extend Stop
		IntakeStick2.whenPressed(new IntakeIn());					//Rollers Intake
		OuttakeStick2.whenPressed(new IntakeOut());					//Rollers Outtake
		IntakeOutakeStopStick2.whenPressed(new IntakeStop());		//Roller Stop
//		ShooterAlign.whenPressed(new ScanTele());
//		AllignTracker.whenPressed(new Align());
		Chevalup.whenPressed(new ChevalUp());
		Chevaldown.whenPressed(new ChevalDownHoldCG());
		Chevaldown.whenReleased(new ChevalUp());
		
//		Stick(Driver) Commands
		CollectorInStick.whileHeld(new CollectorIn());			//Collector Retract
		CollectorOutStick.whileHeld(new CollectorOut());			//Collector Extend
		CollectorInStick.whenReleased(new CollectorStop());		//Collector Retract Stop
		CollectorOutStick.whenReleased(new CollectorStop());		//Collector Extend Stop
		IntakeStick.whenPressed(new IntakeIn());					//Rollers Intake
		OuttakeStick.whenPressed(new IntakeOut());				//Rollers Outtake
		IntakeOutakeStopStick.whenPressed(new IntakeStop());		//Roller Stop
		LED.whenPressed(new LEDOn());
		
		
		
		
//		ShooterWheel.whileHeld(new ShooterStartHigh());
//		ShooterWheelV.whileHeld(new ShooterStart_Voltage());
//		ShooterWheel.whenReleased(new ShooterStop());
//		
		ShooterActuate.whenPressed(new ShootBoulder());
//		TriggerOn.whenPressed(new TriggerStart());
//		TriggerOff.whenPressed(new TriggerReset());
		
		
		ShooterWheelLow2.whenPressed(new ShooterWheelLowRetractCG());
		ShooterWheelHigh2.whenPressed(new ShooterWheelHighRetractCG());
		ShooterWheelV2.whenPressed(new ShooterStart_Voltage());
		ShooterWheelHigh2.whenReleased(new ShooterStop());
		ShooterWheelLow2.whenReleased(new ShooterStop());
		ShooterActuate2.whenPressed(new ShootBoulder());
//		TriggerOn2.whenPressed(new TriggerStart());
//		TriggerOff2.whenPressed(new TriggerReset());
		
		
//		TriggerOn.whenReleased((new TriggerOff);
//		ShooterActuate.whenReleased(new TriggerStop());
		//x.whenPressed(new DriveForward(120));
//		r1.whileHeld(new ManipulateUp());
//		l1.whileHeld(new ManipulateDown());
//		r1.whenReleased(new ManipulatorStop());
//		l1.whenReleased(new ManipulatorStop());
		
	}
	
	public Joystick getJoystick1()
	{
		return stick;
	}
	public Joystick getJoystick2()
	{
		return stick2;
	}
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	
}

