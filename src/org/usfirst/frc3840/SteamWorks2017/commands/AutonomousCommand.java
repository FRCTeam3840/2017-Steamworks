
package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * 2017 SteamWorks FRC
 * Team 3840
 */
public class AutonomousCommand extends CommandGroup {

   
    public AutonomousCommand() {
    	addParallel(new DriveStraightCommand());
    	requires(Robot.driveTrain);
    }


 
}
