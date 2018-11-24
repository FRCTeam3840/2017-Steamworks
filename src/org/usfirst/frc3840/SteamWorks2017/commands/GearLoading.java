/****************************************************************************************
 *  FRC 2017 Steam Works
 *  Team 3840 (TNT)
 *  Command Group: GearLoading
 *  Created 02/20/17
 *  Description:
 *  GearLoading...three commands in sequential but always ensure floor pick is up!
 *  Pass in selection from OI class  0 = travel position, 1 = pickup location, 2 = gear placement.
 * ****************************************************************************************
*/

package org.usfirst.frc3840.SteamWorks2017.commands;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GearLoading extends CommandGroup {

    public GearLoading(int Selection) {
    	//Ensure gear floor pick is up
    	addParallel(new PickerTravelPosition());
    	// Which command to call from here...
    	switch (Selection) {
        case 0:;	//Travel Position
        	addSequential(new GearTravelPosition());
        	break;
        case 1:;	//Load gear position
        	addSequential(new GearPickUpPosition());
        	break;
        case 2:;	//Unload gear position
        	addSequential(new MoveGearPlacement());
        	break;
   	 }
    	    
        // A command group will require all of the subsystems that each member
        // would require.
    	requires(Robot.gearMover);
    	requires(Robot.frontMover);
    }
}
