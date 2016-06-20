package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGyro extends CommandGroup {
    
    public  AutoGyro() {
        addSequential(new DriveForward(200,.6, 8));
        addSequential(new GyroTurn45());
    }
}
