package org.usfirst.frc.team6738.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * Handles Elevator, singleton
 */
public class Elevator extends Subsystem {
	private Victor Motor;
	private double speed;
	private double holdSpeed;
	private DigitalInput myHalfwaySwitch;
	private DigitalInput myMaxSwitch;
	private static final double inputDrop = -0.03;

	public Elevator(Victor A, double hold, DigitalInput diHalf, DigitalInput diMax) {
		Motor = A;
		holdSpeed = hold;
		myHalfwaySwitch = diHalf;
		myMaxSwitch = diMax;
	}

	public void setSpeed(double sp) {
		speed = sp; //negative go up

		if (Motor != null) 
		{
			if(!reachedMaxHeight() && sp >= inputDrop) //nitai - if problem can't go down, change '<' to '>'
				Motor.set(holdSpeed);
			else
				Motor.set(speed);
		}
	}

	public boolean reachedHalfway() {
		return myHalfwaySwitch.get();
	}
	
	public boolean reachedMaxHeight() {
		return myMaxSwitch.get();
	}

	public void holdInPlace() {
		setSpeed(holdSpeed);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
	}

}
