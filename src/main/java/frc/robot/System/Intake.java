package frc.robot.System;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Ports.pIntake;

public class Intake {
    
    public static Spark
        Lft, Rgt;

    public static double
        Power = 0.00,
        Slow  = 0.10,
        Med   = 0.30,
        Fast  = 0.50;

    public static void Initialize() {
        Lft = new Spark( pIntake.PWM_Lft );
        Rgt = new Spark( pIntake.PWM_Rgt );

        // Reverse one of the motors
    }

    public static void Periodic() {
        Lft.set( Power );
        Rgt.set( Power );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Mech/Intake Power", Power );
    }

    public static void Fast() { Power = Fast; }
    public static void Slow() { Power = Slow; }
    public static void Stop() { Power = 0.00; }

}
