/****************************************************************************************
 *  FRC 2017 Steam Works
 *  
 *  Team 3840 (TNT)
 *  Created 01/15/17
 *  Description:
 *  This is the PIDSubsystem...Used to mover up and down the front arm for ball handler or moving gears.  
 *  This is called by three different
 *  commands: ManuallyMoveIntake, IntakeMoveToTravelPosition, IntakeLowPosition.  Grabs setpoints
 *  from the smart dashboard setpoints.
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class FrontMover extends PIDSubsystem {
	 public final AnalogInput armPositioner = RobotMap.pickLifterPositioner;
	 private final Talon armMotor = RobotMap.pickLiftMotor;
	// Used to get numbers from the smart dashboard values
	 	 final String ArmDownLocation = "ArmDownLocation";
	 	 final String ArmTravel = "ArmTravelPosition";
	 	 final String ArmMid = "ArmMiddleLocation";
	 	 final double ArmLowLocation = 1.0;
	 	 final double TravelLocation = 3.0;
	 	 final double ArmMiddleLocation = 1.6;
	 	 private double setPoint;

    // Initialize your subsystem here
    public FrontMover() {
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        // enable() - Enables the PID controller.
    	super("FrontLifter", 1.5, 0.007, 0.050);
        setAbsoluteTolerance(0.05);
        this.setInputRange(0, 5); // 0 to 5V
		this.setSetpoint(armPositioner.getVoltage()); // set to first setpoint
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("FrontLifter", "PIDSubsystem Controller", getPIDController());
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
    	return armPositioner.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
    	armMotor.pidWrite(output);
    }
    
    //Moving the intake arm to different position
    public void MoveIntakeArmToPosition(String Key) {
    	double backUp = TravelLocation;
    	
    	//set up the grab from values at Smart Dashboard
    	 switch (Key) {
         case ArmDownLocation:;
         	backUp = ArmLowLocation;
         	break;
         case ArmMid:;
         	backUp = ArmMiddleLocation;
         	break;
         case ArmTravel:;
         	backUp = TravelLocation;
         	break;
    	 }
    	 //gets the current value
    	setPoint =getPreferencesDouble(Key, backUp);
    	// Use these to get going:
        setSetpoint(setPoint);    //-  Sets where the PID controller should move the system 
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
