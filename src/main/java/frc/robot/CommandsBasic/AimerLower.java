package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Aimer;

public class AimerLower extends InstantCommand {

  public AimerLower() {}

  @Override public void initialize() {
    Aimer.Retract();
  }

}
