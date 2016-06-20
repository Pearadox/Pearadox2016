	package org.usfirst.frc.team5414.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	public static int CollectorRetract = 12;
	public static int CollectorExtend = 8;
	
	public static int Intake = 11;
	public static int Outtake = 7;	
	public static int IntakeStop  = 9;
	
	public static int TriggerOn = 15;
	public static int TriggerOff = 13;
	public static int ShooterWheelHigh = 2;
	public static int ShooterWheelLow = 3;
	public static int ShooterWheelVolt = 3;
	public static int ShooterActuate = 1;
	public static int ShooterAlign = 4;
	
	
	public static int ChevalDown = 3;
	public static int ChevalUp = 6;
	
	public static int AlignTrack = 10;
	
	public static int LED = 5;

}
