package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForward extends Command {
	private double DriveForwardSpeed;
	private double distance;
	private double error;
	private double time;
	double DKp = .02;
	private final double TOLERANCE = .15;
	

    public DriveForward() {
    	this(5, 0.6, 5);
    }
    
    public DriveForward(double dist) {
    	this(dist, 0.6, 5);
    }
    
    public DriveForward(double dist, double speed) {
    	this(dist, speed, 5);
    }
    
    public DriveForward(double dist, double speed, double timeout) {
    	requires(Robot.drivetrain);
    	distance = dist;
    	DriveForwardSpeed = speed;
    	time = timeout;
    }
    
    public DriveForward(double dist, double speed, double timeout, double DKp) {
    	requires(Robot.drivetrain);
    	distance = dist;
    	DriveForwardSpeed = speed;
    	time = timeout;
    	
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.getRightEncoder().reset();
    	Robot.drivetrain.getGyroAngle().reset();
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double Kp = .03;
    	
    	SmartDashboard.putNumber("Right Encoder", Robot.drivetrain.getRightEncoder().getDistance());
    	error = (distance - Robot.drivetrain.getRightEncoder().getDistance());
    	
    	Robot.drivetrain.arcadeDrive(-DriveForwardSpeed, (-(Robot.drivetrain.getGyroAngle().getAngle()) * Kp+.1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((error) <= 0) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }
    //bharathisapro
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
