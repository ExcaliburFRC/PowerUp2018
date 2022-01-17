package org.usfirst.frc.team6738.robot.commandsElevator;

import org.usfirst.frc.team6738.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUpByTime extends Command {
	public ElevatorUpByTime() {
		requires(Robot.elevator);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.elevator.setSpeed(0.5);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator.setSpeed(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.elevator.setSpeed(0);

	}
}
