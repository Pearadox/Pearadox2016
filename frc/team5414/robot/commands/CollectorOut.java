package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorOut extends Command {

    public CollectorOut() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.CollectorOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !(Robot.oi.getJoystick2().getRawButton(RobotMap.CollectorExtend)||Robot.oi.getJoystick1().getRawButton(RobotMap.CollectorExtend));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.collector.CollectorStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
