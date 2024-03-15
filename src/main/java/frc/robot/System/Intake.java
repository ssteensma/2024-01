package frc.robot.System;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.pIntake;

public class Intake extends SubsystemBase {
    
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

        Lft.setSmartCurrentLimit( 25, 10 );
        Rgt.setSmartCurrentLimit( 25, 10 );
    }

    public static void Display() {
        SmartDashboard.putNumber( "Intake Power", Power );
    }

    public static void Periodic() {
        Lft.set( Power );
        Rgt.set( Power );
    }

    public static double GetPower () { return Power; }
    public static void   Reset    () { Power = 0;    }

    public static void Suck() { Power =  0.50; }
    public static void Spit() { Power = -0.50; }
    public static void Stop() { Power =  0.00; }

// ====================================

    public Command cSpit() { return this.runOnce( () -> Spit() ); }
    public Command cStop() { return this.runOnce( () -> Stop() ); }
    public Command cSuck() { return this.runOnce( () -> Suck() ); }

}
