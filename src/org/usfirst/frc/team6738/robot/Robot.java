/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6738.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team6738.robot.commands.DriveAuto;
import org.usfirst.frc.team6738.robot.commandsDrive.DrivingTeleop;
import org.usfirst.frc.team6738.robot.commandsElevator.ElevatorTeleop;
import org.usfirst.frc.team6738.robot.subsystems.Rollers;
import org.usfirst.frc.team6738.robot.subsystems.Chassi;
import org.usfirst.frc.team6738.robot.subsystems.Elevator;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Robot extends TimedRobot {
	
	public DoubleSolenoid solenoid = new DoubleSolenoid(1, 2);
	
	public static Chassi drive;
	public static Elevator elevator;
	public static Rollers rollers;
	
	public static RobotMap myRobotMap;
	public static OI myOI;

	private SendableChooser myChooser; 
	private int a = 0;
	
	CameraServer frontCamera;
	
	
	NetworkTableEntry visionDist;
	NetworkTableEntry visionAngle;
	
	private int ii = 0;
	private boolean isDriving = false;
	@Override
	public void robotInit() {
		
		myRobotMap = new RobotMap();

		// subsystems
		drive = myRobotMap.initChassi();
		elevator = myRobotMap.initElevator();
		rollers = myRobotMap.initRollers();
		myOI = new OI();
		
		/*myChooser = new SendableChooser();
		myChooser.addObject("option 1", 0);
		myChooser.addObject("option 2", 1);
		myChooser.addDefault("Default", -1);*/
		//frontCamera.getInstance().startAutomaticCapture(0);
		myRobotMap.updateSmartDashboard();
		
		//network tables
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("SmartDashboard");
		visionDist = table.getEntry("Vision_Dist");
		visionAngle = table.getEntry("Vision_Angle");
				
	}

	@Override
	public void autonomousInit()
	{
		System.out.println("TEST");
		myRobotMap.updateSmartDashboard();
		double x = (double)myChooser.getSelected();
		SmartDashboard.putNumber("chooser:", x);
		drive.setLeftDrive(-1,2.5); 
		drive.setRightDrive(-1,2.5);
		
		Scheduler.getInstance().add((Command) new DriveAuto(DriverStation.getInstance().getGameSpecificMessage()));
		
	}

	@Override
	public void autonomousPeriodic() {
		
		
		Scheduler.getInstance().run();
		myRobotMap.updateSmartDashboard();
		
		
	}

	@Override
	public void teleopInit() {
		this.drive.getLeftEncoder().reset();
		this.drive.getRightEncoder().reset();
		Scheduler.getInstance().add(new DrivingTeleop());
		Scheduler.getInstance().add(new ElevatorTeleop());
//		drive.setLeftDrive(-1,1); 
//		drive.setRightDrive(-1,1);
		visionDist.setDouble(0);
		visionAngle.setDouble(0);

	}

	@Override
	public void teleopPeriodic() {
//		solenoid.set(DoubleSolenoid.Value.kForward);
		Scheduler.getInstance().run();
		
			// drive.setLeftDrive(-1,1);
			//drive.setRightDrive(1,1);
			
		myRobotMap.updateSmartDashboard();
		
		double dist = visionDist.getDouble(-1.0);
		SmartDashboard.putNumber("Vision_Dist",(int) dist);
		
		double angle = visionAngle.getDouble(0);
		SmartDashboard.putNumber("Vision_Angle",(int) angle);
		
		//makes the robot go to 2.0 meters
		int ndist = (int) dist;
		double speed = 0.3;
		boolean dmove = false;
		if (!dmove) {
			
		}else if (ndist == -1){
			
	    }else if (ndist > 220) {
			SmartDashboard.putString("Vision_Status", "too Far");
			drive.setLeftDrive(-1,speed); 
			drive.setRightDrive(-1,speed);
			isDriving = true;
		} else if (ndist < 180 && ndist > 0){
			SmartDashboard.putString("Vision_Status", "too Close");
			drive.setLeftDrive(1,speed); 
			drive.setRightDrive(1,speed);
			isDriving = true;
		} else {
			if (isDriving) {
				isDriving = false;
				drive.setLeftDrive(1,speed); 
				drive.setRightDrive(1,speed);
			}
			SmartDashboard.putString("Vision_Status", "just Right");
		}
		
		
		//Turn to the board
		//double turnspeed = 0.2;
	//	if (angle > 3) {
	//		drive.setLeftDrive(-1,turnspeed); 
	//		drive.setRightDrive(1,turnspeed);
	//	} else if (angle < -3) {
	//		drive.setLeftDrive(1,turnspeed); 
	//		drive.setRightDrive(-1,turnspeed);
	//	}
		
		
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
	}

	@Override
	public void disabledInit() {

	}
}
