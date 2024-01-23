package frc.robot.System;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Ports.pSwerve;

public class Drivetrain {
   
       // CHASSIS SPEEDS
    public static ChassisSpeeds
        RobotSpeed;

    // SWERVE MODULES
    public static SwerveModule
        FL_module,
        FR_module,
        RL_module,
        RR_module;

    // TRANSLATION OBJECTS
    public static Translation2d
        FL_Trans2d,
        FR_Trans2d,
        RL_Trans2d,
        RR_Trans2d;

    // KINEMATICS OBJECT
    public static SwerveDriveKinematics
        Kinematics;

    // ODOMETRY OBJECT
    public static SwerveDriveOdometry
        Odometry;

    public static void Initialize() {

        // CHASSIS SPEEDS
        RobotSpeed = new ChassisSpeeds( 0, 0, 0 );

        // MODULE DEFINITIONS
        FL_module = new SwerveModule( "FL", pSwerve.pCAN_FL );
        FR_module = new SwerveModule( "FR", pSwerve.pCAN_FR );
        RL_module = new SwerveModule( "RL", pSwerve.pCAN_RL );
        RR_module = new SwerveModule( "RR", pSwerve.pCAN_RR );

        // TRANSLATION OBJECT
        FL_Trans2d = new Translation2d( pSwerve.Trans2d_FL[0], pSwerve.Trans2d_FL[1] );
        FR_Trans2d = new Translation2d( pSwerve.Trans2d_FR[0], pSwerve.Trans2d_FR[1] );
        RL_Trans2d = new Translation2d( pSwerve.Trans2d_RL[0], pSwerve.Trans2d_RL[1] );
        RR_Trans2d = new Translation2d( pSwerve.Trans2d_RR[0], pSwerve.Trans2d_RR[1] );

        // KINEMATICS OBJECT
        Kinematics = new SwerveDriveKinematics( FL_Trans2d, FR_Trans2d, RL_Trans2d, RR_Trans2d );
    }

    public static void Display () {
        SmartDashboard.putNumber("Robot-vx", RobotSpeed.vxMetersPerSecond     );
        SmartDashboard.putNumber("Robot-vy", RobotSpeed.vyMetersPerSecond     );
        SmartDashboard.putNumber("Robot-vt", RobotSpeed.omegaRadiansPerSecond );

        // FL_module.Display();
        // FR_module.Display();
        // RL_module.Display();
        // RR_module.Display();
    }

    public static void UpdateFieldRelative ( double vx, double vy, double vt ) {
        Rotation2d    Rot2d  = Rotation2d.fromDegrees( Navigation.NavX.getYaw() );
        ChassisSpeeds Speeds = ChassisSpeeds.fromFieldRelativeSpeeds( vx, vy, vt, Rot2d );
        Update( Speeds );
    }

    public static void UpdateRobotRelative ( double vx, double vy, double vt ) {
        ChassisSpeeds Speeds = new ChassisSpeeds( vx, vy, vt );
        Update( Speeds );
    }

    private static void Update ( ChassisSpeeds Speeds ) {

        // CALCULATE INDIVIDUAL MODULE STATES
        SwerveModuleState[] ModuleStates = Kinematics.toSwerveModuleStates( Speeds );

        // NORMALIZE WHEEL RATIOS IF ANY SPEED IS ABOVE SPECIFIED MAXIMUM
        SwerveDriveKinematics.desaturateWheelSpeeds( ModuleStates, 0.5 );

        // UPDATE ROBOT SPEEDS
        RobotSpeed = Kinematics.toChassisSpeeds( ModuleStates );

        // UPDATE EACH MODULE
        FL_module.Update( ModuleStates[0] );
        FR_module.Update( ModuleStates[1] );
        RL_module.Update( ModuleStates[2] );
        RR_module.Update( ModuleStates[3] );
    }    
}
