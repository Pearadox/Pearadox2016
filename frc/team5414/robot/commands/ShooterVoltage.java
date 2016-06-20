package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterVoltage extends Command {

    public ShooterVoltage() {
        
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.BrakeOff();
    	Robot.shooter.changeWheelMode(TalonControlMode.Voltage);
    	setTimeout(2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if(isTimedOut()){
			Robot.shooter.WheelSpeedHardcodedAuto(9.0);
		}else{
			Robot.shooter.WheelSpeedHardcodedAuto(12.0);
		}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  (Robot.oi.getJoystick2().getRawButton(RobotMap.ShooterActuate));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.WheelStop();
    	Robot.shooter.BrakeOn();
//    	Robot.shooter.WheelSpeedHardcodedAuto(9.0);
//    	Robot.shooter.Auto_WheelToSpeed(4000);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
