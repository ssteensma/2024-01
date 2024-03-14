package frc.robot.AutonRoutine;

import frc.robot.Mode.Autonomous;
import frc.robot.System.*;

public class PathDE {
    static double D1 = 10.0 * Auton.toIn - Auton.RobotLength;
    static double D2 = 19.5 * Auton.toIn - Auton.RobotLength;

    static double E1 = 52.5 * Auton.toIn - Auton.RobotLength;
    static double E2 = 58.0 * Auton.toIn - Auton.RobotLength;

    static double Z1 = 0;
    static double Z2 = 0;

    public static void Periodic() {

        if ( Autonomous.SelectedAuton == "D" ) {
            Z1 = D1;
            Z2 = D2;
        }
        else {
            Z1 = E1;
            Z2 = E2;
        }

        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3: Auton.TurnLft( 60 ); break;

            case 4:
                Autopilot.ReverseAtHeading( 0.20, 0 );
                Stage.WaitForMinDistance( 27*12 );
                break;
            
            // case 4: if ( Autonomous.SelectedColor == "Blue" ) { Auton.TurnLft( 60 ); }  else { Auton.TurnRgt( 300 ); } break;
            // case 5: Auton.Backup( 18 ); break; 

            case 5: Auton.TransToRing(); break;
            case 6: Auton.CollectRing(); break;

            case 7: Auton.TurnRgt( 328 ); break;

            case 8: Auton.Forward( 36 );

            case 9: Auton.TransToSpeaker(); break;

            // case  8: Auton.Forward( Z2 ); break;
            // case  9: if ( Autonomous.SelectedColor == "Blue" ) { Auton.TurnLft( 0 ); }  else { Auton.TurnRgt( 0 ); } break;

            // ASSUMING THE SPEAKER CAN BE SEEN FROM THAT DISTANCE
            // Otherwise we need to include the D1 distance in some way
            case 10: Auton.TransToSpeaker(); break;

            case 11: Auton.PrepShooter(); break;
            case 12: Auton.ShootHi    (); break;

            default: Stage.Last(); break;
        }
    }
}
