package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCross_Defense_TurnTower extends CommandGroup {
    
    public  AutoCross_Defense_TurnTower() {
    	requires(Robot.drivetrain);
    	addSequential(new DriveForward(18.84*4, 0.6));
    	addSequential(new Pause());
    	addSequential(new GyroTurn45());
    	addSequential(new Pause());
    	addSequential(new DriveForward(18.84*2, 0.6));
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
