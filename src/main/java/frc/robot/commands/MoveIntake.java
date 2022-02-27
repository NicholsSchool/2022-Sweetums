package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class MoveIntake extends CommandBase 
{
    public MoveIntake() 
    {
        addRequirements( RobotContainer.intake );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.intake.move( -RobotContainer.c2.getRightY() );
        Robot.state.put( "c2RY", -RobotContainer.c2.getRightY() );
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
