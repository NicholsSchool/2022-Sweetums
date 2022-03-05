package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Slider extends SubsystemBase
{
    private Solenoid slider;

    public Slider()
    {
        slider = new Solenoid( PneumaticsModuleType.CTREPCM, RobotMap.SLIDER_SOLENOID_CHANNEL );

        slider.set( false );
    }

    public boolean get() 
    {
        return slider.get();
    }

    public void toggle() 
    {
        slider.toggle();
    }

    public void release()
    {
        slider.set( true );
    }

    public void returnToOriginalState()
    {
        slider.set( false );
    }
}
