/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

import edu.wpi.first.wpilibj2.command.button.Button;

/**
 * This class is used to allow the behavior of an XboxController's POV controls (DPAD) to
 * be controlled like any other button
 */
public class POVButton extends Button {

    private XboxController controller;
    private int povValue;

    /**
     * Creates a new POVButton instance
     * @param controller the controller to link to
     * @param povValue the value for the button
     */
    public POVButton( XboxController controller, int povValue) {
        this.controller = controller;
        this.povValue = povValue;
    }

    /**
     * Returns true if the button is pressed
     * @return true if the button is pressed
     */
    @Override
    public boolean get() {

        return controller.getPOV() == povValue;
    }
}