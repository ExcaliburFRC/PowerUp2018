package org.usfirst.frc.team6738.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Defines a class of chassi with 4 motors, to put values in motors and use PID (singleton)
 */
public class Chassi extends Subsystem {

	private Spark leftBackMotor;
	private Spark leftFrontMotor;
	private Spark rightBackMotor;
	private Spark rightFrontMotor;

	private Encoder leftEncoder;
	private Encoder rightEncoder;

	private OutputEncoder left_pid_oputput;
	private OutputEncoder right_pid_oputput;

	private PIDController left;
	private PIDController right;

	private double p = 0.005, i = 0.0, d = 0.0;

	// Builds a new chassi
	public Chassi(Spark lbm, Spark lfm, Spark rbm, Spark rfm, Encoder le, Encoder ri) {
		leftBackMotor = lbm;
		leftFrontMotor = lfm;
		rightBackMotor = rbm;
		rightFrontMotor = rfm;
		leftEncoder = le;
		rightEncoder = ri;
		rightEncoder.reset();
		leftEncoder.reset();

		left_pid_oputput = new OutputEncoder();
		right_pid_oputput = new OutputEncoder();
		

		left = new PIDController(p, i, d, (PIDSource) leftEncoder, left_pid_oputput);
		left.setAbsoluteTolerance(500);

		right = new PIDController(p, i, d, (PIDSource) rightEncoder, right_pid_oputput);
		right.setAbsoluteTolerance(500);
		
		
	}

	public PIDController getPIDLeft() {
		return left;
	}

	public PIDController getPIDRight() {
		return right;
	}

	public OutputEncoder getOutPIDLeft() {
		return left_pid_oputput;
	}
	
	public OutputEncoder getOutPIDRight() {
		return right_pid_oputput;
	}
	
	public Encoder getLeftEncoder() {
		return leftEncoder;
	}

	public Encoder getRightEncoder() {
		return rightEncoder;
	}

	public void setLeftDrive(double speed, double scale) {
		if (speed >= -1 && speed <= 1) {
			leftBackMotor.set(-speed * scale);
			leftFrontMotor.set(-speed * scale);
		}
	}

	public void setRightDrive(double speed, double scale) {
		if (speed >= -1 && speed <= 1) {
			rightBackMotor.set(speed * scale);
			rightFrontMotor.set(speed * scale);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

}
