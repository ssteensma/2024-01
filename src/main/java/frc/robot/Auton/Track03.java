package frc.robot.Auton;

import frc.robot.System.*;

// FROM CENTER - SHOOT AND BACK

public class Track03 {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;
        
            case 1:
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 1.50 );
                break;

            case 2:
                Mover.Forward();
                Shooter.Shoot( 1.00 );
                Stage.WaitForMinDuration( 2.00 );
                break;

            case 3:
                Mover.Stop();
                Shooter.Stop();
                break;

            case 4:
                Autopilot.TranslateS( 0.20 );
                Stage.WaitForMinDistance( 128 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
