package org.usfirst.frc.team6738.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwitchExposure extends Command{
	boolean didSomething = false;
	int x;
	public SwitchExposure(int x) {
		this.x = x;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {		
		double m = SmartDashboard.getNumber("mode", 99);
		if (m == 99) {
			didSomething = !didSomething;
			return;
		}
		if (m%2 == 0) { //its neutral
			SmartDashboard.putNumber("mode", 5);
			didSomething = !didSomething;
		} else { // its low
			SmartDashboard.putNumber("mode", 0);
			didSomething = !didSomething;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return didSomething;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		didSomething = !didSomething;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		
	}
	
}
