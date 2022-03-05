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

        new PIDController(0.0001, 0, 0),

        () -> RobotContainer.driveTrain.getRFEncoderValue(),

        () -> inches / Constants.INCHES_PER_TICK,
        
        output -> {

          output += Math.copySign(Constants.DRIVE_TRAIN_DRIVE_kF, output); // Feed forward
          RobotContainer.driveTrain.move(output, output * Constants.DRIVE_TRAIN_EQUALIZIER);

        });

    addRequirements(RobotContainer.driveTrain);
    getController().setTolerance(Constants.AUTO_DRIVE_TOLERANCE);
  }

  @Override
  public void initialize() {
      super.initialize();
      RobotContainer.driveTrain.resetEncoders();
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
