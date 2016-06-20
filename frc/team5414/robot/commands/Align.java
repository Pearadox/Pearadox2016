package org.usfirst.frc.team5414.robot.commands;


import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Align extends Command {
	
	double error = 0, app = 0.25, angle = 0, kp = .03;
	double centerX = 0;
	double centerY = 0;
        double Xmax=0;
    	double Xmin=0;
	public Align() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.resetGyroAngle();
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Preferences prefs = Preferences.getInstance();
    	Xmin = prefs.getDouble("Xmin", 380);
    	Xmax = prefs.getDouble("Xmax", 390);
    	double kP = prefs.getDouble("TurnKp", 1.5);
    	double speed = .55;
    	double max = 0;
    	int maxind = 0;
    	
    	NetworkTable grip1 = NetworkTable.getTable("GRIP/myContoursReport");
    	error = Robot.centerX()-80;
    	double[] areaarray  = grip1.getNumberArray("area", new double[0]);
    	double[] centerXarray = grip1.getNumberArray("centerX", new double[0]);
    	double[] centerYarray = grip1.getNumberArray("centerY", new double[0]);
    	
    	if(areaarray.length!=0)
    	{
    		max = areaarray[0];
    		for (int i = 1; i<areaarray.length; i++)
    		{
    			if (areaarray[i]>max && areaarray[i]>400)
    			{
    				max = areaarray[i];
    				maxind = i;
    			}
    		}
    		centerX = centerXarray[maxind];
    		centerY = centerYarray[maxind];
    	}
		SmartDashboard.putNumber("Align Max", max);
		SmartDashboard.putNumber("Align CenterX", centerX);
		
		speed = Math.abs(centerX - ((Xmax+Xmin)/2)) * kP;
		SmartDashboard.putNumber("Turn Speed", speed);
		if (speed > 0.6)
			speed = .6;
		if(speed < 0.3 )
			speed = .3;
    	if(centerX <Xmin || centerX >Xmax)
    	{
        	if(centerX<Xmin )
        	{
        		 
        		SmartDashboard.putString("ExecuteAlign", "<Xmin");
        		Robot.drivetrain.drive(-speed, 0);
        	}
        	if(centerX>Xmax ){	
        		SmartDashboard.putString("ExecuteAlign", ">Xmax");
        		Robot.drivetrain.drive(0, -speed);	
    	    	
        	}	
    	}
    	else
    	{
    		SmartDashboard.putString("ExecuteAlign", "Other");	
    	}
    	if(centerX > Xmin && centerX < Xmax)
    	{
    		Robot.drivetrain.drive(0, 0);
    		setTimeout(.5);
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if((centerX >=Xmin) && (centerX <=Xmax)){
//    		SmartDashboard.putString("Align?", "yes");
//    		return true;
//    	}
//    	SmartDashboard.putString("Align?", "no");
    	return !(Robot.oi.getJoystick2().getRawButton(RobotMap.ShooterAlign));
    }

    // Called once after isFinished returns true
    	

    protected void end() {
    	Robot.drivetrain.drive(0,0);
    	Robot.drivetrain.LEDOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
