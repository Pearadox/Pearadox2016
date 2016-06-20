package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLowDestroy extends CommandGroup {
    
    public  AutoLowDestroy() {
    	addSequential(new DriveForward(18.84*9, .8));
    	addSequential(new Pause());
    	addSequential(new DriveTurn(0, 172));
    	addSequential(new DriveForward(18.84*7, .8));
    	
    	addSequential(new DriveTurn(0, 180));
    	
  
    	
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
