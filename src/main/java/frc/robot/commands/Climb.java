package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Climb extends CommandBase
{
    public Climb() 
    {
        addRequirements( RobotContainer.climber );
    }

    @Override
    public void initialize() 
    {

    }

    @Override
    public void execute() 
    {

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
