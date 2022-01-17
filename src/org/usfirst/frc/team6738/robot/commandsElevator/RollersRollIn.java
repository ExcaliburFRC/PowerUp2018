package org.usfirst.frc.team6738.robot.commandsElevator;

import org.usfirst.frc.team6738.robot.Robot;
import org.usfirst.frc.team6738.robot.subsystems.Rollers;

import edu.wpi.first.wpilibj.command.Command;

public class RollersRollIn extends Command { //for teleop
	
	private Rollers rollers;
	
	public RollersRollIn() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.rollers);
		this.rollers = Robot.rollers;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		rollers.Catch();
	}

	// Make this return true when this Command no longer needs to run execute()
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
		rollers.Stop();
	}
}