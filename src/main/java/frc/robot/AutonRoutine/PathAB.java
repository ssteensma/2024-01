package frc.robot.AutonRoutine;

import frc.robot.Mode.Autonomous;
import frc.robot.System.*;

public class PathAB {
    static double A1 = 16.0 * Auton.toIn - Auton.RobotLength;
    static double A2 = 77.0 * Auton.toIn - Auton.RobotLength;

    static double B1 = 10.5 * Auton.toIn - Auton.RobotLength;
    static double B2 = 19.5 * Auton.toIn - Auton.RobotLength;

    static double Z1 = 0;
    static double Z2 = 0;

    public static void Periodic() {

        if ( Autonomous.SelectedAuton == "A" ) { // BOTH; CENTER
            Z1 = A1;
            Z2 = A2;
        }
        else { // B; RED OR BLUE
            Z1 = B1;
            Z2 = B2;
        }

        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3: Auton.Backup( Z1 ); break;

            case 4: if ( Autonomous.SelectedColor == "Blue" ) { Auton.TurnRgt( 300 ); }  else { Auton.TurnLft( 60 ); } break;
            case 5: Auton.Backup( Z2 ); break; 

            case 6: Auton.TransToRing(); break;
            case 7: Auton.CollectRing(); break;

            case  8: Auton.Forward( Z2 );
            case  9: if ( Autonomous.SelectedColor == "Blue" ) { Auton.TurnLft( 0 ); }  else { Auton.TurnRgt( 0 ); } break;

            // ASSUMING THE SPEAKER CAN BE SEEN FROM THAT DISTANCE
            // Otherwise we need to include the D1 distance in some way
            case 10: Auton.TransToSpeaker();

            case 11: Auton.PrepShooter(); break;
            case 12: Auton.ShootHi    (); break;

            default: Stage.Last(); break;
        }
    }
}
