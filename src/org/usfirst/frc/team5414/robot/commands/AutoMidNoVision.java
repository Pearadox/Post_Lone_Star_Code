package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMidNoVision extends CommandGroup {

    public AutoMidNoVision() {
    	addSequential(new DriveEncDist(3));
    	addSequential(new ScoringGearCommandGroup());
    }
}
