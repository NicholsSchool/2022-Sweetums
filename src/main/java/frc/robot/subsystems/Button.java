package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class Button extends SubsystemBase 
{
    private DigitalInput button;

    public Button() 
    {
        button = new DigitalInput( RobotMap.BUTTON_CHANNEL );
    }

    public boolean get() 
    {
        if( button.get() )
            RobotContainer.intake.setDown( RobotContainer.intake.getPosition() );

        return button.get();
    }
}
