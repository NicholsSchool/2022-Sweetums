package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.*;

public class ThrowAway extends CommandBase
{
    public ThrowAway() 
    {
        addRequirements( RobotContainer.shooter, RobotContainer.indexer );
    }

    @Override
    public void initialize() 
    {
        RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
    }

    @Override
    public void execute()
    {
        RobotContainer.shooter.setVelocity( Constants.THROW_AWAY_VELOCITY );

        if( Math.abs( RobotContainer.shooter.getVelocity() - Constants.THROW_AWAY_VELOCITY ) < Constants.CLOSE_ENOUGH )
            RobotContainer.indexer.move( Constants.INDEXER_SPEED );
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
