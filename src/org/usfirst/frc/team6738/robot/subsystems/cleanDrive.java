package org.usfirst.frc.team6738.robot.subsystems;

import org.usfirst.frc.team6738.robot.Robot;
import org.usfirst.frc.team6738.robot.subsystems.Chassi;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.command.Command;

public class cleanDrive extends Command {
 	double mySpeed;   
	public cleanDrive(double speed) {
        	requires(Robot.drive);
    		mySpeed = speed;
	}

 	protected void initialize() {
    	}
    	
	protected void execute() {
		Robot.drive.setLeftDrive(-1,mySpeed);
		Robot.drive.setRightDrive(-1,mySpeed);
    	}

    	protected boolean isFinished() {
        	return false;
    	}
}