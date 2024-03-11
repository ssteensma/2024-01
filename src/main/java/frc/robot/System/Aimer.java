package frc.robot.System;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Ports.pAimer;

public class Aimer extends Command {

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

}
