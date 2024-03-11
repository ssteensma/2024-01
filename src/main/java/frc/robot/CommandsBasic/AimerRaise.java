package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Aimer;

public class AimerRaise extends InstantCommand {

  public AimerRaise() {}

  @Override public void initialize() {
    Aimer.Extend();
  }

}
