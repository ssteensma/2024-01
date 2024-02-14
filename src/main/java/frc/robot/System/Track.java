package frc.robot.System;

public class Track {

    public static void Track_00 () {
        switch ( Stage.Number ) {
            case 0:
                Autopilot.Stop();
                Stage.WaitForDuration( 2.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
    
    public static void Track_01 () {
        switch ( Stage.Number ) {
            case 0:
                Stage.WaitForDuration( 1.00 );
                break;

            default:
                Stage.Last();
                break;
        }
    }
    
}
