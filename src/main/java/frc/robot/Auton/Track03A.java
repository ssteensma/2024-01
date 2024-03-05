package frc.robot.Auton;

import frc.robot.System.Stage;

// SHOOT AND CROSS LINE

public class Track03A {
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
