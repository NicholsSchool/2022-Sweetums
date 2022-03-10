package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Hooks extends SubsystemBase 
{
    private Solenoid hooks;

    public Hooks() 
    {
        hooks = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.HOOKS_SOLENOID_CHANNEL );

        hooks.set( Constants.HOOKS_IN );
    }

    public void toggle() 
    {
        hooks.toggle();
    }
}
