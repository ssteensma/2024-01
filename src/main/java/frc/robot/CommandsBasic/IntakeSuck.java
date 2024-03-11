package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.System.Intake;

public class IntakeSuck extends Command {

  public IntakeSuck() {}

  @Override public void initialize() {
    Intake.Suck();
  }

}
