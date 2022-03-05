/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class AutoShoot extends CommandBase
{
  public AutoShoot() 
  {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements( RobotContainer.shooter, RobotContainer.indexer );
  }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
  }
    
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    if( RobotContainer.shooter.getVelocity() < Constants.LOW_GOAL_VELOCITY )
      RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
    else
    RobotContainer.indexer.move( Constants.INDEXER_SPEED );
  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end( boolean interrupted ) 
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