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
    // 
    public static final double ROLLER_SPEED = 0.2;

    // Shooter Power
    public static final double SHOOTER_SPEED = 1.0;
    
    // Indexer Power
    public static final double INDEXER_SPEED = 1.0;

    // Shooter Vs
    public static final double HIGH_GOAL_VELOCITY = 16400.0;
    public static final double LOW_GOAL_VELOCITY = 7200.0;
    public static final double THROW_AWAY_VELOCITY = 1000.0;

    // Intake PID Control Loop Constants
    public static final double INTAKE_P = 0.1;
    public static final double INTAKE_I = 1e-4;
    public static final double INTAKE_D = 0.1;
    public static final double INTAKE_Iz = 0;
    public static final double INTAKE_FF = 0;
    public static final double INTAKE_MAX_OUTPUT = 0.05;
    public static final double INTAKE_MIN_OUTPUT = -0.05;

    // Intake Speed
    public static final double INTAKE_SPEED = 0.5; 
    public static final double OUTTAKE_SPEED = -0.5; 

    // Intake Positions
    public static final double GROUND = 0;
    public static final double UP = -50;

    // Autonomous Timings & Velocities
    public static final double AUTO_SHOOT_TIME = 2.5;
    public static final double AUTO_DRIVE_SPEED = 0.2;
    public static final double AUTO_DISTANCE = 100.0;
}