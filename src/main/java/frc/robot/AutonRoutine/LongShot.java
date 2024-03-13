package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class LongShot {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1:
                Autopilot.DriveAtBackardAtHeading( 0.35, 0 );
                Stage.WaitForMinDistance( 27*12 );
                break;

            case 2: Auton.TransToRing(); break;
            case 3: Auton.CollectRing(); break;

            case 4:
                Autopilot.DriveAtForwardAtHeading( 0.35, 0 );
                Stage.WaitForMinDistance( 30*12 );
                break;
    
            default: Stage.Last(); break;
        }
    }
}
