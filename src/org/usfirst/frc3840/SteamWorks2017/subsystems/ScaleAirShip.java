// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import org.usfirst.frc3840.SteamWorks2017.commands.ClimbRope;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  FRC 2017 Steam Works
 *  Team 3840
 */
public class ScaleAirShip extends Subsystem {

    private final CANTalon climber = RobotMap.climberMotor;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimbRope());
    }
    
  //Climb Rope from climbDrive Xbox Controller Usb 1 input    
    public void climbRopeDrive(XboxController driveXBoxController) {
    	double posThreshold = 0.1;  //default threshold value from xBox Controller
    	double dblPositive = driveXBoxController.getRawAxis(3);       
    
    	//Positive rotation of climber
    	if(Math.abs(dblPositive) > posThreshold|| true) { 
    		climber.set(dblPositive);
    	}

    	//update motor status while climber
    	this.MotorStatus();
    }
    
    //Stop climbing
    public void StopClimbRopeDrive() {
    	climber.set(0);
    }
    
    //Motor Status while Climber Motor Runs
    private void MotorStatus() {
    	SmartDashboard.putNumber("Motor5 Current: ", climber.getOutputCurrent());
    	SmartDashboard.putNumber("Motor5 Speed: ", climber.getOutputVoltage());
    }
}
