package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TuckClimber extends CommandBase 
{
    public TuckClimber() 
    {
        addRequirements( RobotContainer.climber );
    }
    
    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.climber.climb( Constants.CLIMBER_TUCK_POWER );
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
