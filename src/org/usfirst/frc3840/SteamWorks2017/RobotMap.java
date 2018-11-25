//****************************************************************************************
// FRC 2017 Steam Works
//
// Team 3840 (TNT)
// Created 01/15/17
//****************************************************************************************

package org.usfirst.frc3840.SteamWorks2017;

import com.ctre.CANTalon;
import com.mindsensors.CANLight;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Drive Train Declares
    public static CANTalon driveTrainLeftMotor1;
    public static CANTalon driveTrainLeftMotor2;
    public static CANTalon driveTrainRightMotor1;
    public static CANTalon driveTrainRightMotor2;
    public static RobotDrive driveTrainRobotDrive;
    //Robot Climber
    public static CANTalon climberMotor;
    //Gear rotate motor
    public static Talon gearMoverMotor;
    //analog input for position of the gear lifter
    public static AnalogInput gearLifterPositioner;
    //Intake motor
    public static Talon pickLiftMotor;
     //analog input for position of the intake lifter
    public static AnalogInput pickLifterPositioner;
    //Light Controller
    public static CANLight lights;
    //analog input for postion of the distance to wall
    public static AnalogInput distanceToWall;
    //Solenoids for picker
    public static Solenoid leftSolenoid;
    public static Solenoid rightSolenoid;
    //Solenoid for light
    public static Solenoid lightSolenoid;

    public static void init() {
        // Drive motor motors declare (Drive #1-4)
        driveTrainLeftMotor1 = new CANTalon(1);
        LiveWindow.addActuator("Drive 1 Train", "LeftMotor1", driveTrainLeftMotor1);
        
        driveTrainLeftMotor2 = new CANTalon(2);
        LiveWindow.addActuator("Drive 2 Train", "LeftMotor2", driveTrainLeftMotor2);
        
        driveTrainRightMotor1 = new CANTalon(3);
        LiveWindow.addActuator("Drive 3 Train", "RightMotor1", driveTrainRightMotor1);
        
        driveTrainRightMotor2 = new CANTalon(4);
        LiveWindow.addActuator("Drive 4 Train", "RightMotor2", driveTrainRightMotor2);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeftMotor1, driveTrainLeftMotor2,
              driveTrainRightMotor1, driveTrainRightMotor2);
        
        //Drive Train Robot Drive Setup
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        //Inverts the motors because of gear box setup
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        //Climber Motor declare (Drive #5)
        climberMotor = new CANTalon(5);
        LiveWindow.addActuator("Climber Motor", "Climber", climberMotor);
        
        //Gear tray mover motor declare (Drive #6)
        gearMoverMotor = new Talon(0);
        LiveWindow.addActuator("Gear Mover Motor", "Gear", gearMoverMotor);
        
        //Intake Lifter Actuator declares  (Drive #7)
        pickLiftMotor = new Talon(1);
        LiveWindow.addActuator("Intake Lift Motor", "Intake Lift", pickLiftMotor);
                       
        //Sets gear lifter position (Analog 0)
        gearLifterPositioner = new AnalogInput(0);
        LiveWindow.addSensor("GearMover", "Gear Positioner", gearLifterPositioner);
        
        //Sets gear picker position (Analog 1)
        pickLifterPositioner = new AnalogInput(1);
        LiveWindow.addSensor("GearPicker", "Picker Positioner", pickLifterPositioner);
        
        //Distance to the wall Ultrasonic Sensor (Analog 2)
        distanceToWall = new AnalogInput(2);
        LiveWindow.addSensor("Distance", "Distance", distanceToWall);
        
        //Lights Controller
     	lights = new CANLight(3);
    	
    	//Solenoids for gear picker
    	leftSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("GearPickerLeft", "GearPickerLeft", leftSolenoid);
        rightSolenoid = new Solenoid(0, 1);
        LiveWindow.addActuator("GearPickerRight", "GearPickerRight", rightSolenoid);
        
        //Vision Light Solenoid
        lightSolenoid = new Solenoid(1, 0);
        LiveWindow.addActuator("GearPickerLeft", "GearPickerLeft", lightSolenoid);
        
    }
}
