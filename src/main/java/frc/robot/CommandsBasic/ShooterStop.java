package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Shooter;

public class ShooterStop extends InstantCommand {

  public ShooterStop() {}

  @Override public void initialize() {
    Shooter.Stop();
  }

}
