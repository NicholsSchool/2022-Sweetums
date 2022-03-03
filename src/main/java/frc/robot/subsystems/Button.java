package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class Button extends SubsystemBase 
{
    private DigitalInput button;

    private boolean firstTime = false;

    public Button() 
    {
        button = new DigitalInput( RobotMap.BUTTON_CHANNEL );
    }

    public boolean get() 
    {
        if( button.get() && !firstTime )
        {
            firstTime = true;
            RobotContainer.intake.setUp( RobotContainer.intake.getPosition() );
            RobotContainer.intake.resetEncoder();
        }
        return button.get();
    }
}
