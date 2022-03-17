package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootTest extends CommandBase
{
    public ShootTest() 
    {
        addRequirements( RobotContainer.shooter, RobotContainer.indexer );
    }

    @Override
    public void initialize() 
    {
        RobotContainer.shooter.move( Constants.TEST_VELOCITY );
    }

    @Override
    public void execute()
    {
        RobotContainer.shooter.setVelocity( Constants.LOW_GOAL_VELOCITY );

        if( Math.abs( RobotContainer.shooter.getVelocity() - Constants.TEST_VELOCITY ) < Constants.CLOSE_ENOUGH )
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
