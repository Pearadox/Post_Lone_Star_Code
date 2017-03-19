 package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShooterBlue extends CommandGroup {

    public AutoShooterBlue() {
    	
//    	addSequential(new DriveEncDist(.3));
//    	addSequential(new RotateLeft(93));
    	addSequential(new ContinuouslyShoot());
    }
}
