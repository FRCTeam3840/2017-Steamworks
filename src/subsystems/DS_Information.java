/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Sub System: DS_Information
 *  Created 02/11/17
 *  Description:
 *  This monitors the driver station information for controlling led lights. 
 * ****************************************************************************************
*/
package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import com.mindsensors.CANLight;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DS_Information extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Light Controller
	private final static CANLight canLights = RobotMap.lights;
	//Local Variables
	double matchTime;
	boolean isFMSConnected;
	boolean isAutonomousMode;
	boolean isOperatorMode;
	DriverStation.Alliance Color;
	boolean isNotEndGame;
	boolean isGameStarted;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	// setDefaultCommand(new GetDriverStationInfo());
    }
    
    public void GetCurrentStatus() {
    	DriverStation ds = DriverStation.getInstance();
    	double time;
    	time = ds.getMatchTime();
    	this.MatchTimeEnd(time);
    	SmartDashboard.putNumber("Match Time: ", time);
    	isFMSConnected = ds.isFMSAttached();
    	isAutonomousMode = ds.isAutonomous();
    	isOperatorMode = ds.isOperatorControl();
    	
      	if (isNotEndGame == false) {
    		Color = ds.getAlliance();
    		//FMS Connected
        	if (isFMSConnected == true) {
        		if(Color == DriverStation.Alliance.Blue) {
        			canLights.showRGB(0, 0, 255);	// blue
        		}
        		else {
        			canLights.showRGB(255, 0, 0);  // red
        		}
        	}
        	else { 
        		canLights.showRGB(255, 255, 0);  // yellow
        	}
        	//Teleoperated
        	if (isOperatorMode == true) {
        		canLights.showRGB(255, 255, 0);  // green
        	}
        	//AutonmousMode
        	if(isAutonomousMode == true) {
        		if(Color == DriverStation.Alliance.Blue) {
        			canLights.writeRegister(1, 0.5,   0,   0, 255); // blue
        	        canLights.writeRegister(2, 0.3,   0,   0,   0);
        	        canLights.cycle(1, 2);
        		}
        		else {
        			canLights.writeRegister(1, 0.5, 255,   0,   0); // red
                    canLights.writeRegister(2, 0.3,   0,   0,   0);
                    canLights.cycle(1, 2);
        		}
        	}
        	
    	}
    	
    }
    
    //Set the rumble to the drivers that end game coming up
    private void MatchTimeEnd(double matchTime) {
    	if (matchTime > 2.00) {
    		Robot.oi.actuatorsController.setRumble(RumbleType.kLeftRumble, 1);
    		Robot.oi.driveXBoxController.setRumble(RumbleType.kRightRumble, 1);
    		canLights.showRGB(255, 0, 0);  // red
    	}
    }
    
    //Change color when gear loading
    public void ChangeLightColor() {
    	canLights.writeRegister(1, 0.5, 0, 255, 0);  // green
    	canLights.writeRegister(2, 0.3, 0, 0, 0);
    	canLights.fade(1, 2);
    }
    
    //End Game Lights...flashes lights
    public void alternateColors() {
        canLights.writeRegister(1, 0.5, 255,   0,   0); // red
        canLights.writeRegister(2, 0.3,   0,   0,   0);
        canLights.writeRegister(3, 0.5,   0,   0, 255); // blue
        canLights.writeRegister(4, 0.3,   0,   0,   0);
        canLights.writeRegister(5, 2.5, 255, 255,   0); // yellow
        canLights.cycle(1, 5);
    }

  
}

