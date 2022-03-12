package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class LiftArm extends CommandBase
{
    private final double POWER;

    public LiftArm( double power ) 
    {
        addRequirements( RobotContainer.intake );

        POWER = power;
    }

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.intake.move( POWER );
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
