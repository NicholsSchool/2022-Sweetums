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

        // hooks.latch();
    }

    public boolean get() 
    {
        return hooks.get();
    }

    public void toggle() 
    {
        hooks.toggle();
    }

    public void latch() 
    {
        hooks.set( Constants.HOOKS_LATCHED );
    }

    public void unlatch() 
    {
        hooks.set( Constants.HOOKS_UNLATCHED );
    }
}
