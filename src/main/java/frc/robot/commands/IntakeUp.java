package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class IntakeUp extends CommandBase 
{
    public IntakeUp() 
    {
        addRequirements( RobotContainer.intake );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.intake.goToPosition( Constants.UP );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.intake.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
