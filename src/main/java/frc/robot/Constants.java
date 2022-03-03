// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants 
{
    // Roller Power
    public static final double ROLLER_SPEED = 0.75;

    // Shooter Power
    public static final double SHOOTER_SPEED = 1.0;
    public static final double CLOSE_ENOUGH = 250.0;
    
    // Indexer Power
    public static final double INDEXER_SPEED = 1.0;

    // Shooter Vs
    public static final double HIGH_GOAL_VELOCITY = 16400.0;
    public static final double LOW_GOAL_VELOCITY = 7000.0;
    public static final double THROW_AWAY_VELOCITY = 12000.0;

    // Intake PID Control Loop Constants
    public static final double INTAKE_P = 0.1;
    public static final double INTAKE_I = 0;
    public static final double INTAKE_D = 0.1;
    public static final double INTAKE_Iz = 0;
    public static final double INTAKE_FF = 0;
    public static final double INTAKE_MAX_OUTPUT = 0.50;
    public static final double INTAKE_MIN_OUTPUT = -0.60;

    // Shooter PID Control Loop Constants
    public static final double SHOOTER_F = 0.057;
    public static final double SHOOTER_P = 0.14;
    public static final double SHOOTER_I = 0;
    public static final double SHOOTER_D = 0;
    public static final double SHOOTER_RAMP_TIME = 1;
}