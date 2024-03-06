package frc.robot.Auton;

import frc.robot.System.*;

// SHOOT ONLY

public class Track02 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 3.00 );
                break;

            case 2:
                Mover.Forward();
                Stage.WaitForMinDuration( 3.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
