package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DataLogManager;
import frc.robot.System.*;

public class Onabot {

    public static void Initialize() {
        DataLogManager.start();
        
        Navigation   .Initialize();
        Drivetrain   .Initialize();

        Aimer        .Initialize();
        Autonomous   .Initialize();
        Chooser      .Initialize();
        Intake       .Initialize();
        CamIntake    .Initialize();
        CamTarget    .Initialize();
        Climber      .Initialize();
        Mover        .Initialize();
        Roller       .Initialize();
        Shooter      .Initialize();

        Shuffle      .Initialize();
    }

    public static void Periodic() {
        // SmartDashboard.putNumber( "FL-PV", Drivetrain.FL_module.GetDirection() );
        // SmartDashboard.putNumber( "FR-PV", Drivetrain.FR_module.GetDirection() );
        // SmartDashboard.putNumber( "RL-PV", Drivetrain.RL_module.GetDirection() );
        // SmartDashboard.putNumber( "RR-PV", Drivetrain.RR_module.GetDirection() );

        // SmartDashboard.putNumber( "FL-SP", Drivetrain.FL_module.StrSP );
        // SmartDashboard.putNumber( "FR-SP", Drivetrain.FR_module.StrSP );
        // SmartDashboard.putNumber( "RL-SP", Drivetrain.RL_module.StrSP );
        // SmartDashboard.putNumber( "RR-SP", Drivetrain.RR_module.StrSP );

        SmartDashboard.putNumber( "NAV DIR", Navigation.GetDirection() );
    }

    public static void UpdateMechanism() {
        Aimer        .Periodic();
        Chooser      .Periodic();
        Intake       .Periodic();
        CamIntake    .Periodic();
        CamTarget    .Periodic();
        Climber      .Periodic();
        Mover        .Periodic();
        Navigation   .Periodic();
        Roller       .Periodic();
        Shooter      .Periodic();
    }

    public static void ResetMechanism() {
        Aimer         .Reset();
        Climber       .Reset();
        Intake        .Reset();
        CamIntake     .Reset();
        CamTarget     .Reset();
        Mover         .Reset();
        Navigation    .Reset();
        Roller        .Reset();
        Shooter       .Reset();
    }

}
