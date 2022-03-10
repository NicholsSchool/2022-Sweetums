package frc.robot.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ShootBalls extends CommandBase
{
    private final double VELOCITY;

    public ShootBalls( double v ) 
    {        
        addRequirements( RobotContainer.shooter, RobotContainer.indexer );

        VELOCITY = v;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.shooter.setVelocity( VELOCITY );

        if( Math.abs( RobotContainer.shooter.getVelocity() - VELOCITY ) < Constants.CLOSE_ENOUGH )
            RobotContainer.indexer.index(); 
            
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
