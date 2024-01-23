package frc.robot.System;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Ports;

public class Intake extends Subsystem {

    public static double
        Fast = 1.00,
        Slow = 0.40,
        Stop = 0.00;

    public static Spark
        T,
        B;

    public Intake() {
        T = new Spark( Ports.pIntake.pPWM_Top );    
        B = new Spark( Ports.pIntake.pPWM_Bot );    
    }

    public static void Spit() {
        T.set( Fast );
        B.set( Fast );
    }

    public static void Stop() {
        T.set( Stop );
        B.set( Stop );
    }

    public static void Suck() {
        T.set( Slow );
        B.set( Slow );
    }

}
