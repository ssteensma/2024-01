package frc.robot.System;

public class Mechanism {

    public static void Stop() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public static void Collect() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Suck();
        Mover.Forward();
        Roller.Suck();
        Shooter.Stop();
    }

    public static void Ascend() {
        Aimer.Extend();
        Climber.AutoAscend();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public static void Descend() {
        Aimer.Extend();
        Climber.AutoDescend();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public static void ShootLo() {
        Aimer.Retract();
        Climber.Stop();
        Intake.Stop();
        Mover.Forward();
        Roller.Stop();
        Shooter.ShootLo();
    }

    public static void ShootHi() {
        Aimer.Extend();
        Climber.Stop();
        Intake.Stop();
        Mover.Forward();
        Roller.Stop();
        Shooter.ShootHi();
    }

}
