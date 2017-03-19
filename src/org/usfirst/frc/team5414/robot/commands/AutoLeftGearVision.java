package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoLeftGearVision extends CommandGroup {

    public AutoLeftGearVision() {
    
    	addSequential(new RaiseArm());
    	addSequential(new DriveEncDist(6));
    	
    	addSequential(new RotateRight(60));
    	addSequential(new DriveEncDistUntilVision(1.5));
    	addSequential(new GoToPeg());

    	addSequential(new DriveEncDist(.5, .6));
////    	
    	addSequential(new ScoringGearCommandGroupAuto());
//    	
//    	addSequential(new DriveEncDist(-3));
//    	
//    	addSequential(new RotateRight(45));
//    	
//    	addParallel(new RaiseArm());
//    	
//    	addSequential(new DriveEncDist(3));
    	
    }
}
