package frc.robot.System;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.pMover;

public class Mover extends SubsystemBase {
 
    public static CANSparkMax
        Mvr;

    public static double
        Power = 0;

    public static void Initialize() {
        Mvr = new CANSparkMax( pMover.CAN_Mvr, MotorType.kBrushless );
        Reset();
    }

    public static void Display() {
        SmartDashboard.putNumber( "Mover Power", Power );
    }

    public static void Periodic() {
        Mvr.set( Power );
    }

    public static double GetPower() { return Power; }

   
    public static void Forward() { Power = -0.50; }
    public static void Reverse() { Power = +0.35; }
    public static void Reset()   { Power = +0.00; }
    public static void Stop()    { Power = +0.00; }

// ====================================

    public Command cForward () { return runOnce( () -> Forward () ); }
    public Command cReverse () { return runOnce( () -> Reverse () ); }
    public Command cReset   () { return runOnce( () -> Reset   () ); }
    public Command cStop    () { return runOnce( () -> Stop    () ); }
 
}
