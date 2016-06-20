package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChevalDownHold extends Command {

    public ChevalDownHold() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shovellafries);
    	setTimeout(2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shovellafries.TriggerHold();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(Robot.oi.getJoystick1().getRawButton(RobotMap.ChevalDown)) || isTimedOut();
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
