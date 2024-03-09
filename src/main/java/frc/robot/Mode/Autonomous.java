package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.AutonRoutine.*;
import frc.robot.System.*;

public class Autonomous {

    public static String
        SelectedAuton = "n/a";
        // SelectedStart = "n/a";

    public static void Initialize () {
        Autopilot   .Reset();
        Navigation  .Reset();
        Stage       .Reset();

        SelectedAuton = ChooserAuton.GetAuton();
        // SelectedStart = Chooser.GetStart();
    }

    public static void Display() {}

    public static void Periodic () {
        Stage.Begin();

        SmartDashboard.putNumber( "STAGE NUMBER", Stage.Number );

        SmartDashboard.putNumber( "Stage 1 Time",  Stage.GetStageTime( 1 ) );
        SmartDashboard.putNumber( "Stage 2 Time",  Stage.GetStageTime( 2 ) );
        SmartDashboard.putNumber( "Stage 3 Time",  Stage.GetStageTime( 3 ) );
        SmartDashboard.putNumber( "Stage 4 Time",  Stage.GetStageTime( 4 ) );
        SmartDashboard.putNumber( "Stage 5 Time",  Stage.GetStageTime( 5 ) );
 
        SmartDashboard.putNumber( "Stage 1 Dist",  Stage.GetStageDist( 1 ) );
        SmartDashboard.putNumber( "Stage 2 Dist",  Stage.GetStageDist( 2 ) );
        SmartDashboard.putNumber( "Stage 3 Dist",  Stage.GetStageDist( 3 ) );
        SmartDashboard.putNumber( "Stage 4 Dist",  Stage.GetStageDist( 4 ) );
        SmartDashboard.putNumber( "Stage 5 Dist",  Stage.GetStageDist( 5 ) );
 
        // for ( int i=6; i<=15; i++ ) {
        //     SmartDashboard.putNumber( "Stage " + i + " Time",  Stage.GetStageTime( i ) );
        //     SmartDashboard.putNumber( "Stage " + i + " Dist",  Stage.GetStageDist( i ) );
        // }

        switch ( SelectedAuton ) {
            case "Do Nothing"             : DoNothing           .Periodic(); break;
            case "Wall Cross Line"        : WallCrossLine       .Periodic(); break;
            case "Shoot Only"             : ShootOnly           .Periodic(); break;
            case "Ctr Shoot, Cross"       : CtrShootCross       .Periodic(); break;
            case "Lft Shoot, Cross"       : LftShootCross       .Periodic(); break;
            case "Rgt Shoot, Cross"       : RgtShootCross   .Periodic(); break;
            case "Ctr Shoot, Cross, Grab" : CtrShootCrossGrab   .Periodic(); break;
            case "Ctr Shoot Twice"        : CtrShootTwice   .Periodic(); break;
        }

        Stage.Next();

        // DRIVETRAIN
        Drivetrain  .UpdateRobotRelative ( Drivetrain.vx, Drivetrain.vy, Drivetrain.vt );
        Onabot      .UpdateMechanism     ();
    }

}
