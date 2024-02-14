package frc.robot.System;

public class Track {

    // DO NOTHING
    public static void Track_00 () {
        switch ( Stage.Number ) {
            default:
                Stage.Last();
                break;
        }
    }

    public static void Track_01 () {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.TurnLeftAtSpeed( 0.10 );
                Stage.WaitForDuration( 5.00 );
                break;

            case 1:
                Autopilot.Stop();
                Stage.WaitForDuration( 3.00 );
                break;

            case 2:
                Autopilot.TurnRightAtSpeed( 0.10 );
                Stage.WaitForDuration( 5.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }

    public static void Track_02 () {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.DriveSouth( 0.10 );
                Stage.WaitForDuration( 2.00 );
                break;

            case 1:
                Autopilot.DriveWest( 0.10 );
                Stage.WaitForDuration( 2.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }

}
