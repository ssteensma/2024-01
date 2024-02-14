package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Auton {

    public static final String kDefault = "Nothing";
    public static final String kPath01  = "Path-01";
    public static final String kPath02  = "Path-02";
    public static final String kPath03  = "Path-03";
    public static final String kPath04  = "Path-04";
    public static final SendableChooser<String> chooser = new SendableChooser<>();

    public static void Initialize () {
        chooser.setDefaultOption("Nothing", kDefault );
        chooser.setDefaultOption("Path 01", kPath01  );
        chooser.setDefaultOption("Path 02", kPath02  );
        chooser.setDefaultOption("Path 03", kPath03  );
        chooser.setDefaultOption("Path 04", kPath04  );
        chooser.setDefaultOption("Path 05", kPath04  );
        SmartDashboard.putData  ("PATH",    chooser  );
 
        Stage.Initialize();
    }

    public static void Periodic () {

        Stage.Begin();

        switch ( chooser.getSelected() ) {
            case "Default" : Track.Track_00(); break;
            case "Path-01" : Track.Track_01(); break;
        }

        Stage.Next();

        // only call is robot 
        if ( Stage.Number <= 100 ) { Stage.Display(); }

        SmartDashboard.putString("CURRENT PATH", chooser.getSelected() );
        // Swerve.UpdateRobotRelative( Autopilot.vx, Autopilot.vy, Autopilot.vt );
 
        // Example chassis speeds: 1 meter per second forward, 3 meters
        // per second to the left, and rotation at 1.5 radians per second
        // counterclockwise.                         F    L   CCW
        // ChassisSpeeds speeds = new ChassisSpeeds(1.0, 3.0, 1.5);

        // THESE NEED TO BE SET BY THE AUTONOMOUS MODE

        // double curPitch  = Navigation.GetPitch();
        // SmartDashboard.putNumber("Robot-Pitch", curPitch);
        // SmartDashboard.putNumber("Robot-Stage", stage );

        // double
        //     vx = 0.00,
        //     vy = 0.00,
        //     vt = 0.00;

        // if ( stage == 0 ) {
        //     vx = 0.08;
        //     if ( curPitch > 0 ) { stage++; };
        // }

        // if ( stage == 1 ) {
        //     vx = 0;
        // }

        // Navigation.Periodic();
        // double curAng = Navigation.GetDirection();
        // double target = 0;

        // double diff = curAng - target;

        // SmartDashboard.putNumber("Robot-DIFF", diff);

        // // SMALLEST ANGLE TO SWIVEL: -180 to 180
        // double minTurn = ( diff + 180 ) % 360 - 180;
        //     double turnMag = Math.abs   ( minTurn );
        //     double turnDir = Math.signum( minTurn );

        // // MINIMIZE WHEEL SWIVEL: +120 becomes -60
        // if ( turnMag > 0 ) {
        //     // turnMag  = 180 - minTurn; // Turn smaller angle
        //     turnDir *= -1;            // and reverse swivel
        // }

        // // DETERMINE POWER USING PSEUDO PID CONTROLLER
        // if      ( turnMag > 20 ) { vt = 0.15; }
        // else if ( turnMag > 10 ) { vt = 0.10; } 
        // else if ( turnMag >  3 ) { vt = 0.06; } 
        // else if ( turnMag >  2 ) { vt = 0.00; } 
        // else if ( turnMag >  1 ) { vt = 0.00; } 
        // else                     { vt = 0.00; }

        // vt *= turnDir;

        // SET MOTOR CONTROLLERS
        // SteerMotor.set( TalonFXControlMode.PercentOutput, PID.calculate( SP, PV ) );

        // double diff = ( cur  ) % 360 - 180;
     
    }

}
