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

public class AutoShoot extends CommandBase
{
  private double startTime;
  private double time;
  private double speed;
  private double indexer;

  /**
   * @param sec time spent reving the shooter and shooting
   * @param spd speed of the shooter
   * @param indexSpeed speed of the indexer
   */
  public AutoShoot( double sec, double spd, double indexSpeed ) 
  {
      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements( RobotContainer.shooter, RobotContainer.indexer );
      time = sec;
      speed = spd;
      indexer = indexSpeed;
  }
    
  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    startTime = System.currentTimeMillis();
  }
    
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    
    if( time >= System.currentTimeMillis() - startTime )
    {
      RobotContainer.shooter.move( speed );

      if( RobotContainer.shooter.getVelocity() >= speed * ( 9 / 10 ) )
        RobotContainer.indexer.move( indexer );
    }

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
    return time <= System.currentTimeMillis() - startTime;
  }

}