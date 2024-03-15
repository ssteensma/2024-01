package frc.robot.System;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.pAimer;

public class Aimer extends SubsystemBase {

    public static DoubleSolenoid
        Lft,
        Rgt;
    
    public static DoubleSolenoid.Value
        State;

    public static void Initialize() {
        Lft = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, pAimer.PCM_Lft[1], pAimer.PCM_Lft[0] );
        Rgt = new DoubleSolenoid( PneumaticsModuleType.CTREPCM, pAimer.PCM_Rgt[0], pAimer.PCM_Rgt[1]  );
        Reset();
    }

    public static void Display() {
        SmartDashboard.putString( "Aimer State", GetState() );        
    }

    public static void Periodic() {
        Lft.set( State );
        Rgt.set( State );
    }

    public static String GetState() {
        return State == DoubleSolenoid.Value.kForward ? "Extend" : "Retract";
    }

    public static void Reset()   { Extend(); }
    public static void Extend()  { State = DoubleSolenoid.Value.kForward; }
    public static void Retract() { State = DoubleSolenoid.Value.kReverse; }

// ====================================

    public Command cExtend  () { return this.runOnce( () -> Extend  () ); }
    public Command cRaise   () { return this.runOnce( () -> Extend  () ); }

    public Command cRetract () { return this.runOnce( () -> Retract () ); }
    public Command cLower   () { return this.runOnce( () -> Retract () ); }

    public Command cReset   () { return this.runOnce( () -> Reset   () ); }

}
