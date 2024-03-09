package frc.robot.AutonRoutine;

import frc.robot.System.*;

public class WallCrossLine {

    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;

            case 1:
                Autopilot.TranslateS( Auton.DriveSpeed );
                Stage.WaitForMinDistance( Auton.Wall_To_Line + 12 );
                break;

            default: Stage.Last(); break;
        }
    }
}
