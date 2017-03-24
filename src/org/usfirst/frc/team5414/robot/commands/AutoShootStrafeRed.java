package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShootStrafeRed extends CommandGroup {

    public AutoShootStrafeRed() {
        
    	addSequential(new ActivateMecanum());
    	
    	addSequential(new Shoot(7));
    	
    	addSequential(new StrafeLeft(1, Robot.prefs.getDouble("AUTO_STRAFE_TIME", 4)));
    }
}
