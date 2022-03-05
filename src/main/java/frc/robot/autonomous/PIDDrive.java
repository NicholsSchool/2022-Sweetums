// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PIDDrive extends PIDCommand {
  /** Creates a new PIDDrive. */
  public PIDDrive( double inches ) {
    super(
        // The controller that the command will use
        new PIDController(0.0001, 0, 0),
        // This should return the measurement
        () -> RobotContainer.driveTrain.getRFEncoderValue(),
        // This should return the setpoint (can also be a constant)
        () -> inches / Constants.INCHES_PER_TICK,
        // This uses the output
        output -> {
          
          output += Math.copySign(Constants.DRIVE_TRAIN_DRIVE_kF, output); // Feed forward
          RobotContainer.driveTrain.move(output, output * Constants.DRIVE_TRAIN_EQUALIZIER);
          // Use the output here
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
    addRequirements(RobotContainer.driveTrain);
    getController().setTolerance(Constants.AUTO_DRIVE_TOLERANCE);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
