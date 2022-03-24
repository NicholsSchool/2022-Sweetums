package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Slider extends SubsystemBase
{
    private Solenoid slider;

    public Slider()
    {
        slider = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.SLIDER_SOLENOID_CHANNEL );

        // lock();
    }

    public boolean get() 
    {
        return slider.get();
    }

    public void toggle() 
    {
        slider.toggle();
    }

    public void lock()
    {
        slider.set( Constants.SLIDER_LOCKED );
    }

    public void unlock()
    {
        slider.set( Constants.SLIDER_UNLOCKED );
    }
}
