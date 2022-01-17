package org.usfirst.frc.team6738.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Rollers extends Subsystem {

	private Spark MotorA;
	private Spark MotorB;
	private Servo myServo;

	private double speedGrab;
	private double speedInject;
	private double speedHoldRollers;

	public Rollers(Spark M1, Spark M2, double Grab, double Inject, double holdSpd, Servo serv) {
		MotorA = M1;
		MotorB = M2;
		speedGrab = Grab;
		speedInject = Inject;
		myServo = serv;
		
		speedHoldRollers = holdSpd; 
	}

	public void Inject() {
		MotorA.set(-speedInject);
		MotorB.set(speedInject);
	}

	public void Catch() {
		MotorA.set(-speedGrab);
		MotorB.set(speedGrab);
	}
	
	public void Hold() {
		MotorA.set(-speedHoldRollers);
		MotorB.set(speedHoldRollers);
	}
	
	public void Stop() {
		MotorA.set(0);
		MotorB.set(0);
	}

	public void pullServoDown() {
		myServo.set(1);
	}
	
	public boolean servoIsDown() {return myServo.get() >= 0.9;}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
