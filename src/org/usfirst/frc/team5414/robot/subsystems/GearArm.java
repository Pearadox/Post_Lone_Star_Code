package org.usfirst.frc.team5414.robot.subsystems;

import org.usfirst.frc.team5414.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.FeedbackDeviceStatus;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearArm extends Subsystem {

	public CANTalon GearArm;
	
	
	public GearArm() {
		super();
		GearArm = new CANTalon(RobotMap.DIOGearArm);
		GearArm.setPosition(0);
        GearArm.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
        GearArm.reverseSensor(false);
        GearArm.configNominalOutputVoltage(+0f, -0f);
        GearArm.configPeakOutputVoltage(+12f, -12f);
        GearArm.setAllowableClosedLoopErr(RobotMap.ArmError); 
        GearArm.setProfile(0);
        GearArm.setF(RobotMap.ArmkF);
        GearArm.setP(RobotMap.ArmkP);
        GearArm.setI(RobotMap.ArmkI); 
        GearArm.setD(RobotMap.ArmkD);
        GearArm.changeControlMode(TalonControlMode.Position);
        
		//declaring the location of the arm electrically
	}
    
	public double currentposition()
	{
		return GearArm.getPosition();
	}

	
    public void initDefaultCommand() {
    	
    }
    public void setPosition(double targetPositionRotations){
    	boolean sensor;
    	if(GearArm.isSensorPresent(FeedbackDevice.CtreMagEncoder_Absolute) == FeedbackDeviceStatus.FeedbackStatusPresent){
    		sensor = true;
    		GearArm.changeControlMode(TalonControlMode.Position);
           	GearArm.set(targetPositionRotations);
           	SmartDashboard.putBoolean("SensorPresent?", sensor);
    	}else{
    		sensor = false;
    		SmartDashboard.putBoolean("SensorPresent?", sensor);
    	}
    	
    }
    
    public void setTalonMode(){
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    }
    
    public void raise(double upSpeed) {
    	
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(-upSpeed);			//sets the raising speed to the gear collector
    }
    public void lower(double downSpeed) {
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(downSpeed);
    }
    public void stop() {
    	GearArm.changeControlMode(TalonControlMode.PercentVbus);
    	GearArm.set(0);
    }
}

