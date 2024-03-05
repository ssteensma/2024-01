package frc.robot.Auton;

import frc.robot.System.*;

// CROSS LINE

public class Track01 {

    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0:
                break;

            case 1:
                Autopilot.TurnLftAtSpeed( 0.10  );
                Stage.WaitForHeading( 90, 4 );
                break;

            case 2:
                Autopilot.Stop();
                Stage.WaitForMinDuration( 2.00 );
                break;
            
            case 3:
                Autopilot.TurnLftAtSpeed( 0.10 );
                Stage.WaitForHeading( 0, 4 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
}
