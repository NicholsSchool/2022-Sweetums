/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class AutoShoot extends CommandBase
{
  private double startTime;
  //DriveTrain.rFDrive.
  public AutoShoot() 
  {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements( RobotContainer.shooter, RobotContainer.indexer );
  }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    startTime = System.currentTimeMillis() / 1000; // startTime == seconds
  }
    
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    RobotContainer.indexer.move( Constants.INDEXER_SPEED );
    // Shoots a ball
    RobotContainer.shooter.move( Constants.LOW_GOAL_VELOCITY );

    // Stops shooter and starts reversing
    if( ( System.currentTimeMillis() / 1000 ) - startTime >  Constants.AUTO_SHOOT_TIME )
    {
      RobotContainer.shooter.stop();
      RobotContainer.indexer.stop();
    }

  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    RobotContainer.shooter.stop();
    RobotContainer.indexer.stop();
  }
    
  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }

}