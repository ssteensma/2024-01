package frc.robot.AutonRoutine;

import frc.robot.Mode.Autonomous;
import frc.robot.System.*;

// NARROW SIDE
// BLU LFT
// RED RGT

public class NarShootCross {
    public static void Periodic() {
        switch ( Stage.Number ) {
            case 0: break;
        
            case 1: Auton.PrepShooter(); break;
            case 2: Auton.ShootHi    (); break;

            case 3: Auton.Backup( 34 ); break;

            case 4:
                if ( Autonomous.SelectedColor == "Red" ) { Auton.TurnLft60(); } else { Auton.TurnRgt60(); }
                break;

            case 5:
                break;

            

            default: Stage.Last(); break;
        }
    }
}
