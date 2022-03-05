package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Hooks extends SubsystemBase 
{
    private Solenoid hooks;

    public Hooks() 
    {
        hooks = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.HOOKS_SOLENOID_CHANNEL );
    }

    public void toggle() 
    {
        hooks.toggle();
    }
}
