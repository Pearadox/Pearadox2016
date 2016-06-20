package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private SpeedController leftf_motor, rightf_motor, leftb_motor, rightb_motor;//, collector_motor;
	private RobotDrive drive;
	private Encoder rightEncoder, leftEncoder;
	private AnalogGyro gyro;
	private Servo servo;
	private Solenoid solenoidlight = new Solenoid(0);

	double limitedSpeed = 0;
	double limitedrotate = 0;
//	private CANTalon manipulate;
	
	PIDController motorControl;
	
	private double Speed;
	private double rotate;
	
	public Drivetrain() {
		super();
		leftf_motor = new Victor(0);
		leftb_motor = new Victor(1);
		rightf_motor = new Victor(2);
		rightb_motor = new Victor(3);
//		collector_motor = new Victor(4);
		leftf_motor.setInverted(Boolean.TRUE);
		leftb_motor.setInverted(Boolean.TRUE);
		rightf_motor.setInverted(Boolean.TRUE);
		rightb_motor.setInverted(Boolean.TRUE);
		
		drive = new RobotDrive(leftb_motor, leftf_motor, rightb_motor, rightf_motor);
		gyro = new AnalogGyro(0);
		
		gyro.setSensitivity(.007);
//		servo = new Servo(2);
		leftEncoder = new Encoder(0, 1, false, EncodingType.k4X);
		rightEncoder = new Encoder(2, 3, true, EncodingType.k4X);

		motorControl = new PIDController(0, 0, 0, leftEncoder, leftf_motor);
		//manipulate = new CANTalon(2);
		leftEncoder.setDistancePerPulse((18.84/210));
		rightEncoder.setDistancePerPulse((-18.84/210));
//		rightEncoder.setReverseDirection(false);

		leftEncoder.setReverseDirection(true);
		
//		manipulate.reverseOutput(true);
//		manipulate.reverseSensor(true);
//		manipulate.enableLimitSwitch(true , true);
//		manipulate.ConfigFwdLimitSwitchNormallyOpen(true);
//		manipulate.ConfigRevLimitSwitchNormallyOpen(true);
//		manipulate.enableControl();
		
		LiveWindow.addSensor("Drivetrain", "Right Encoder", rightEncoder);
		LiveWindow.addSensor("DriveTrain", "Left Encoder", leftEncoder);

		
//		LiveWindow.addActuator("Drive Train", "Left Motor", (Talon) leftf_motor);
//		LiveWindow.addActuator("Drive Train", "Right Motor", (Talon) rightb_motor);
		
//		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right) {
    	drive.tankDrive(left, right);

		SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    }
    public void arcadeDrive(double speed ,double angle){
    	drive.arcadeDrive(speed, angle);
    }
    
    public void drive(Joystick stick) {
    	drive(stick.getRawAxis(1), stick.getRawAxis(5));
    }
    public void arcadeDrive(Joystick stick, Joystick stick2){
    	double x;
    	double r;
    	double speedlimit = 0.1; 
    	double rotatelimit = 0.1;
    	double SpeedChange;
    	double rotateChange;
    	
    	SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    	if(stick.getRawButton(10) == false)
    	{
    		x = stick.getRawAxis(1);
    		r = stick.getRawAxis(2);
    		if (r>.1){
    			rotate=(0.864*(Math.pow((r-0.1),2))+.3);
    			if (rotate > 1.0) 
    				rotate = 1.0; 
    		}
    		else if (r <-.1){
    			rotate=(0.864*(Math.pow(((-1*r)-0.1),2))+.3)*-1;
    			if (rotate < -1.0)
    				rotate = -1.0;
    		}
    		else
    			rotate=0;
    		if (x>.1){
    			Speed=(0.864*(Math.pow((x-0.1),2))+.3);
    			if (Speed > 1.0) 
    				Speed = 1.0; 
    		}
    		else if (x <-.1){
    			Speed=(0.864*(Math.pow(((-1*x)-0.1),2))+.3)*-1;
    			if (Speed < -1.0)
    				Speed = -1.0;
    		}
    		else
    			Speed=0;
    		
    		SpeedChange = Speed - limitedSpeed; 
    		if(SpeedChange > speedlimit)
    			SpeedChange = speedlimit;
    		else if (SpeedChange < (-speedlimit))
    			SpeedChange = -speedlimit;
    		limitedSpeed += SpeedChange;
    		
    		rotateChange = rotate - limitedrotate; 
    		if(rotateChange > rotatelimit)
    			rotateChange = rotatelimit;
    		else if (rotateChange < (-rotatelimit))
    			rotateChange = -rotatelimit;
    		limitedrotate += rotateChange;
    			
    		drive.arcadeDrive(x, (r));
    	}
    	else
    	{
    		x = stick.getRawAxis(2);
    		if (x>.1)
    			Speed=.864*(Math.pow((Math.abs(x)-0.1),2)+3);
    		else if (x<-.1)
    			Speed=.864*(Math.pow((Math.abs(x)-0.1),2)+.3)*-1;
    		else
    			Speed=0;
    		drive.arcadeDrive(stick2.getRawAxis(1), (stick2.getRawAxis(2)*.6));
    		
        }
    	
    }

    public void LEDOn(){
    	solenoidlight.set(true);
    }
    
    public void LEDOff(){
    	solenoidlight.set(false);
    }
    
    
    public void stop() {
    	drive.tankDrive(0, 0);
    }
    
    public Encoder getLeftEncoder() {
    	return leftEncoder;
    }
    public Gyro getGyroAngle() {
    	return gyro;
    }
    public void resetGyroAngle() {
    	gyro.reset();
    }
    
    public Encoder getRightEncoder() {
    	return rightEncoder;
    }
    public void setServoLeft(){
    	servo.setAngle(45);
    }
    public void setServoRight(){
    	servo.setAngle(-45);
    }
//    public void CollectorIn(){
//    	collector_motor.set(.3);
//    }
//    public void CollectorOut(){
//    	collector_motor.set(-.3);
//    }
//    public void CollectorStop(){
//    	collector_motor.set(0);
//    }
}

