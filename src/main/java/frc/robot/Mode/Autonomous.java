package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonRoutine.*;
import frc.robot.System.*;

public class Autonomous {

    public static String
        SelectedAuton = "n/a",
        SelectedColor = "n/a",
        SelectedStart = "n/a";

    public static void Initialize () {
        Autopilot   .Reset();
        Navigation  .Reset();
        Stage       .Reset();

        SelectedAuton = ChooserAuton.GetAuton();
        SelectedColor = ChooserColor.GetColor();
        SelectedStart = ChooserStart.GetStart();
    }

    public static void Display() {}

    public static void Periodic () {

        Stage.Begin();

        SmartDashboard.putNumber( "STAGE NUMBER", Stage.Number );

            for ( int i = 0; i<5; i++ ) {
                SmartDashboard.putNumber( "Stage " + i + " Time",  Stage.GetStageTime( i ) );
                SmartDashboard.putNumber( "Stage " + i + " Dist",  Stage.GetStageDist( i ) );
            }

        switch ( SelectedAuton ) {
            case "0"  : Path0  .Periodic(); break;
            case "1"  : Path1  .Periodic(); break;

            case "A"  : PathAB .Periodic(); break;
            case "B"  : PathAB .Periodic(); break;
            case "C"  : PathC  .Periodic(); break;
            case "D"  : PathDE .Periodic(); break;
            case "E"  : PathDE .Periodic(); break;

            case "Long Shot" : LongShot.Periodic(); break;

            // case "Do Nothing"             : DoNothing           .Periodic(); break;
            // case "Wall Cross Line"        : WallCrossLine       .Periodic(); break;
            // case "Shoot Only"             : ShootOnly           .Periodic(); break;
            // case "Ctr Shoot, Cross"       : CtrShootCross       .Periodic(); break;
            // case "Lft Shoot, Cross"       : LftShootCross       .Periodic(); break;
            // case "Rgt Shoot, Cross"       : RgtShootCross       .Periodic(); break;
            // case "Ctr Shoot, Cross, Grab" : CtrShootCrossGrab   .Periodic(); break;

            // case "Ctr Shoot Twice"        : CtrShootTwice       .Periodic(); break;
            // case "Lft Shoot Twice"        : LftShootTwice       .Periodic(); break;
            // case "Rgt Shoot Twice"        : RgtShootTwice       .Periodic(); break;

        }

        Stage.Next();

        // DRIVETRAIN
        Drivetrain  .UpdateRobotRelative ();
        Onabot      .UpdateMechanism     ();
    }

}
