package org.usfirst.frc.team5414.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterWheel extends Subsystem {
    private CANTalon wheel = new CANTalon(0);
    private double pref_RPMHigh;
    private double pref_RPMLow;
    private double AutoRPM;
    
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public ShooterWheel() {
    	super();
    	wheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	wheel.reverseSensor(false);
    	wheel.configEncoderCodesPerRev(20);
    	wheel.configNominalOutputVoltage(+0.0f, -0.0f);
    	wheel.configPeakOutputVoltage(+12.0f, -0.0f);
//    	wheel.setVoltageCompensationRampRate(24.0);//0-12V in 50 ms
//    	wheel.changeControlMode(TalonControlMode.Voltage);
//    	/* uncomment if we want to use PID */
    	
		wheel.setProfile(0);
        wheel.setF(2.3);
        wheel.setP(2);
        wheel.setI(0); 
        wheel.setD(0);
    	
    }
    public void WheelToSpeedHigh(){
    	Preferences prefs = Preferences.getInstance();
    	pref_RPMHigh = prefs.getDouble("RPM_High", 5000);
    	
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	SmartDashboard.putNumber("Desired", pref_RPMHigh);
    	SmartDashboard.putNumber("OutputVoltage", wheel.getOutputVoltage()/wheel.getBusVoltage());
//    	double WheelMotorSet;
//    	wheel.changeControlMode(TalonControlMode.PercentVbus);
//		if(wheel.getEncVelocity() < pref_RPM)
//    	{
//    		WheelMotorSet = 1.0;
//    	}
//    	else
//    	{
//    		WheelMotorSet = 0.0;
//    	}
//		SmartDashboard.putNumber("MotorOutput Value", WheelMotorSet);
//    	wheel.set(WheelMotorSet);
    	// if closed loop is desired, use below
    	
//    	wheel.changeControlMode(TalonControlMode.Speed);
    	wheel.set(pref_RPMHigh);
    	 
    }
    public void WheelToSpeedLow(){
    	Preferences prefs = Preferences.getInstance();
    	pref_RPMLow = prefs.getDouble("RPM_Low", 800);
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	wheel.set(pref_RPMLow);
    }
    public boolean IsWheelToSpeed(double Speed)
    {
    	return (wheel.getSpeed() > Speed);
    }
    public void WheelSetPVBusSpeed(double Speed) {
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	wheel.set(Speed);
    }
    public void Auto_WheelToSpeed(double AutoSpeed){
    	
    	
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	SmartDashboard.putNumber("Desired", pref_RPMHigh);
    	SmartDashboard.putNumber("OutputVoltage", wheel.getOutputVoltage()/wheel.getBusVoltage());
    	wheel.set(AutoSpeed);
    	 
    }
    public void WheelSpeedHardcoded() {
    	Preferences prefs = Preferences.getInstance();
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	double pref_WheelVs = prefs.getDouble("WheelVoltage", 12);
    	wheel.set(pref_WheelVs);
    }
    
    public void WheelSpeedHardcodedAuto(double AutoVolt) {
    	SmartDashboard.putNumber("Shooter Speed", wheel.getSpeed());
    	wheel.set(AutoVolt);
    }
    
    
    public void WheelStop() {
    	wheel.set(0);
    }
    public void ShooterIntake() {
    	wheel.changeControlMode(TalonControlMode.PercentVbus);
    	wheel.set(-.3);
    }
    public void BrakeOn() {
    	wheel.enableBrakeMode(true);    	
    }
    public void BrakeOff() {
    	wheel.enableBrakeMode(false);
    }
    public void changeWheelMode(TalonControlMode mode){
    	wheel.changeControlMode(mode);
    }
    public void getValues(){
    	Preferences prefs = Preferences.getInstance();
    	double pref_WheelVs = prefs.getDouble("WheelVoltage", 8.3);
    	double robot_Current =  wheel.getOutputCurrent();
    	SmartDashboard.putNumber("Desired Wheel Voltage", pref_WheelVs);
    	SmartDashboard.putNumber("Wheel Current", robot_Current);
    }
}

