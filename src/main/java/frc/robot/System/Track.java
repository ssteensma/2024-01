package frc.robot.System;

public class Track {

    // DO NOTHING - DO NOT CHANGE THIS
    public static void Track_00 () {
        switch ( Stage.Number ) {
            default:
                Stage.Last();
                break;
        }
    }

    // SS - Trouble Shooting turn directions
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

    // SS - TROUBLE SHOOTING
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

    // SS - Used to convert clicks to inches
    public static void Track_03 () {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.DriveNorth( 0.20 );
                Stage.WaitForDuration( 20.0 );
                break;

            default:
                Stage.Last();
                break;
        }
    }

    // NP - Drive around chair in hallway
    public static void Track_04 () {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.DriveWest( 0.20 );
                Stage.WaitForDuration( 3.0 );
                break;

            case 1:
                Autopilot.DriveNorth( 0.20 );
                Stage.WaitForDuration( 9.0 );
                break;

            case 2:
                Autopilot.DriveEast( 0.20 );
                Stage.WaitForDuration( 4.0 );
                break;

            case 3:
                Autopilot.DriveSouth( 0.20 );
                Stage.WaitForDuration( 9.0 );
                break;

            default:
                Stage.Last();
                break;
        }
    }

}
