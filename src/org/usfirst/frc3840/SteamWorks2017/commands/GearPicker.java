/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Command Group: GearPicker
 *  Created 02/20/17
 *  Description:
 *  GearPicker...three commands in sequential but always ensure floor pick is up!
 *  Pass in selection from OI class  0 = travel position, 1 = pick location, 2 = gear placement.
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearPicker extends CommandGroup {

    public GearPicker(int Selection) {
    	//Ensure gear gear mover is up FIRST!
    	addParallel(new GearTravelPosition());
    	// Which command to call from here...
    	switch (Selection) {
        case 0:;	//Travel Position
        	addSequential(new PickerTravelPosition());
        	break;
        case 1:;	//Pick gear position
        	addSequential(new PickerLowPosition());
        	break;
        case 2:;	//Unload gear position
        	addSequential(new PickerPlacementPosition());
        	break;
   	 }
    	    
        // A command group will require all of the subsystems that each member
        // would require.
    	requires(Robot.gearMover);
    	requires(Robot.frontMover);
    }
}
