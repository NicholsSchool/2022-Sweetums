package frc.robot.commands;

import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class GoDown extends CommandBase 
{

    public GoDown() 
    {
        addRequirements( RobotContainer.intake );
    }    

    @Override
    public void initialize() {}

    @Override
    public void execute()
    {
        RobotContainer.intake.move( Constants.INTAKE_GO_DOWN_POWER );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.intake.stop();
        RobotContainer.intake.resetDown();
    }

    @Override
    public boolean isFinished() 
    {
        return RobotContainer.button.get();
    }    
}
