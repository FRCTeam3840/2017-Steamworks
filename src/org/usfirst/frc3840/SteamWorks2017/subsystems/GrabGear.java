/****************************************************************************************
 *  FRC 2017 Steam Works
 *  
 *  Team 3840 (TNT)
 *  Created 02/17/17
 *  Description:
 *  This is the GrabGear Subsystem...Used clamp gear when the arm is down.  
 *  This is called by three different
 *  commands: ClampGear
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GrabGear extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	 private final Solenoid leftGrab = RobotMap.leftSolenoid;
	 private final Solenoid rightGrab = RobotMap.rightSolenoid;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void ClampGearAction() {
    	leftGrab.set(true);
    	rightGrab.set(true);
    }
    
    public void UnClampAction() {
    	leftGrab.set(false);
    	rightGrab.set(false);
    }
}

