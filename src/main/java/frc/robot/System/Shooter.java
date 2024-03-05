package frc.robot.System;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.Ports.pShooter;

public class Shooter {
    
    // TALON FX
    public static TalonFX
        Lo,
        Hi;

    public static double
        Power;

    public static void Initialize() {
        Lo = new TalonFX( pShooter.CAN_Lo );
        Hi = new TalonFX( pShooter.CAN_Hi );
    }

    public static void Periodic() {
        Lo.set( Power );
        Hi.set( Power );
    }

    public static double GetPower() { return Power; }

    public static void Reset()           { Power = 0; }
    public static void Shoot( double P ) { Power = P; }
    public static void Stop()            { Power = 0; }

    public static void ShootLo() { Power = 0.50; }
    public static void ShootHi() { Power = 1.00; }
}
