/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6738.robot.commandsElevator;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6738.robot.Robot;
import org.usfirst.frc.team6738.robot.subsystems.Elevator;
import org.usfirst.frc.team6738.robot.subsystems.Rollers;

/**
 * An example command.  You can replace me with your own command.
 */
public class GoToHalfAndInject extends Command { //for automatic
	
	private Rollers myRollers;
	private Elevator myElevator;
	
	public GoToHalfAndInject() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.rollers);
		requires(Robot.elevator);
		
		myRollers = Robot.rollers;
		myElevator = Robot.elevator;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(myElevator.reachedHalfway()) 
		{
			myElevator.holdInPlace();
			myRollers.Inject();
		}
		else
		{
			myElevator.setSpeed(1);
		}	
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
	}
}
