package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Shoot extends CommandBase
{
    public Shoot() 
    {
        addRequirements( RobotContainer.shooter, RobotContainer.indexer );
    }

    @Override
    public void initialize() 
    {
        RobotContainer.shooter.move( Constants.SHOOTER_POWER );
    }

    @Override
    public void execute()
    {
        while( RobotContainer.shooter.getVelocity() < Constants.DESIRED_V ) 
        {
            RobotContainer.shooter.move( Constants.SHOOTER_POWER );
        }

        RobotContainer.shooter.move( Constants.SHOOTER_POWER );
        RobotContainer.indexer.move( Constants.INDEXER_POWER );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.shooter.stop();
        RobotContainer.indexer.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
