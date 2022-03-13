package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ClimbV extends CommandBase
{
    public ClimbV() 
    {
        addRequirements( RobotContainer.climber );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.climber.climbAtVelocity( Constants.CLIMBER_CLIMB_VELOCITY * RobotContainer.j1.getRawAxis( 3 ) );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.climber.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
