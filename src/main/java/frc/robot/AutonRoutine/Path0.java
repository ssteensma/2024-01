package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class Path0 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;

            default: Stage.Last(); break;
        }
    }
}
