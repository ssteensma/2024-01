package frc.robot.System;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Ports.pClimber;

public class Climber {
    
    // TALONFX
    public static TalonFX
        Mtr = new TalonFX( pClimber.CAN_Clmb );

    public static double
        Power = 0.00;
    
    public static void Initialize() {
        Mtr.setInverted( false );
    }

    public static void Periodic() {
        Mtr.set( Power );
    }

    public static void Ascend()  { Power =  1.00; }
    public static void Descend() { Power = -0.30; }

    public static void Reset()   { Power =  0.00; }
    public static void Stop ()   { Power =  0.00; }
}
