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
        if      ( X < -0.06 ) { X += 0.06; }
        else if ( X > +0.06 ) { X -= 0.06; }
        else                  { X  = 0.00; }

        if      ( Y < -0.06 ) { Y += 0.06; }
        else if ( Y > +0.06 ) { Y -= 0.06; }
        else                  { Y  = 0.00; }

        if      ( Z < -0.06 ) { Z += 0.06; }
        else if ( Z > +0.06 ) { Z -= 0.06; }
        else                  { Z  = 0.00; }

        // REDUCE SENSITIVITY
        // X = 0.90 * Math.signum( X ) * Math.pow( X, 2 );
        // Y = 0.90 * Math.signum( Y ) * Math.pow( Y, 2 );
        // Z = 0.90 * Math.signum( Z ) * Math.pow( Z, 2 );

        X = 0.90 * X;
        Y = 0.90 * Y;
        Z = 0.70 * Z;

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
            X = ( CamIntake.TY() - -2 ) * -0.04;
            Y = 0;
            Z = CamIntake.TX() * -0.02;

            if ( X >  0.20 ) { X =  0.20; }
            if ( X < -0.20 ) { X = -0.20; }

            Mechanism.Collect();
            
            if ( CamIntake.TY() < -2 ) { X = -0.20; Z = 0.00; }
        }

        // ALIGN TO SPEAKER AUTOMATICALLY
        // if ( DS.getCrossButton() ) { Autopilot.TransToAprilTag(); }

        // SAVE VALUES FOR DRIVETRAIN
        Drivetrain.vx = X;
        Drivetrain.vy = Y;
        Drivetrain.vt = Z;

        if ( DS.getCrossButton() ) {
            Navigation.Reset();
            // double Error = ( Navigation.NavX.getAngle() + 540 - 180 ) % 360 - 180;
            // SmartDashboard.putNumber( "NAV ERROR", Error );

            // double Power = Error * 0.007;
            // if ( Power < -0.08 ) { Power = -0.10; }
            // if ( Power >  0.08 ) { Power =  0.10; }
            // SmartDashboard.putNumber( "NAV POWER", Power );
 
            // Drivetrain.vx = 0.15;
            // Drivetrain.vy = 0.00;
            // Drivetrain.vt = Power;
        }
        
        Drivetrain  .UpdateRobotRelative();
        Onabot      .UpdateMechanism();
    }

}
