package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivewithJoystick extends Command {

    public DrivewithJoystick() {
        requires(Robot.drivetrain);
        
    }

  
    protected void initialize() {
    }

   
    protected void execute() {
    	Robot.drivetrain.mecanumDrive(Robot.oi.getJoystick1());		//sets drivetrain default to mechanum drive
    }

   
    protected boolean isFinished() {
        return false;
    }

   
    protected void end() {
    	Robot.drivetrain.stop();		//sets all motorspeeds to 0
    }
   

    protected void interrupted() {
    	end();
    }
}
