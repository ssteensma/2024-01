package frc.robot.Mode;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Ports.pStick;
import frc.robot.System.*;

public class Teleop {

    public static double
        X,
        Y,
        Z;

    public static PS4Controller
        DS;

    public static XboxController
        MS;

    public static void Initialize() {
        Drivetrain.Reset();
        DS = new PS4Controller ( pStick.USB_Drive );
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

        X *= 0.9;
        Y *= 0.9;
        Z *= 0.2;

        // MANIP STICK BUTTONS
        if      ( MS.getYButton    () ) { Mechanism.ShootHi (); }
        else if ( MS.getAButton    () ) { Mechanism.ShootLo (); }
        else if ( MS.getXButton    () ) { Mechanism.Collect (); }
        else if ( MS.getStartButton() ) { Mechanism.Ascend  (); }
        else if ( MS.getBackButton () ) { Mechanism.Descend (); }
        else                            { Mechanism.Stop    (); }

        // GET RING AUTOMATICALLY
        if ( DS.getR2Button() ) {
            X = ( CamIntake.TY() - -20 ) * 0.02;
            Y = 0;
            Z = CamIntake.TX() * -0.008;

            if ( X > 0.10 ) { X = 0.10; }
            Mechanism.Collect();
            
            if ( CamIntake.TY() < -18 ) {
                X = 0.08;
                Z = 0.00;
            }
        }

        // ALIGN TO SPEAER AUTOMATICALLY
        // if ( DS.getBButton() ) {
        //     X = ( CamIntake.TY() - 15 ) * 0.007;
        //     Y = ( CamIntake.TX() ) * 0.005;
        //     Z = 0;
        // }

        Drivetrain  .UpdateRobotRelative( X, Y, Z );
        Onabot      .UpdateMechanism();
    }

}
