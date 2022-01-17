/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6738.robot;

import org.usfirst.frc.team6738.robot.subsystems.Chassi;
import org.usfirst.frc.team6738.robot.subsystems.Elevator;
import org.usfirst.frc.team6738.robot.subsystems.Rollers;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.GamepadBase;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {
	
	private Spark leftBackMotor;
	private Spark leftFrontMotor;
	private Spark rightBackMotor;
	private Spark rightFrontMotor;
	
	public Encoder leftEncoder;
	public Encoder rightEncoder;

	private Victor elevatorMotor;
	
	private DigitalInput halfwaySwitch;cc
	private DigitalInput maxHeightSwitch;
	
	private Spark RollerRight;
	private Spark RollerLeft;
	
	private Servo myServo; 
	
	//public DoubleSolenoid solenoid;
	
	private static final double INJECT = 0.85; //nitai - change sign (+-)
	private static final double CATCH = -1;
	private static final double ROLLERS_HOLD_SPEED = 0.4; //nitai change seder gowdel
	private static final double HOLD_SPEED_ELEVATOR = 0.1;

	public RobotMap() {
		rightBackMotor = new Spark(7);
		rightFrontMotor = new Spark(6);
		leftBackMotor = new Spark(9);
		
		leftFrontMotor = new Spark(8);

		leftEncoder = new Encoder(8,9);
		leftEncoder.reset();
		
		rightEncoder = new Encoder(6,7,true);
		rightEncoder.reset();
		
		halfwaySwitch = new DigitalInput(1); //we don't know which port
		maxHeightSwitch = new DigitalInput(0); //we don't know which port
		myServo = new Servo(2);
		
		elevatorMotor = new Victor(5);

		RollerRight = new Spark(0);
		RollerLeft = new Spark(1);
		
		//solenoid =new DoubleSolenoid(1, 2);
	}

	public Chassi initChassi() {
		return new Chassi(leftBackMotor, leftFrontMotor, rightBackMotor, rightFrontMotor, leftEncoder, rightEncoder);
	}

	public Elevator initElevator() {
		return new Elevator(elevatorMotor, HOLD_SPEED_ELEVATOR, halfwaySwitch, maxHeightSwitch);
	}

	public Rollers initRollers() {
		return new Rollers(RollerRight, RollerLeft, INJECT, CATCH, ROLLERS_HOLD_SPEED, myServo);
	}

	public void updateSmartDashboard() {

//		SmartDashboard.putNumber("left Back Motor: ", this.leftBackMotor.get());
//		SmartDashboard.putNumber("left Front Motor: ", this.leftFrontMotor.get());
//		SmartDashboard.putNumber("right Back Motor: ", -this.rightBackMotor.get());
//		SmartDashboard.putNumber("right Front Motor: ", -this.rightFrontMotor.get());
//		
//		SmartDashboard.putNumber("encoder left: ", leftEncoder.get());
//		SmartDashboard.putNumber("encoder right: ", rightEncoder.get());
//
//		SmartDashboard.putNumber("elevator: ", this.elevatorMotor.get());
//
//		SmartDashboard.putNumber("roller right motor: ", this.RollerRight.get());
//		SmartDashboard.putNumber("roller left motor: ", this.RollerLeft.get());
//		SmartDashboard.putNumber("inject speed: ", INJECT);
//		SmartDashboard.putNumber("catch speed: ", CATCH);		
//		SmartDashboard.putNumber("servo: ", myServo.get());		
//		SmartDashboard.putBoolean("maxheight: ", maxHeightSwitch.get());	
//		
//		SmartDashboard.putString("gameData:", DriverStation.getInstance().getGameSpecificMessage());
//		
//		
//		SmartDashboard.putString("jrtsgjf", "ghdj");
	}
	

}
