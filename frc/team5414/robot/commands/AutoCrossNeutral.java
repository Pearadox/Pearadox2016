package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCrossNeutral extends CommandGroup {
    
    public  AutoCrossNeutral() {
    	addSequential(new DriveForward(500,.6));
        addSequential(new DriveBackward(500,.6));
    }
}
