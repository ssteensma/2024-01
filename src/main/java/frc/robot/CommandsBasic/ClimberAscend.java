package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Climber;

public class ClimberAscend extends InstantCommand {

  public ClimberAscend() {}

  @Override public void initialize() {
    Climber.AutoAscend();
  }

}
