package org.usfirst.frc.team5414.robot.commands;

import java.util.Arrays;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Scanner extends Command {

	double error = 0;
    public Scanner() {
        requires(Robot.drivetrain);
        
        setTimeout(1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.LEDOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.containsArea()==false){
    		Robot.drivetrain.drive(0,0);
    		
    	}
    	else if(Robot.containsArea()==true){
    		Robot.drivetrain.drive(-.53, .53);
    	}
    	
    	SmartDashboard.putBoolean("Contains Area", Robot.containsArea());

    	
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.containsArea()==false){
    		return true;
    		
    	}else{
    		return false;
    	}
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
