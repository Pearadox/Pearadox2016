package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 */
public class ShovelLaFries extends Subsystem {
    private SpeedController ChevalTriggerLeft;
    private SpeedController ChevalTriggerRight;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public ShovelLaFries(){
    	super();
    	ChevalTriggerLeft = new Spark(7);
    	ChevalTriggerRight =  new Spark(8);
    }
    public void TriggerDown(){
    	ChevalTriggerLeft.set(-1);
    	ChevalTriggerRight.set(1);
    }
    public void TriggerHold(){
    	ChevalTriggerLeft.set(-.6);
    	ChevalTriggerRight.set(.6);
    }
    public void TriggerUp(){
    	ChevalTriggerLeft.set(.35);
    	ChevalTriggerRight.set(-.35);
    }
    public void ChevalStop(){
    	ChevalTriggerLeft.set(0);
    	ChevalTriggerRight.set(0);
    }
}

