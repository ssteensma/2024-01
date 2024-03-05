package frc.robot.System;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Ports.pRoller;


public class Roller {

    // SHOULD BE VICTOR SPX
    public static TalonSRX
        Rlr;

    public static double
        Power;
    
    public static void Initialize() {
        Rlr = new TalonSRX( pRoller.CAN_Roller );
        Rlr.setInverted( true );
    }

    public static void Periodic() {
        Rlr.set( TalonSRXControlMode.PercentOutput, Power );
    }

    public static void Spin( double P ) {
        Power = P;
    }

    public static double GetPower() { return Power; }

    public static void Reset() { Power = +0.00; }
    public static void Spit () { Power = -0.50; }
    public static void Stop () { Power = +0.00; }
    public static void Suck () { Power = +0.50; }
}
