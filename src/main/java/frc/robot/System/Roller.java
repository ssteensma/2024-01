package frc.robot.System;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.pRoller;


public class Roller extends SubsystemBase {

    // SHOULD BE VICTOR SPX
    public static TalonSRX
        Rlr;

    public static double
        Power;
    
    public static void Initialize() {
        Rlr = new TalonSRX( pRoller.CAN_Roller );
        Rlr.setInverted( true );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Roller Power", Power );
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

// ====================================

    public Command cReset() { return this.runOnce( () -> Reset() ); }
    public Command cSpit () { return this.runOnce( () -> Spit () ); }
    public Command cStop () { return this.runOnce( () -> Stop () ); }
    public Command cSuck () { return this.runOnce( () -> Suck () ); }

}
