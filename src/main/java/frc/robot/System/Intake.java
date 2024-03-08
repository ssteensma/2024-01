package frc.robot.System;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Ports.pIntake;

public class Intake {
    
    // SPARK MAX
    public static CANSparkMax
        Lft = new CANSparkMax( pIntake.CAN_Lft, MotorType.kBrushless ),
        Rgt = new CANSparkMax( pIntake.CAN_Rgt, MotorType.kBrushless );

    public static double
        Power = 0.00,
        Slow  = 0.10,
        Med   = 0.30,
        Fast  = 0.50;

    public static void Initialize() {
        Lft.setInverted( true  );
        Rgt.setInverted( false );

        Lft.setSmartCurrentLimit( 20, 10 );
        Rgt.setSmartCurrentLimit( 20, 10 );
    }

    public static double GetPower() { return Power; }
    public static void Reset() { Power = 0; }

    public static void Periodic() {
        Lft.set( Power );
        Rgt.set( Power );
    }

    public static void Suck() { Power =  0.50; }
    public static void Spit() { Power = -0.50; }
    public static void Stop() { Power =  0.00; }

}
