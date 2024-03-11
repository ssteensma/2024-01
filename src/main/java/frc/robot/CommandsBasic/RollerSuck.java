package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Roller;

public class RollerSuck extends InstantCommand {

  public RollerSuck() {}

  @Override public void initialize() {
    Roller.Suck();
  }

}
