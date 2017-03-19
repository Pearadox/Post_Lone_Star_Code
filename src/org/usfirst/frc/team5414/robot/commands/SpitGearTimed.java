package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;
import org.usfirst.frc.team5414.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpitGearTimed extends Command {

    public SpitGearTimed() {
        
 
        requires(Robot.gearcollector);
    	
    }

   
    protected void initialize() {
    	setTimeout(1);
    }

    
    protected void execute() {
    	Robot.gearcollector.StartOuttake();			//sets the GearWheelMotors to spit out the gear that has been collected
    }

    
    protected boolean isFinished() { 
		return isTimedOut();
    }

    
    protected void end() {
    	Robot.gearcollector.Stop();			//stops the gear intake & outake motors
    }	

    
    protected void interrupted() {
    }
}
