/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants;
import frc.robot.RobotContainer;
//import frc.robot.subsystems.DriveTrain;

public class AutoDrive extends CommandBase
{
  
  private double distance;
  private double speed;

  /**
   * @param dst desired travel distance
   * @param spd speed to travel at (since going in reverse, use negative speed)
   */
  public AutoDrive( double dst, double spd ) 
  {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements( RobotContainer.driveTrain );
      distance = dst;
      speed = spd;
  }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    RobotContainer.driveTrain.resetEncoder();
  }
    
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {

    if( distance >= Math.abs( RobotContainer.driveTrain.getEncoderValue() ) )
      RobotContainer.driveTrain.move( speed, speed );

  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end( boolean interrupted ) 
  {
    RobotContainer.driveTrain.stop();
  }
    
  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return distance <= Math.abs( RobotContainer.driveTrain.getEncoderValue() );
  }

}