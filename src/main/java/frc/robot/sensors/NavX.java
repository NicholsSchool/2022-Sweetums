
package frc.robot.sensors;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.Constants;

public class NavX {

    private AHRS navX;

    /**
     * Creates a new NavX instance
     * @param ahrs the AHRS instance to use
     */
    public NavX( AHRS ahrs ) 
    {
        this.navX = ahrs;
    }

    /**
     * Returns the current angle of the robot's NavX
     * 
     * @return the current angle of the robot's NavX
     */
    public double getAngle() 
    {
        return navX.getYaw();
    }

    /**
     * returns true if we're at the desired angle, false else
     * 
     * @param angle angle to compare
     * @return true if at desired angle, false else
     */
    public boolean atAngle( double angle ) 
    {
        return Math.abs( -getAngle() - angle ) < Constants.CLOSE_ENOUGH_ANGLE;
    }
    /**
     * Resets the navX
     */
    public void reset() 
    {
        navX.reset();
    }
}