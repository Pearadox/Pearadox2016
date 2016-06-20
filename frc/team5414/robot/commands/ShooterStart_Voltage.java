package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShooterStart_Voltage extends Command {

    public ShooterStart_Voltage() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.Shooter);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.getValues();
    	Robot.shooter.BrakeOff();
    	Robot.shooter.changeWheelMode(TalonControlMode.Voltage);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.shooter.getValues();
    	Robot.shooter.WheelSpeedHardcoded();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !(Robot.oi.getJoystick2().getRawButton(RobotMap.ShooterWheelVolt)); //stop executing when RawButton is released.
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.WheelStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.WheelStop();
    	Robot.shooter.BrakeOn();
    }
}
