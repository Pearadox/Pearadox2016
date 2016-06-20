package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.commands.triggerHoldPosition;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shootertrigger extends Subsystem {
    private SpeedController Trigger;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	triggerCommand = (command) Robot.
//    	setDefaultCommand(new triggerHoldPosition());
    }
    public Shootertrigger() {
    	super();
    	Trigger = new Spark(6);
    	
    }
    public void triggerOn(){
    	Trigger.set(1);
    	
    }
    public void triggerOff(){
    	Trigger.set(0);    	
    }
    public void triggerRelease(){
    	Trigger.set(-1);
    }
    public void triggerHold(){
    	
    	Trigger.set(-0.4);
    }
}


