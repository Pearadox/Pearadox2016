package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurn45 extends Command {

    public GyroTurn45() {
        requires(Robot.drivetrain);
        setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double Kp = 0.025;
    	Robot.drivetrain.arcadeDrive(0, (45-Robot.drivetrain.getGyroAngle().getAngle())*Kp);
    }
    /*protected void execute() {
    	double Kp = 0.025;
    	Robot.drivetrain.arcadeDrive(0, (-80-Robot.drivetrain.getGyroAngle().getAngle())*Kp);
    }*/

    // Make this return true when this Command no longer needs to run execute()  -Robot.drivetrain.getGyroAngle().getAngle())*Kp
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
