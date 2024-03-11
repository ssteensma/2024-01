package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.System.Shooter;

public class ShooterLo extends InstantCommand {

  public ShooterLo() {}

  @Override public void initialize() {
    Shooter.ShootLo();
  }

}
