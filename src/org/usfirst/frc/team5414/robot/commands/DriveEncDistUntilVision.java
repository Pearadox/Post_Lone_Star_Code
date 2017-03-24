package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveEncDistUntilVision extends Command implements PIDOutput{
	double initDistance;
	double distance;
	double originalAngle;
	double kP = RobotMap.GyrokP;
	double kI = RobotMap.GyrokD;
	double kD = RobotMap.GyrokI;
	final double kToleranceDegrees = 0.0f;
	double speed = 0.5;
	Preferences prefs;
	PIDController twistpid;
	double PIDOut;
	double targetFeet;
	double drivep = .1;
	double[] CenterArray;
	
    public DriveEncDistUntilVision(double d) {
    	targetFeet = d;
    	distance = d / RobotMap.LengthPerTick;
    	requires(Robot.drivetrain);
    	requires(Robot.gyro);
    	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.FullTraction();
    	prefs = Preferences.getInstance();
    	kP = prefs.getDouble("GyrokP", RobotMap.GyrokP);
    	kI = prefs.getDouble("GyrokI", RobotMap.GyrokI);
    	kD = prefs.getDouble("GyrokD", RobotMap.GyrokD);
    	Robot.gyro.zeroYaw();
    	
    	originalAngle = Robot.gyro.getYaw();
    	initDistance = Robot.drivetrain.getEncoderBL();
    	twistpid = new PIDController(kP, kI, kD, Robot.gyro, this, .01);
    	twistpid.setInputRange(-360, 360);
    	twistpid.setOutputRange(-1.0, 1.0);
    	twistpid.setContinuous(true);
    	twistpid.setAbsoluteTolerance(kToleranceDegrees);
    	twistpid.setSetpoint(originalAngle);
    	twistpid.enable();
    	
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	CenterArray = Robot.table.getNumberArray("centerX", new double[0]);
    	
    	double changeInAngle = Robot.gyro.getYaw()-originalAngle;
    	if(Robot.drivetrain.getEncoderBL() < (initDistance + distance) && targetFeet >= 0)
    	{
    		//Robot.drivetrain.arcadeDrive(-changeInAngle*PIDOut,.6);
    		Robot.drivetrain.arcadeDrive(Robot.gyro.getYaw() * drivep, .7);
    	}
	else if(Robot.drivetrain.getEncoderBL() > (initDistance + distance))
	{
		//.drivetrain.arcadeDrive(-changeInAngle*PIDOut, -.6);
		Robot.drivetrain.arcadeDrive(Robot.gyro.getYaw() * drivep, -1);
	}
//    	kP = prefs.getDouble("Drive kP", kP);
//    	kI = prefs.getDouble("Drive kI", kI);
//    	kD = prefs.getDouble("Drive kD", kD);
//    	speed = prefs.getDouble("Speed", speed);
//    	SmartDashboard.putNumber("(prefs) Drive kP", kP);
//    	SmartDashboard.putNumber("(prefs) Drive kI", kI);
//    	SmartDashboard.putNumber("(prefs) Drive kD", kD);
//    	SmartDashboard.putNumber("(prefs)", speed);
    	SmartDashboard.putNumber("Difference In Angle", Robot.gyro.getYaw() - originalAngle);
//    	System.out.println("DRIVE");
//    	twistpid.setPID(kP, kI, kD);
//    	twistpid.setSetpoint(originalAngle);
//    	twistpid.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.drivetrain.getEncoderBL() >= initDistance + distance && targetFeet >= 0){
    		return true;
    	}
    	else if((Robot.drivetrain.getEncoderBL() <= (initDistance + distance)) && targetFeet < 0)
    	{
    		return true;
    	}
    	if (CenterArray.length >1 ) {
    		return true;
    	}
    	
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {

    	Robot.drivetrain.stop();
    	twistpid.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	int times = 0;
	public void pidWrite(double output) {		
		PIDOut = output;
	}
}
