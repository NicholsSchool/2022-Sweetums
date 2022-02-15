package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class SlideForward extends CommandBase 
{
    public SlideForward() 
    {
        addRequirements( RobotContainer.slider );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.slider.slideForward();
    }

    @Override
    public void end( boolean interrupted )
    {
        RobotContainer.slider.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}
