package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoToBatter extends CommandGroup {
    
    public  AutoToBatter() {
        addSequential(new DriveForward(20));
    }
}
