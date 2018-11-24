/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Command: IntakeLowPosition
 *  Created 02/11/17
 *  Description:
 *  This is the Command to call the FrontMover PIDSubsystem...Used to mover up and down the front arm for ball handler or moving gears.  
 *  This is calls the subsystem with location key for pot setpoint.
 * ****************************************************************************************
*/
package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PickerLowPosition extends Command {
	final String LowLocation = "ArmDownLocation";

    public PickerLowPosition() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.frontMover);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.frontMover.setAbsoluteTolerance(0.05);
    	Robot.frontMover.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Picker POT Value: ", Robot.frontMover.armPositioner.getAverageVoltage());
    	Robot.frontMover.MoveIntakeArmToPosition(LowLocation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.frontMover.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
