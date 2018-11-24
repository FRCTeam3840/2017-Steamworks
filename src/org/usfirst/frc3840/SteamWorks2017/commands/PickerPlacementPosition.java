package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PickerPlacementPosition extends Command {
	final String MidLocation = "ArmMiddleLocation";

    public PickerPlacementPosition() {
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
    	Robot.frontMover.MoveIntakeArmToPosition(MidLocation);
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
