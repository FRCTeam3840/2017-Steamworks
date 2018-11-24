/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Command: EndGameLights
 *  Created 02/11/17
 *  Description:
 *  Changes lights when climbing. 
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class EndGameLights extends Command {

    public EndGameLights() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.dsInformation);
        setTimeout(10);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dsInformation.alternateColors();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
