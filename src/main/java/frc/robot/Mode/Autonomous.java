package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.System.Autopilot;
import frc.robot.System.Drivetrain;
import frc.robot.System.Intake;
import frc.robot.System.Stage;
import frc.robot.System.Track;

public class Autonomous {

    public static final String kDefault = "Nothing";
    public static final String kPath01  = "Path-01";
    public static final String kPath02  = "Path-02";
    public static final String kPath03  = "Path-03";
    public static final String kPath04  = "Path-04";
    public static final String kPath05  = "Path-05";
    public static final SendableChooser<String> chooser = new SendableChooser<>();

    public static void Initialize () {
        chooser.setDefaultOption("Nothing", kDefault );
        chooser.setDefaultOption("Path 01", kPath01  );
        chooser.setDefaultOption("Path 02", kPath02  );
        chooser.setDefaultOption("Path 03", kPath03  );
        chooser.setDefaultOption("Path 04", kPath04  );
        chooser.setDefaultOption("Path 05", kPath05  );
        SmartDashboard.putData  ("PATH",    chooser  );
 
        Stage.Initialize();
    }

    public static void Periodic () {
        Stage.Begin();

        switch ( chooser.getSelected() ) {
            case "Default" : Track.Track_00(); break;
            case "Path-01" : Track.Track_01(); break;
            case "Path-02" : Track.Track_02(); break;
        }

        Stage.Next();

        // only call is robot 
        if ( Stage.Number <= 100 ) { Stage.Display(); }

        SmartDashboard.putString("CURRENT PATH", chooser.getSelected() );

        // DRIVETRAIN
        Drivetrain.UpdateRobotRelative( Autopilot.vx, Autopilot.vy, Autopilot.vt );

        // COMPONENTS
        Intake.Periodic();

    }

}
