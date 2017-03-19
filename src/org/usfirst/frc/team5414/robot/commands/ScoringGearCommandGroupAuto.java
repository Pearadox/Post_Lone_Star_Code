package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoringGearCommandGroupAuto extends CommandGroup {

    public ScoringGearCommandGroupAuto() {

    	
    	addParallel(new SpitGearTimed());
    	addParallel(new LowerArm());
    	addParallel(new DriveEncDist(-1.0, .6));
    }
}
