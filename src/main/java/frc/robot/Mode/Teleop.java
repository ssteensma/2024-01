package frc.robot.Mode;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.System.Drivetrain;

// import frc.robot.Shared;

public class Teleop {

    public static XboxController DS;

    public static void Initialize() {
        // Shared.CancelAutonCommand();

        DS = new XboxController( 0 );

    }

    public static void Periodic() {

        double X = -DS.getLeftY();
        double Y = +DS.getLeftX();
        double Z = +DS.getRightX();

        if ( Math.abs(X) < 0.05 ) { X = 0; }
        if ( Math.abs(Y) < 0.05 ) { Y = 0; }
        if ( Math.abs(Z) < 0.05 ) { Z = 0; }

        Drivetrain.UpdateFieldRelative( X, Y, Z );

        SmartDashboard.putNumber( "Forward", X );
        SmartDashboard.putNumber( "Horizontal", Y );
        SmartDashboard.putNumber( "Twist", Z );


    }

}
