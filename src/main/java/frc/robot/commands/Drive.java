package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Drive extends CommandBase 
{
    public Drive() 
    {
        addRequirements( RobotContainer.driveTrain );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() 
    {
        RobotContainer.driveTrain.move(
            RobotContainer.c0.getLeftY(), 
            RobotContainer.c0.getRightY()
        );
    }

    @Override
    public void end( boolean interrupted )
    {
        RobotContainer.driveTrain.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}