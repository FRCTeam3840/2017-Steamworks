/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Command: ClimbRope
 *  Created 02/20/17
 *  Description:
 *  Climp rope...Calls the ScaleAirShip & dsInformation subSystem
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimbRope extends Command {

    public ClimbRope() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.scaleAirShip);
     //  requires(Robot.dsInformation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.scaleAirShip.climbRopeDrive(Robot.oi.driveXBoxController);
        Robot.dsInformation.alternateColors();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.scaleAirShip.StopClimbRopeDrive();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
