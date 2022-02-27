package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootHigh extends CommandBase
{
    public ShootHigh() 
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
        if( RobotContainer.shooter.getVelocity() < Constants.HIGH_GOAL_VELOCITY )
            RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
        else
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
