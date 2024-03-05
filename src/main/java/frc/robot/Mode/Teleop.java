package frc.robot.Mode;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Mech.Mech;
import frc.robot.Ports.pStick;
import frc.robot.System.*;

public class Teleop {

    public static double
        X,
        Y,
        Z;

    public static XboxController
        DS,
        MS;

    public static void Initialize() {
        Drivetrain.Reset();
        DS = new XboxController( pStick.USB_Drive );
        MS = new XboxController( pStick.USM_Manip );
    }

    public static void Periodic() {
        X =  DS.getLeftY();
        Y =  DS.getLeftX();
        Z = -DS.getRightX();

        // DEAD ZONE
        if ( Math.abs(X) < 0.05 ) { X = 0; }
        if ( Math.abs(Y) < 0.05 ) { Y = 0; }
        if ( Math.abs(Z) < 0.05 ) { Z = 0; }

        if ( DS.getAButton() ) {
            Mech.Collect();
        } else if ( DS.getXButton() ) {
            Mech.ShootLo();
        } else if ( DS.getYButton() ) {
            Mech.ShootHi();
        } else {
            Mech.Stop();
        }

        // RESET NAVIGATION
        if ( DS.getBackButton() ) {
            Navigation.Reset();
        }

        X *= 0.4;
        Y *= 0.4;
        Z *= 0.2;

        // DISPLAY VALUES
        // SmartDashboard.putNumber( "DS-X", X );
        // SmartDashboard.putNumber( "DS-Y", Y );
        // SmartDashboard.putNumber( "DS-T", Z );

        // double Xmax = 0.35;
        // double Zmax = 0.04;
        // if ( DS.getBButton() ) {
        //     X = 0;

        //     double TY = -12 - CamTarget.TY();
        //     X = -0.02 * TY;
        //     if ( X >  Xmax ) { X =  Xmax; }
        //     if ( X < -Xmax ) { X = -Xmax; }

        //     Z = 0;
        //     double TX = CamTarget.TX();
        //     // SmartDashboard.putNumber("TX", TX );
        //     Z = TX * 0.008;
        //     if ( Z >  Zmax ) { Z =  Zmax; }
        //     if ( Z < -Zmax ) { Z = -Zmax; }
        // }

        // if ( DS.getYButton() ) {
        //     Navigation.Calibrate();
        // }

        // DRIVE ROBOT
        // Drivetrain.vx = X;
        // Drivetrain.vy = Y;
        // Drivetrain.vt = Z;

        // if ( DS.getAButton() ) { 
        //     X = -0.35;
        //     Y =  0.00;
        //     Z =  0.00;
        // }

        Drivetrain  .UpdateRobotRelative( X, Y, Z );
        Onabot      .UpdateMechanism();
    }

}
