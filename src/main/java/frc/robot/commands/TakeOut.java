package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TakeOut extends CommandBase 
{
    public TakeOut() 
    {
        addRequirements( RobotContainer.intake );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.roller.move( Constants.OUTTAKE_SPEED );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.roller.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
