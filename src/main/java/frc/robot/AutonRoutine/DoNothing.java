package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class DoNothing {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;

            default: Stage.Last(); break;
        }
    }
}
