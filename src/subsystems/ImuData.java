package org.usfirst.frc3840.SteamWorks2017.subsystems;

import org.usfirst.frc3840.SteamWorks2017.Robot;
import org.usfirst.frc3840.SteamWorks2017.commands.GetImuData;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 2017 SteamWorks FRC
 * Team 3840
 */
public class ImuData extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new GetImuData());
    }
    
 // imu data to the dashboard
    public void SendDataToSmartDashboard() {
    	//Robot.imu.getMagX();
    	SmartDashboard.putData("Robot Direction", Robot.imu);
    	SmartDashboard.putNumber("Pitch: ",Robot.imu.getPitch());
    	SmartDashboard.putNumber("Y Accel: ",Robot.imu.getAccelY());
    	SmartDashboard.putNumber("X Accel: ",Robot.imu.getAccelX());
    	SmartDashboard.putNumber("Z Accel: ",Robot.imu.getAccelZ());
    	SmartDashboard.putNumber("Yaw: ",Robot.imu.getYaw());
    }
}

