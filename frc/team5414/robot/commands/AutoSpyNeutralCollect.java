package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoSpyNeutralCollect extends CommandGroup {
    
    public  AutoSpyNeutralCollect() {
    	addSequential(new DriveForward(500,.6));
    	addSequential(new AngleBackup());
    	addSequential(new DriveBackward(500,.6));
    	addSequential(new GyroTurn45());
    	addSequential(new DriveBackward(300,.6));
    	
    	//INSERT COLLECTOR CODE HERE
    }
}
