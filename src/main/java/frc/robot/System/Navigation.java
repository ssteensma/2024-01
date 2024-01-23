package frc.robot.System;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

public class Navigation {
    
    public static AHRS NavX = new AHRS( SerialPort.Port.kMXP );


}
