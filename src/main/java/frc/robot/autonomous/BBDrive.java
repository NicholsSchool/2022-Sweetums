package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class BBDrive extends CommandBase
{
  public double desiredDistance; 
  public double speed; 

    public BBDrive( double distance, double spd ) 
    {
      desiredDistance = distance / Constants.INCHES_PER_TICK; 
      speed = spd; 
      addRequirements( RobotContainer.driveTrain );
      RobotContainer.driveTrain.resetEncoders();
    }

    @Override
    public void initialize() 
    {
    }

    @Override
    public void execute()
    {
      double delta = desiredDistance - RobotContainer.driveTrain.getRFEncoderValue();
      if (delta > 0) {
          RobotContainer.driveTrain.move(speed, speed);
      } else {
          RobotContainer.driveTrain.move(-speed, -speed);
      }
    }

    @Override
    public void end( boolean interrupted ) 
    {
      RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
       double delta = desiredDistance - RobotContainer.driveTrain.getRFEncoderValue();
       return Math.abs(delta) < Constants.AUTO_DRIVE_TOLERANCE;
    }
}
