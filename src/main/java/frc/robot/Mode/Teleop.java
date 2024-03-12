package frc.robot.Mode;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
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

    public static CommandXboxController
        cMS;

    public static void Initialize() {
        Drivetrain.Reset();
        DS = new PS4Controller ( pStick.USB_Drive );
        MS = new XboxController( pStick.USM_Manip );
    }

    public static double
        shooter_delay = 0;

    public static void Periodic() {
        X = -DS.getLeftY();
        Y = -DS.getLeftX();
        Z = -DS.getRightX();

        // DEAD ZONE
        if ( Math.abs(X) < 0.06 ) { X = 0; }
        if ( Math.abs(Y) < 0.06 ) { Y = 0; }
        if ( Math.abs(Z) < 0.06 ) { Z = 0; }

        X *= 0.90;
        Y *= 0.90;
        Z *= 0.90;

        // SHOOTER DELAY BUTTON
        if      ( MS.getAButtonPressed () || MS.getYButtonPressed () ) { shooter_delay = System.currentTimeMillis(); }
        else if ( MS.getAButtonReleased() || MS.getYButtonReleased() ) { shooter_delay = 0;                          }

        // MANIP STICK BUTTONS
        if      ( MS.getYButton    () ) { Mechanism.ShootHi (); }
        else if ( MS.getAButton    () ) { Mechanism.ShootLo (); }
        else if ( MS.getBButton    () ) { Mover.Reverse     (); }
        else if ( MS.getXButton    () ) { Mechanism.Collect (); }
        else if ( MS.getStartButton() ) { Mechanism.Ascend  (); }
        else if ( MS.getBackButton () ) { Mechanism.Descend (); }
        else if ( MS.getLeftBumper () && MS.getRightBumper() ) { Climber.LowerClimber(); }
        else                            { Mechanism.Reset    (); }

        // GET RING AUTOMATICALLY
        if ( DS.getR2Button() ) {
            X = ( CamIntake.TY() - -6 ) * -0.04;
            Y = 0;
            Z = CamIntake.TX() * -0.02;

            if ( X >  0.20 ) { X =  0.20; }
            if ( X < -0.20 ) { X = -0.20; }

            Mechanism.Collect();
            
            if ( CamIntake.TY() < -6 ) { X = -0.20; Z = 0.00; }
        }


        // ALIGN TO SPEAKER AUTOMATICALLY
        if ( DS.getCrossButton() ) { Autopilot.TransToAprilTag(); }

        // SAVE VALUES FOR DRIVETRAIN
        Drivetrain.vx = X;
        Drivetrain.vy = Y;
        Drivetrain.vt = Z;

        Drivetrain  .UpdateRobotRelative();
        Onabot      .UpdateMechanism();
    }

}
