package org.usfirst.frc.team6738.robot.commandsElevator;

import org.usfirst.frc.team6738.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorTeleop extends Command { //for teleoop
	
	private double speed;
	
	public ElevatorTeleop() {
		requires(Robot.elevator);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		speed = Robot.myOI.stickArms.getRawAxis(1); 
		Robot.elevator.setSpeed(speed);		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
