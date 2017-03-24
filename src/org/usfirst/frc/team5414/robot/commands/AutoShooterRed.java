package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShooterRed extends CommandGroup {

    public AutoShooterRed() {
    	addSequential(new DriveEncDist(.3));
    	addSequential(new RotateRight(93));
    	addSequential(new Shoot(5));
    }
}
