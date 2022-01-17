package org.usfirst.frc.team6738.robot.commandsDrive;

import org.usfirst.frc.team6738.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivingTeleop extends Command {
	private double speedLeft, speedRight;
	
	public DrivingTeleop() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		speedLeft = Robot.myOI.stickDrive.getRawAxis(1);
		speedRight = Robot.myOI.stickDrive.getRawAxis(3);
		SmartDashboard.putString("speedFromJoys", ""+speedRight+","+speedLeft);
		Robot.drive.setLeftDrive(speedLeft,1);
		Robot.drive.setRightDrive(speedRight,1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}