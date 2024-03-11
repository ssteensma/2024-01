package frc.robot.CommandsBasic;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.AutonRoutine.Auton;
import frc.robot.System.Autopilot;

public class AutoTransS extends InstantCommand {

  public AutoTransS() {}

  @Override public void initialize() {
    Autopilot.TranslateS( Auton.DriveSpeed );
  }

}
