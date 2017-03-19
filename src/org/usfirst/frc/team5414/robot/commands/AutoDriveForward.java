package org.usfirst.frc.team5414.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {

    public AutoDriveForward(double distance) {

    	addSequential(new DriveEncDist(distance));
    	
    }
}
