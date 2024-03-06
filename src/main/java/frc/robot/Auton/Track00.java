package frc.robot.Auton;

import frc.robot.System.*;

// DO NOTHING

public class Track00 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
