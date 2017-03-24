package org.usfirst.frc.team5414.robot.commands;

import org.usfirst.frc.team5414.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMidNoVision extends CommandGroup {

    public AutoMidNoVision() {
    	
    	double distance = Robot.prefs.getDouble("AUTO_MID_DISTANCE", 4.5);
    	double speed = Robot.prefs.getDouble("AUTO_SPEED", 5.5);
    	addSequential(new DriveEncDist(distance, speed));
    	Timer.delay(1);
    	addSequential(new ScoringGearCommandGroup());
    }
}
