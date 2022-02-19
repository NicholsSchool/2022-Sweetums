package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SortBackward extends CommandBase 
{
    public SortBackward() 
    {
        addRequirements( RobotContainer.sorter );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.sorter.move( -Constants.SORTER_SPEED );
    }

    @Override
    public void end( boolean interrupted )
    {
        RobotContainer.sorter.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
