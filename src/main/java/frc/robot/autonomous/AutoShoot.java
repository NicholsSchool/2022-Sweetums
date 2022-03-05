package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class AutoShoot extends CommandBase {
    
    public AutoShoot() {

        addRequirements(RobotContainer.shooter);
    }

    @Override
    public void initialize() {

      RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
  
    }

    @Override
    public void execute() {
        
          if( RobotContainer.shooter.getVelocity() < Constants.LOW_GOAL_VELOCITY )
            RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
        else
            RobotContainer.indexer.move( Constants.INDEXER_SPEED );
    }

    @Override
    public void end(boolean interrupted) {

        RobotContainer.shooter.stop();
        RobotContainer.indexer.stop();
    }

    @Override
    public boolean isFinished() {
      return false; 
  
    }
}
