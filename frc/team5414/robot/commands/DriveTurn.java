package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTurn extends Command {
	private double DriveTurnSpeed;
	private double TurnAngle;
    public DriveTurn(double speed, double angle) {
        requires(Robot.drivetrain);
        TurnAngle = angle;;
        DriveTurnSpeed = speed;
        setTimeout(2);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.drivetrain.arcadeDrive(DriveTurnSpeed, TurnAngle);
    	double Kp = 0.025;
   double TurnSpeed = (TurnAngle-Robot.drivetrain.getGyroAngle().getAngle())*Kp;
   if(TurnSpeed > .65){
	   TurnSpeed = .65;
   }else if(TurnSpeed < -.65){
	   TurnSpeed = -.65;
   }
    	Robot.drivetrain.arcadeDrive(DriveTurnSpeed, TurnSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.drivetrain.getGyroAngle().getAngle() - TurnAngle) < 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
