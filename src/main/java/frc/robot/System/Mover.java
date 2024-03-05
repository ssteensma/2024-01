package frc.robot.System;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Ports.pMover;

public class Mover {
 
    public static CANSparkMax
        Mvr;

    public static double
        Power = 0;

    public static void Initialize() {
        Mvr = new CANSparkMax( pMover.CAN_Mvr, MotorType.kBrushless );
        Reset();
    }

    public static void Periodic() {
        Mvr.set( Power );
    }

    public static double GetPower() { return Power; }

    public static void Forward() { Power = -0.50; }
    public static void Reverse() { Power = +0.50; }
    public static void Reset()   { Power = +0.00; }
    public static void Stop()    { Power = +0.00; }

}
