package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class ExtendClimb extends CommandBase
{
    public ExtendClimb() 
    {
        addRequirements( RobotContainer.climber );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.climber.move( Constants.EXTEND_CLIMBER_POWER );
    }

    @Override
    public void end( boolean interrupted ) {}

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
