/****************************************************************************************
 *  FRC 2017 Steam Works
 *  
 *  Team 3840 (TNT)
 *  Created 02/17/17
 *  Description:
 *  This is the UnClampGear Command...Used clamp gear when the arm is down.  
 *  commands: Unclamping gear
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UnClampGear extends Command {

    public UnClampGear() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.gearGrabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearGrabber.UnClampAction();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
