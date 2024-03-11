package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.AutonRoutine.Auton;
import frc.robot.System.Autopilot;

public class AutoTransN extends InstantCommand {

  public AutoTransN() {}

  @Override public void initialize() {
    Autopilot.TranslateN( Auton.DriveSpeed );
  }

}
