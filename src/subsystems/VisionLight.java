/****************************************************************************************
 *  FRC 2017 Steam Works
 *  
 *  Team 3840 (TNT)
 *  Created 02/17/17
 *  Description:
 *  This is the VisionLight Subsystem...Used turning on/off Light.  
 *  This is called by three different
 *  commands: ClampGear
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class VisionLight extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private final Solenoid visionLight = RobotMap.lightSolenoid;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void VisionLightEnabled() {
    	visionLight.set(true);
    }
    
    public void VisionLightDisabled() {
    	visionLight.set(false);
    }
}

