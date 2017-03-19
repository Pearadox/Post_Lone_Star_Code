package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.OI;
import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterAxis extends Command {

    public ShooterAxis() {
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.operatorStick.getRawAxis(3) > 0)
    	{
    		Robot.shooter.shoot();
    	}
    	else Robot.shooter.stop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
