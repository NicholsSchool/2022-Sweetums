package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Unfold extends CommandBase
{
    public Unfold() 
    {
        addRequirements( RobotContainer.climber );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.climber.move( Constants.CLIMBER_UNFOLD_VELOCITY );
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
