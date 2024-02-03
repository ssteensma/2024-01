package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.System.*;

public class Shared {

    public static RobotContainer m_robotContainer;
    public static Command        m_autonomousCommand;

    public static Subsystem      m_Subsystem    ;

    public static Drivetrain     m_Drivetrain   ;
    public static Intake         m_Intake       ;
    public static Navigation     m_Navigation   ;

    public static void Initialize() {
        m_robotContainer = new RobotContainer();

        m_Drivetrain = new Drivetrain ();
        // m_Intake     = new Intake     ();
        // m_Navigation = new Navigation ();
    }

    public static void CancelAutonCommand() {
        if ( m_autonomousCommand != null) { m_autonomousCommand.cancel(); }      
    }

    public static void SetAutonCommand() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();      
    }

}
