package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class IntakeSwitch extends SubsystemBase
{
    DigitalInput intakeSwitch;

    public IntakeSwitch() 
    {
        intakeSwitch = new DigitalInput( RobotMap.INTAKE_LIMIT_SWITCH_CHANNEL );
    }

    public void getPressed() 
    {
        if( intakeSwitch.get() )
            RobotContainer.intake.stopAndSetEncoder( Constants.DOWN );
    }
}
