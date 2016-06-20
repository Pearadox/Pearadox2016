package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChevalUp extends Command {

    public ChevalUp() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shovellafries);
    	setTimeout(.75);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shovellafries.TriggerUp();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (!(Robot.oi.getJoystick1().getRawButton(RobotMap.ChevalDown))|| !Robot.oi.getJoystick1().getRawButton(RobotMap.ChevalUp))
		{
		return isTimedOut();
		}
		else
		{
		return false;
		}
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shovellafries.ChevalStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
