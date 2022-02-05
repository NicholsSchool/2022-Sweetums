package frc.robot.util;

import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is used to allow the behavior of an XboxController's Trigger
 *  to be controlled like any other button
 */
public class Trigger extends Button {

    private XboxController controller;
    private int axisID;

    /**
     * Creates a Trigger instance
     * @param controller the controller to link to
     * @param axisID the axis id of the desired trigger
     */
    public Trigger( XboxController controller, int axisID )
    {
        this.controller = controller;
        this.axisID = axisID;
    }

    /**
     * returns true if the trigger is pressed down
     * @return true if the trigger is pressed down
     */
    @Override
    public boolean get()
    {
        return controller.getRawAxis( axisID ) > 0.75;
    }
}