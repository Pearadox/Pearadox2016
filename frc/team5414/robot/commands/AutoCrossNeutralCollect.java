package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossNeutralCollect extends CommandGroup {
    
    public  AutoCrossNeutralCollect() {
        addSequential(new DriveForward(500,.6));
        addSequential(new DriveBackward(500,.6));
        //INSERT COLLECTOR CODE HERE
    }
}
