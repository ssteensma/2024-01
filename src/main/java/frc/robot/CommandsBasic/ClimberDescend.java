package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Climber;

public class ClimberDescend extends InstantCommand {

  public ClimberDescend() {}

  @Override public void initialize() {
    Climber.AutoDescend();
  }

}
