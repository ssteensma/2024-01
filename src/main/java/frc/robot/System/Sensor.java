package frc.robot.System;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.pSensor;

public class Sensor extends SubsystemBase {
    
    public static Ultrasonic
        Sonar = new Ultrasonic( pSensor.DIO_Sonic[0], pSensor.DIO_Sonic[1] );

    public static void Initialize() {
        Sonar.setEnabled( true );
    }

    public static double GetRange () { return Sonar.getRangeInches(); }

    public static void Periodic() {
        SmartDashboard.putNumber( "SENSOR", 1 + Sensor.GetRange() );
    }

}
