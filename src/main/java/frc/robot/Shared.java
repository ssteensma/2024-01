package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.System.*;

public class Shared {

    public static RobotContainer m_robotContainer = new RobotContainer();
    public static Command        m_autonomousCommand;

    public static Subsystem      m_Subsystem  = new Subsystem  ();

    public static Drivetrain     m_Drivetrain = new Drivetrain ();
    public static Intake         m_Intake     = new Intake     ();
    public static Navigation     m_Navigation = new Navigation ();

    public static void CancelAutonCommand() {
        if ( m_autonomousCommand != null) { m_autonomousCommand.cancel(); }      
    }

    public static void SetAutonCommand() {
        m_autonomousCommand = m_robotContainer.getAutonomousCommand();      
    }

}
