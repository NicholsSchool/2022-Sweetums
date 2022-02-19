package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootLow extends CommandBase
{
    public ShootLow() 
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
        RobotContainer.shooter.move( Constants.SHOOTER_POWER );

        if( RobotContainer.shooter.getVelocity() >= Constants.LOW_GOAL_VELOCITY )
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