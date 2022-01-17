package org.usfirst.frc.team6738.robot.commandsDrive;

import org.usfirst.frc.team6738.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopAllMotors extends Command {
	public StopAllMotors() {
		requires(Robot.drive);
		requires(Robot.elevator);
		requires(Robot.rollers);
		
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.setLeftDrive(0,0);
		Robot.drive.setRightDrive(0,0);
		Robot.elevator.setSpeed(0);
		Robot.rollers.Stop();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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
