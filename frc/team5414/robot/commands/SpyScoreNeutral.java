package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SpyScoreNeutral extends CommandGroup {
    
    public  SpyScoreNeutral() {
    	requires(Robot.drivetrain);
    	addSequential(new DriveForward(140,.5));
    	addSequential(new Pause());
    	addSequential(new AngleBackup());
//    	addSequential(new GyroTurn45());
    	addSequential(new DriveBackward(500,.6,5));
    	
      	
    	

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
