package frc.robot.System;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Ports.pIntake;

public class Intake {
    
    public static Spark
        Lft, Rgt;

    public static double
        Power = 0;

    public static void Initialize() {
        Lft = new Spark( pIntake.pPWM_Lft );
        Rgt = new Spark( pIntake.pPWM_Rgt );

        // Reverse one of the motors
    }

    public static void Periodic() {
        Lft.set( Power );
        Rgt.set( Power );
    }

    public static void Display() {

    }

    public static void Fast() {
        Power = 1.00;
    }

    public static void SetPower( double power ) {
        Power = power;
    }

    public static void Slow() {
        Power = 0.20;
    }

    public static void Stop() {
        Power = 0;
    }


}
