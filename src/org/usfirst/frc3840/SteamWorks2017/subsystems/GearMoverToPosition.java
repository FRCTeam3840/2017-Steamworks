/****************************************************************************************
 *  FRC 2017 Steam Works
 *  
 *  Team 3840 (TNT)
 *  Created 01/15/17
 *  Description:
 *  This is the PIDSubsystem for the Gear Handler.  This is called by three different
 *  commands: MoveGearPlacement, GearPickupPosition, GearTravelPosition.  Grabs setpoints
 *  from the smart dashboard setpoints.
 * ****************************************************************************************
*/
package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 2017 SteamWorks FRC
 * Team 3840
 */
public class GearMoverToPosition extends PIDSubsystem {
	
	 public final AnalogInput gearPositioner = RobotMap.gearLifterPositioner;
	 private final Talon gearMotor = RobotMap.gearMoverMotor;
	// Used to get numbers from the smart dashboard values
	 	 final String PlaceGearLocation = "PlaceGearLocation";
	 	 final String PickGearLocation = "PickGearLocation";
	 	 final String TravelMover = "TravelPosition";
	 	 final double PlaceLocation = 1.5;
	 	 final double PickLocation = 0.8;
	 	 final double TravelLocation = 0.6;
	 	 private double setPoint;

    // Initialize your subsystem here
    public GearMoverToPosition() {
    	super("GearLifter", 2.070, 0.008, 0.050);
        setAbsoluteTolerance(0.05);
        this.setInputRange(0, 5); // 0 to 5V
		this.setSetpoint(gearPositioner.getVoltage()); // set to first setpoint
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("GearLifter", "PIDSubsystem Controller", getPIDController());
        enable();  //- Enables the PID controller.
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	// Return your input value for the PID loop
        return gearPositioner.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        gearMotor.pidWrite(output);
    }
    
    //Moving the gear placement arm to different position
    public void MoveGearArmToPosition(String Key) {
    	double backUp = TravelLocation;
    	
    	//set up the grab from values at Smart Dashboard
    	 switch (Key) {
         case PlaceGearLocation:;
         	backUp = PlaceLocation;
         	break;
         case PickGearLocation:;
         	backUp = PickLocation;
         	break;
         case TravelMover:;
         	backUp = TravelLocation;
         	break;
    	 }
    	 //gets the current value
    	setPoint =getPreferencesDouble(Key, backUp);
    	// Use these to get going:
        setSetpoint(setPoint);    //-  Sets where the PID controller should move the system       	
    }
    
    // Used with joystick motion of gear lifer
    public void MoveGearArm(XboxController actuatorsController) {
    	double stickY = actuatorsController.getY();
       	SmartDashboard.putNumber("Gear Mover: ", stickY);
    	double retval = returnPIDInput();
    	if (retval < 3.00 && retval > 1.1) {
    		gearMotor.set(stickY);
    	}
    	    
    }
    
    /**
   	 * Retrieve numbers from the preferences table. If the specified key is in
   	 * the preferences table, then the preference value is returned. Otherwise,
   	 * return the backup value, and also start a new entry in the preferences
   	 * table.
   	 */
         
       private static double getPreferencesDouble(String key, double backup) {
   		Preferences preferences = Preferences.getInstance();
   		if (!preferences.containsKey(key)) {
   			preferences.putDouble(key, backup);
   		}
   		return preferences.getDouble(key, backup);
   	}
}
