package frc.robot.System;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import frc.robot.Ports.pClimber;

public class Climber {
    
    // SPARK MAX
    public static CANSparkMax
        Mtr = new CANSparkMax( pClimber.CAN_Clmb, MotorType.kBrushless );

    public static double
        Power = 0.00;
    
    public static void Initialize() {
        Mtr.setInverted( false );
    }

    public static void Periodic() {
        Mtr.set( Power );
    }

    public static void Climb( double P ) { Power = P;    }
    public static void Reset()           { Power = 0.00; }
    public static void Stop ()           { Power = 0.00; }
}
