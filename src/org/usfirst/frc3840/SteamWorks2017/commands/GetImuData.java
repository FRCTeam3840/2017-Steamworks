package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GetImuData extends Command {

    public GetImuData() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.imuData);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.imuData.SendDataToSmartDashboard();
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
