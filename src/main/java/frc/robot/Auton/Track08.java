package frc.robot.Auton;

import frc.robot.System.Stage;

public class Track08 {
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
