package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class Path1 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;

            case 1: Auton.BackupWall(); break;

            default: Stage.Last(); break;
        }
    }
}
