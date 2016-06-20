package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterStartHigh extends Command {
	double pref_RPMHigh = 0;
    public ShooterStartHigh() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.Shooter);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.BrakeOff();
    	Robot.shooter.changeWheelMode(TalonControlMode.PercentVbus);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Preferences prefs = Preferences.getInstance();
    	pref_RPMHigh = prefs.getDouble("RPM_High", 5000);
    	if(Robot.shooter.IsWheelToSpeed(pref_RPMHigh))
    	{
    		Robot.shooter.WheelSetPVBusSpeed(0);
    	}
    	else
    	{
    		Robot.shooter.WheelSetPVBusSpeed(1.0);
    	}
//    	Robot.shooter.WheelToSpeedHigh();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return !(Robot.oi.getJoystick2().getRawButton(RobotMap.ShooterWheelHigh));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.WheelStop();
    	Robot.shooter.BrakeOn();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
