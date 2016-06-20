package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	private SpeedController intake;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Intake() {
    	super();
    	intake = new Spark(5);
    }
    public void ballin(){
    	intake.set(-1);
    }
    public void ballout(){
    	intake.set(1);
    }
    public void ballstop(){
    	intake.set(0);
    }













}

