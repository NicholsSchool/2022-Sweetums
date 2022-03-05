package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class BonusSolenoid extends SubsystemBase 
{
    private Solenoid bonusSolenoid;

    public BonusSolenoid() 
    {
        bonusSolenoid = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.BONUS_SOLENOID_CHANNEL );

        bonusSolenoid.set( true );
    }

    public boolean get() 
    {
        return bonusSolenoid.get();
    }

    public void toggle() 
    {
        bonusSolenoid.toggle();
    }
}
