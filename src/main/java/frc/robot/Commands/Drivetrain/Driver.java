package frc.robot.Commands.Drivetrain;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Bindings;
import frc.robot.Shared;
import frc.robot.System.Drivetrain;

public class Driver extends Command {

  public Driver() {
    addRequirements( Shared.m_Drivetrain );
  }

  @Override public void initialize() {
    
  }

  @Override public void execute() {
    double X = Bindings.DS.getLeftX();
    double Y = Bindings.DS.getLeftY();
    double Z = Bindings.DS.getRightX();

    Drivetrain.UpdateRobotRelative( X, Y, Z );
  }

  @Override public void end( boolean interrupted ) {

  }

  @Override public boolean isFinished() {
    return false;
  }
}
