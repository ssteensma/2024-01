package frc.robot.System;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Mode.Teleop;

public class Mechanism extends SubsystemBase {

    public static void Collect() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Suck();
        Mover.Forward();
        Roller.Suck();
        Shooter.Stop();
    }

    public Command cCollect() { return this.runOnce( () -> Collect() ); }

    public static void Ascend() {
        Aimer.Extend();
        Climber.AutoAscend();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public Command cAutoAscend() { return this.runOnce( () -> Ascend() ); }

    public static void Descend() {
        Aimer.Extend();
        Climber.AutoDescend();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public Command cAutoDescend() { return this.runOnce( () -> Descend() ); }

    public static void Reset() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public Command cReset() { return this.runOnce( () -> Reset() ); }

    public static void ShootLo() {
        Aimer.Retract();
        Climber.Stop();
        Intake.Stop();
        if ( System.currentTimeMillis() - Teleop.shooter_delay > 0.5 ) {
            Mover.Forward();
        }
        Roller.Stop();
        ShootLo();
    }

    public Command cShootLo() { return this.runOnce( () -> ShootLo() ); }

    public static void ShootHi() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Stop();
        if ( System.currentTimeMillis() - Teleop.shooter_delay > 0.5 ) {
           Mover.Forward();
        }
        Roller.Stop();
        Shooter.ShootHi();
    }

    public Command cShootHi() { return this.runOnce( () -> ShootHi() ); }

}
