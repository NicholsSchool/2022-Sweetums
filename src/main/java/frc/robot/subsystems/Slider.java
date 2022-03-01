package frc.robot.subsystems;

<<<<<<< HEAD
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Slider extends SubsystemBase {
    private WPI_TalonSRX window; 
    /**
     * Creates a new SLider
     */
    public Slider()
    {
        window = new WPI_TalonSRX( RobotMap.WINDOW_ID ); 
        window.configFactoryDefault(); 
    }

    public void move(double speed) {
        window.set(speed);

    }

    /**
     * Moves Slider forward
     * @param speed
     */
    public void slideForward()
    {
        move( RobotMap.SLIDER_SPEED );
    }
    /**
     * Moves Slider backward
     * @param speed
     */
    public void slideBackWard( )
    {
        move( -RobotMap.SLIDER_SPEED ); 
    }
    /**
     * Stops window motor
     */
    public void stop()
    {
        window.stopMotor(); 
=======
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

        slider.set( true );
    }

    public boolean get() 
    {
        return slider.get();
    }

    public void releaseSlider()
    {
        slider.set( false );
    }

    public void returnOriginalState()
    {
        slider.set( true );
>>>>>>> 3eee1c0e885e0cd3afe542e4e070a6e74a9deb18
    }
}
