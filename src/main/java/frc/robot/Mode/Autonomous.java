package frc.robot.Mode;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.System.Autopilot;
import frc.robot.System.Drivetrain;
import frc.robot.System.Stage;
import frc.robot.System.Track;

public class Autonomous {

    public static final String kDefault = "Nothing";
    public static final String kPath01  = "Path-01";
    public static final SendableChooser<String> chooser = new SendableChooser<>();

    public static void Initialize () {
        chooser.setDefaultOption("Nothing", kDefault );
        chooser.setDefaultOption("Path 01", kPath01  );
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

        Drivetrain.UpdateRobotRelative( Autopilot.vx, Autopilot.vy, Autopilot.vt );
    }

}
