package frc.robot.Mode;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.System.Drivetrain;

// import frc.robot.Shared;

public class Teleop {

    public static double
        X,
        Y,
        Z;

    public static XboxController
        DS,
        MS;

    public static void Initialize() {
        // Shared.CancelAutonCommand();
        DS = new XboxController( 0 );
        MS = new XboxController( 1 );
    }

    public static void Periodic() {
        X = -DS.getLeftY();
        Y = +DS.getLeftX();
        Z = +DS.getRightX();

        // DEAD ZONE
        if ( Math.abs(X) < 0.05 ) { X = 0; }
        if ( Math.abs(Y) < 0.05 ) { Y = 0; }
        if ( Math.abs(Z) < 0.05 ) { Z = 0; }

        X *= 0.4;
        Y *= 0.4;
        Z *= 0.2;

        // DISPLAY VALUES
        SmartDashboard.putNumber( "DS-X", X );
        SmartDashboard.putNumber( "DS-Y", Y );
        SmartDashboard.putNumber( "DS-T", Z );

        // DRIVE ROBOT
        Drivetrain.UpdateRobotRelative( X, Y, Z );
    }

}
