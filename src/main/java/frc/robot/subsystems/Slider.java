package frc.robot.subsystems;

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
    }
}
