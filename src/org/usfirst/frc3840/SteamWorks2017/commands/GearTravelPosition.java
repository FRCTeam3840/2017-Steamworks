package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 2017 FRC SteamWorks
 * Team 3840
 */
public class GearTravelPosition extends Command {
	final String Placement = "Travel";

    public GearTravelPosition() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.gearMover);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gearMover.setAbsoluteTolerance(0.05);
    	Robot.gearMover.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("POT Value: ", Robot.gearMover.gearPositioner.getAverageVoltage());
    	Robot.gearMover.MoveGearArmToPosition(Placement);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.gearMover.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
