package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
    
   private Compressor compressor;
   private DoubleSolenoid sol1;
   private DoubleSolenoid sol2;
   
   public Pneumatics(){
	   super();
	   compressor = new Compressor(3);
	   sol1 = new DoubleSolenoid(2,3);
	   
	   
	   
   }
	
    public void initDefaultCommand() {
    }
    public void compress(){
//    	compressor.start();
    }
    public void shootForward(){
    	sol1.set(DoubleSolenoid.Value.kForward);
    }
    public void shootBackward(){
    	sol1.set(DoubleSolenoid.Value.kReverse);
    }
    public void solOff(){
    	sol1.set(DoubleSolenoid.Value.kOff);
    }
}

