package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_CrossDefense_EndinNeutral extends CommandGroup {

    public Auto_CrossDefense_EndinNeutral() {
    	requires(Robot.drivetrain);
    	addSequential(new DriveForward(18.84*5, 0.6));
    	addSequential(new Pause());
    	addSequential(new DriveBackward(18.85*4, 0.6));
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    }
}
