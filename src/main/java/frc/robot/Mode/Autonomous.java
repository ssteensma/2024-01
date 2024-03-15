package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonRoutine.*;
import frc.robot.System.*;

public class Autonomous {

    public static String
        SelectedAuton = "n/a",
        SelectedColor = "n/a",
        SelectedStart = "n/a",

        SelectedTrack = "n/a";

    public static void Initialize () {
        Autopilot   .Reset();
        Navigation  .Reset();
        Stage       .Reset();

        SelectedAuton = ChooserAuton.GetAuton();
        SelectedColor = ChooserColor.GetColor();
        SelectedStart = ChooserStart.GetStart();

        SelectedTrack = SelectedAuton + "_" + SelectedColor;
    }

    public static void Display() {}

    public static void Periodic () {

        Stage.Begin();

        SmartDashboard.putNumber( "STAGE NUMBER", Stage.Number );

            // for ( int i = 0; i<5; i++ ) {
            //     SmartDashboard.putNumber( "Stage " + i + " Time",  Stage.GetStageTime( i ) );
            //     SmartDashboard.putNumber( "Stage " + i + " Dist",  Stage.GetStageDist( i ) );
            // }

        switch ( SelectedTrack ) {
            case "0_Red"   : Path0      .Periodic(); break;
            case "0_Blue"  : Path0      .Periodic(); break;

            case "1_Red"   : Path1      .Periodic(); break;
            case "1_Blue"  : Path1      .Periodic(); break;

            case "2_Blue"  : Path2      .Periodic(); break;
            case "2_Red"   : Path2      .Periodic(); break;

            case "B_Red"   : PathB_Red  .Periodic(); break;
            case "B_Blue"  : PathB_Blue .Periodic(); break;

            case "C_Red"   : PathC      .Periodic(); break;
            case "C_Blue"  : PathC      .Periodic(); break;

            case "D_Red"   : PathD_Red  .Periodic(); break;
            case "D_Blue"  : PathD_Blue .Periodic(); break;

            // case "E"  : PathDE .Periodic(); break;

            // case "Long Shot" : LongShot.Periodic(); break;

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
