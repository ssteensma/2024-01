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

}
