package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Auton.*;
import frc.robot.System.*;

public class Autonomous {

    public static String
        SelectedAuton = "n/a",
        SelectedStart = "n/a";

    public static void Initialize () {
        Autopilot   .Reset();
        Navigation  .Reset();
        Stage       .Reset();

        SelectedAuton = Chooser.GetAuton();
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
            case "Path-00" : Track00.Periodic(); break;
            case "Path-01" : Track01.Periodic(); break;
            case "Path-02" : Track02.Periodic(); break;
            case "Path-03" : Track03.Periodic(); break;
            case "Path-04" : Track04.Periodic(); break;
            case "Path-05" : x_Track05.Periodic(); break;
            case "Path-06" : x_Track05.Periodic(); break;
            case "Path-07" : x_Track07.Periodic(); break;
            case "Path-08" : x_Track08.Periodic(); break;
            case "Path-09" : x_Track09.Periodic(); break;
        }

        Stage.Next();

        // DRIVETRAIN
        Drivetrain  .UpdateRobotRelative ( Drivetrain.vx, Drivetrain.vy, Drivetrain.vt );
        Onabot      .UpdateMechanism     ();
    }

}
