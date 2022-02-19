package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TakeIn extends CommandBase 
{
    public TakeIn() 
    {
        addRequirements( RobotContainer.roller);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.roller.move( Constants.ROLLER_SPEED );
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
