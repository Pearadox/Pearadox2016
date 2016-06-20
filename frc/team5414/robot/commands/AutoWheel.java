package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoWheel extends Command {
	double Auto_RPMHigh = 0;
    public AutoWheel() {
        
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	Robot.shooter.BrakeOff();
    	Robot.shooter.changeWheelMode(TalonControlMode.PercentVbus);
    	setTimeout(13);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

//    	Robot.shooter.WheelSpeedHardcodedAuto(12.0);
    	Robot.shooter.WheelSetPVBusSpeed(1.0);
//    	Robot.shooter.Auto_WheelToSpeed(10000);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Preferences prefs = Preferences.getInstance();
    	Auto_RPMHigh = prefs.getDouble("Auto_High", 5000);
        return Robot.shooter.IsWheelToSpeed(Auto_RPMHigh)||
        		isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.shooter.WheelStop();
//    	Robot.shooter.BrakeOn();
//    	Robot.shooter.WheelSpeedHardcodedAuto(9.0);
    	Robot.shooter.changeWheelMode(TalonControlMode.Speed);
    	Robot.shooter.Auto_WheelToSpeed(Auto_RPMHigh);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
