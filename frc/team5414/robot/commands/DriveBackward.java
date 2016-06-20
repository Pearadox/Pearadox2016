package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBackward extends Command {
	private double DriveBackwardSpeed;
	private double distance;
	private double error;
	private double time;
	private final double TOLERANCE = .1;
	

    public DriveBackward() {
    	this(5, -0.6, 5);
    }
    
    public DriveBackward(double dist) {
    	this(dist, 0.6, 5);
    }
    
    public DriveBackward(double dist, double speed) {
    	this(dist, speed, 5);
    }
    
    public DriveBackward(double dist, double speed, double timeout) {
    	requires(Robot.drivetrain);
    	distance = dist;
    	DriveBackwardSpeed = speed;
    	time = timeout;
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.getRightEncoder().reset();
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = (distance + Robot.drivetrain.getRightEncoder().getDistance());
    	Robot.drivetrain.drive(DriveBackwardSpeed, DriveBackwardSpeed);
//    	Robot.drivetrain.drive(DriveBackwardSpeed, DriveBackwardSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (error < TOLERANCE) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
