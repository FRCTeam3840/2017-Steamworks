package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 2017 FRC SteamWorks
 * Team 3840
 */
public class ManualMoveGear extends Command {

    public ManualMoveGear() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.gearMover);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearMover.MoveGearArm(Robot.oi.actuatorsController);
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
