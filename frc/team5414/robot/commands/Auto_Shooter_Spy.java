package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_Shooter_Spy extends CommandGroup {
    
    public  Auto_Shooter_Spy() {
    	
    	addSequential(new AutoWheel());
        addSequential(new TriggerStart());
    	addSequential(new TriggerReset());
    	addSequential(new WheelStop());
    	addSequential(new DriveForward(18.84*.5,.8));
    	addSequential(new DriveTurn(-.8,45));
    	addSequential(new DriveTurn(0,135));
    	addSequential(new DriveForward(18.84*2.95,.65));
    	addSequential(new DriveTurn(0,-50));
    	addSequential(new DriveForward(18.84*9,.8));
    	
    	
    	
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
