package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Manipulator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private CANTalon manipulate;
	Encoder shooterEncoder;
	public Manipulator(){
		
		manipulate = new CANTalon(2);
//		shooterEncoder = new Encoder(4,5,false,EncodingType.k4X); 
		
		
		
		LiveWindow.addSensor("Shooter", "Shooter Encoder", shooterEncoder);
	}
	public void armsUp(){
    	manipulate.set(1);
    }
    public void armsDown(){
    	manipulate.set(-1);
    }
    public void armsStop(){
    	manipulate.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

