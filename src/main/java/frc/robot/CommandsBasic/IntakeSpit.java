package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Intake;

public class IntakeSpit extends InstantCommand {

  public IntakeSpit() {}

  @Override public void initialize() {
    Intake.Spit();
  }

}
