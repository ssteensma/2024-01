package frc.robot.System;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class Shuffle {
    
    public static ShuffleboardTab AutoTab = Shuffleboard.getTab( "Auto" );
    public static ShuffleboardTab DrivTab = Shuffleboard.getTab( "Driv" );
    public static ShuffleboardTab LimeTab = Shuffleboard.getTab( "Lime" );
    public static ShuffleboardTab MechTab = Shuffleboard.getTab( "Mech" );

    public static ShuffleboardLayout CamIntake = Shuffleboard.getTab("Lime")
        .getLayout( "Intake Cam", BuiltInLayouts.kList )
        .withSize( 5, 1 );

    public static void Initialize() {

        // AUTON TAB
        AutoTab.add( "Auton Chooser"   , Chooser    .autonchooser                      ).withPosition( 1, 1 ).withSize( 2, 1 );
        // AutoTab.add( "Stage Distance"  , Stage      .GetStageDist( Stage.Number ) ).withPosition( 2, 1 ).withSize( 2, 1 );
        AutoTab.add( "Stage Number"    , Stage      .GetStageNumber()             ).withPosition( 3, 1 ).withSize( 2, 1 );

        // DRIVETRAIN TAB
        DrivTab.add( "FL Power", Drivetrain.FL_module.GetPower() ).withPosition( 0, 0 ).withSize( 2, 1 );
        DrivTab.add( "FR Power", Drivetrain.FR_module.GetPower() ).withPosition( 3, 1 ).withSize( 2, 1 );
        DrivTab.add( "RL Power", Drivetrain.FL_module.GetPower() ).withPosition( 1, 2 ).withSize( 2, 1 );
        DrivTab.add( "RR Power", Drivetrain.FR_module.GetPower() ).withPosition( 3, 2 ).withSize( 2, 1 );

        // LIMELIGHT TAB
        LimeTab.add( "Target TX"       , CamTarget  .TX() ).withPosition( 1, 1 ).withSize( 2, 1 );
        LimeTab.add( "Target TY"       , CamTarget  .TY() ).withPosition( 3, 1 ).withSize( 2, 1 );

        // MECHANISM TAB
        MechTab.add( "Intake Power"    , Intake     .GetPower() ).withPosition( 1, 1 ).withSize( 2, 1 );
        MechTab.add( "Roller Power"    , Roller     .GetPower() ).withPosition( 2, 1 ).withSize( 2, 1 );
        MechTab.add( "Mover Power"     , Mover      .GetPower() ).withPosition( 3, 1 ).withSize( 2, 1 );
        MechTab.add( "Shooter Power"   , Shooter    .GetPower() ).withPosition( 4, 1 ).withSize( 2, 1 );
        MechTab.add( "Aimer State"     , Aimer      .GetState() ).withPosition( 5, 1 ).withSize( 2, 1 );

        // ROBOT POSE
        DrivTab.add( "Pose X", Drivetrain.GetPose().getX()        );
        DrivTab.add( "Pose Y", Drivetrain.GetPose().getY()        );
        DrivTab.add( "Pose Z", Drivetrain.GetPose().getRotation() );

    }

}
