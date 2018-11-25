//****************************************************************************************
// FRC 2017 Steam Works
//
// Team 3840 (TNT)
// Created 01/15/17
//****************************************************************************************

package org.usfirst.frc3840.SteamWorks2017;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3840.SteamWorks2017.commands.*;
import org.usfirst.frc3840.SteamWorks2017.subsystems.*;
import com.analog.adis16448.frc.ADIS16448_IMU;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    //Declare the IMU
   	public static ADIS16448_IMU imu;
   	//Declare the OI
    public static OI oi;
    //Declare the Drive train
    public static DriveTrain driveTrain;
    public static ScaleAirShip scaleAirShip;
    public static ImuData imuData;
    public static DS_Information dsInformation;
    public static GearMoverToPosition gearMover;
    public static FrontMover frontMover;
    public static ManualMoveGear manualMoveGear;
    public static GrabGear gearGrabber;
    public static VisionLight visionLight;
    
  
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
    	
    	//Robot mapping init
    	RobotMap.init();
    	
    	//int the IMU
    	imu = new ADIS16448_IMU();
    	    	
        // Create New objects
        driveTrain = new DriveTrain();
        scaleAirShip = new ScaleAirShip();
        imuData = new ImuData();
        dsInformation = new DS_Information();
        frontMover = new FrontMover();
        gearMover = new GearMoverToPosition();
        manualMoveGear = new ManualMoveGear();
        gearGrabber = new GrabGear();
        visionLight = new VisionLight();
                   
        //Setup Usb camera connection
       // CameraServer.getInstance().startAutomaticCapture();
       
        UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
        UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);
        cam0.setFPS(20);
        cam1.setFPS(20);
        
        dsInformation.GetCurrentStatus();
        //update data to the tables
        imu.updateTable();
        

        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();
       
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        //Turn lights on when we go into auto mode
        visionLight.VisionLightEnabled();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        visionLight.VisionLightDisabled();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
     	
    	//Right pull trigger input
    	 SmartDashboard.putNumber("Climber Forward", oi.driveXBoxController.getRawAxis(3));
      	
        Scheduler.getInstance().run();
        Timer.delay(0.005);		// wait for a motor update time
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	 	
        LiveWindow.run();
    }
}
