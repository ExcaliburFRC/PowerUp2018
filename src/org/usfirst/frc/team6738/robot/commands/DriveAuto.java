package org.usfirst.frc.team6738.robot.commands;

import org.usfirst.frc.team6738.robot.commandsDrive.DrivingPID;
import org.usfirst.frc.team6738.robot.commandsElevator.DoNothing;
import org.usfirst.frc.team6738.robot.commandsElevator.DropServo;
import org.usfirst.frc.team6738.robot.commandsElevator.ElevatorUpByTime;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersRollIn;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersRollInByTime;
import org.usfirst.frc.team6738.robot.commandsElevator.RollersRollOut;
import org.usfirst.frc.team6738.robot.subsystems.cleanDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveAuto extends CommandGroup {

	private static final double fullTurn = 4; // for Ex: to turn 90 degrees to the left, write:
												// addSequential(new DrivingPID(-fullTurn/4, fullTurn/4));
	private static final double circlesForMeter = 1.3;

	private static final double shootForThisLong = 2; // nitai
	private static final double driveDistance = 4.2; // nitai

	public DriveAuto(String road) {

		boolean switchOnRight = road.charAt(0) == 'R';
		// nitai - only ONE can be true
		boolean inRightSide = false;
		boolean inLeftSide = true;
		boolean inMiddle = false;
		boolean shoot;
		// nitai end
		shoot = (inLeftSide && (!switchOnRight)) || (inMiddle && switchOnRight);
		addParallel(new ElevatorUpByTime(), 1);
		addSequential(new cleanDrive(0.25),13);		
		if(shoot)
			addSequential(new RollersRollOut(), shootForThisLong); // shooting
		
			
				
				

		
		
		
		
		
		
		
		
		
		
		
		/*//addSequential(new DrivingPID(circlesForMeter * driveDistance, circlesForMeter * driveDistance));
		
		if (inRightSide && switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * driveDistance, circlesForMeter * driveDistance));
			// addSequential(new DrivingPID(-1 * fullTurn / 4, 1 * fullTurn / 4));
			// addSequential(new DrivingPID(circlesForMeter * 1, circlesForMeter * 1));

			addSequential(new DoNothing(), 1); //nitai - this does nothing for a second
			addSequential(new RollersRollOut(), shootForThisLong); // shooting
		}
		if (inRightSide && !switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * driveDistance, circlesForMeter * driveDistance)); // option 2
		}

		if (inLeftSide && switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * driveDistance, circlesForMeter * driveDistance));
		}
		if (inLeftSide && !switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * driveDistance, circlesForMeter * driveDistance));
			// addSequential(new DrivingPID(-1 * fullTurn / 4, 1 * fullTurn / 4));
			// addSequential(new DrivingPID(circlesForMeter * 1, circlesForMeter * 1));

			 addSequential(new DoNothing(), 1); //nitai - this does nothing for a second
			addSequential(new RollersRollOut(), shootForThisLong); // shooting
		}

		if (inMiddle && switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * 1, circlesForMeter * 1));
			addSequential(new DrivingPID(1 * fullTurn / 4, -1 * fullTurn / 4));
			addSequential(new DrivingPID(circlesForMeter * 2, circlesForMeter * 2));
			addSequential(new DrivingPID(-1 * fullTurn / 4, 1 * fullTurn / 4));
			addSequential(new DrivingPID(circlesForMeter * 3, circlesForMeter * 3));

			addSequential(new DoNothing(), 1);//nitai - this does nothing for a second
			addSequential(new RollersRollOut(), shootForThisLong); // shooting
		}
		if (inMiddle && !switchOnRight) {
			addSequential(new DrivingPID(circlesForMeter * 1, circlesForMeter * 1));
			addSequential(new DrivingPID(-1 * fullTurn / 4, 1 * fullTurn / 4));
			addSequential(new DrivingPID(circlesForMeter * 2, circlesForMeter * 2));
			addSequential(new DrivingPID(1 * fullTurn / 4, -1 * fullTurn / 4));
			addSequential(new DrivingPID(circlesForMeter * 3, circlesForMeter * 3));

			addSequential(new DoNothing(), 1);//nitai - this does nothing for a second
			addSequential(new RollersRollOut(), shootForThisLong); // shooting
		}
		*/

	}

}
