package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	private SpeedController deploy;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Collector() {
    	super();
    	deploy = new Spark(4);
    }
    public void CollectorIn(){
    	deploy.set(.7);
    }
    public void CollectorOut(){
    	deploy.set(-1);
    }
    public void CollectorStop(){
    	deploy.set(0);
    }
    
    
}

