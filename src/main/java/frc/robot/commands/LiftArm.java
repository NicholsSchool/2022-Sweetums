package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class LiftArm extends CommandBase
{
    public LiftArm() 
    {
        addRequirements( RobotContainer.intake );
    }

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.intake.move( RobotContainer.j3.getY() );;
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
