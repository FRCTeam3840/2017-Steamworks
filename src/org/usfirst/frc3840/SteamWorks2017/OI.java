//****************************************************************************************
// FRC 2017 Steam Works
//
// Team 3840 (TNT)
// Created 01/15/17
//****************************************************************************************

package org.usfirst.frc3840.SteamWorks2017;

import org.usfirst.frc3840.SteamWorks2017.commands.*;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

//Public Declares
public XboxController driveXBoxController;
public XboxController actuatorsController;
//Joystick Buttons Declares
public JoystickButton gearMoverLocation;
public JoystickButton gearPickerLocation;
public JoystickButton clampGear;
public JoystickButton unClampGear;


    public OI() {
       
    	//Xbox Controllers declares
    	driveXBoxController = new XboxController(0);
    	actuatorsController = new XboxController(1);
    	//**************************************************
        //Xbox Controller Button Declares
    	//**************************************************
    	// 0 = travel position, 1 = pickup location, 2 = gear placement.
    	 //Gear Pick Up Location-Button #1
    	gearMoverLocation = new JoystickButton(actuatorsController,1);
    	gearMoverLocation.whenActive(new GearLoading(1));
    	 //Gear Placement Location-Button #2
    	gearMoverLocation = new JoystickButton(actuatorsController,2);
    	gearMoverLocation.whenActive(new GearLoading(2));
    	//Gear Travel Location-Button #3
    	gearMoverLocation = new JoystickButton(actuatorsController,3);
    	gearMoverLocation.whenActive(new GearLoading(0));
    	/**********************************
    	 *  Picker/Mover the Gear Items 
    	 **********************************/
    	//Picker to low/pick position - Button #5
    	gearPickerLocation = new JoystickButton(actuatorsController,5);
    	gearPickerLocation.whenActive(new GearPicker(1));
    	//Picker to Travel - Button #6
    	gearPickerLocation = new JoystickButton(actuatorsController,6);
    	gearPickerLocation.whenActive(new GearPicker(0));
    	//Picker to Placement - Button #7
    	gearPickerLocation = new JoystickButton(actuatorsController,7);
    	gearPickerLocation.whenActive(new GearPicker(2));
    	    	
    	//Clamping and unclamping gear -- Drivers Joystick
    	clampGear = new JoystickButton(driveXBoxController,5);
    	clampGear.whenActive(new ClampGear());
    	unClampGear = new JoystickButton(driveXBoxController,1);
    	unClampGear.whenActive(new UnClampGear());
        	  
    }
    
    //Drive Train & Climber XBox Controller
    public XboxController getDriveJoyStick() {
        return driveXBoxController;
    }
    
    //Actuators  XBox Controller
    public XboxController getActuatorsJoyStick() {
    	return actuatorsController;
    }
}

