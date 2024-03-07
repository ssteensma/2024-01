package frc.robot.System;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Ports.pClimber;

public class Climber {
    
    // TALONFX
    public static TalonFX
        Mtr = new TalonFX( pClimber.CAN_Clmb );

    public static double
        Power = 0.00;
    
    public static void Initialize() {
        ResetHeight();
        Mtr.setInverted( false );
    }

    public static void Periodic() {
        Mtr.set( Power );
        SmartDashboard.putNumber( "CLIMBER POSITION", GetDistance() );
    }

    public static double GetDistance() { return Mtr.getPosition().getValueAsDouble(); }

    public static void ResetHeight()  { Mtr.setPosition( 0.00 ); }

    public static void LowerClimber() { Power =  0.50; }
    public static void RaiseClimber() { Power = -0.50; }

    public static void AutoAscend()  { // LOWER MECHANISM, ROBOT CLIMBS
        Power =  GetDistance() <= 0 ? 1.00 : 0.00;
    }

    public static void AutoDescend() { // RAISE MECHANISM, ROBOT LOWERS
        Power =  GetDistance() >= -420 ? -1.00 : 0.00;
    }

    public static void Reset()   { Power =  0.00; }
    public static void Stop ()   { Power =  0.00; }
}
