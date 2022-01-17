/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6738.robot.commandsElevator;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6738.robot.Robot;
import org.usfirst.frc.team6738.robot.subsystems.Rollers;

/**
 * An example command.  You can replace me with your own command.
 */
public class RollersRollInByTime extends Command { //for automatic
	
	private Rollers myRollers;
	private Timer myTimer;
	private double maxTime;
	
	public RollersRollInByTime(double maxTime) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.rollers);
		myRollers = Robot.rollers;
		myTimer = new Timer();
		this.maxTime = maxTime;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		myTimer.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		myRollers.Catch();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return myTimer.get() < maxTime;
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
