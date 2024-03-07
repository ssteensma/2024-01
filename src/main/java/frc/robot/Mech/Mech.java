package frc.robot.Mech;

import frc.robot.System.*;

public class Mech {

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
        Climber.Ascend();
        Intake.Stop();
        Mover.Stop();
        Roller.Stop();
        Shooter.Stop();
    }

    public static void Descend() {
        Aimer.Extend();
        Climber.Descend();
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
