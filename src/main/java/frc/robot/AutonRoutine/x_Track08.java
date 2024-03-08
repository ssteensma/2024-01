package frc.robot.AutonRoutine;

import frc.robot.System.Stage;

public class x_Track08 {
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
