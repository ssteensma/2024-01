package frc.robot;

import edu.wpi.first.math.util.Units;

public class Ports {

    public class pAimer { //
        public static int[]
            PCM_Lft = { 0, 1 },
            PCM_Rgt = { 2, 3 };
    }

    public class pClimber { //
        public static int
            CAN_Clmb = 19;
    }

    public class pStick {
        public static int
            USB_Drive = 0,
            USM_Manip = 1;
    }

    public class pIntake {
        public static int 
            CAN_Lft = 1, // Lft and Rgt are flipped in relation to
            CAN_Rgt = 2; // the Swerve Drive names
    }

    public class pMover {
        public static int
            CAN_Mvr = 3;
    }

    public class pRoller {
        public static int
            CAN_Roller = 3;
    }

    public class pShooter {
        public static int
            CAN_Lo = 10,
            CAN_Hi =  9;
    }

    public class pSwerve {
        // Drive Motor, Steer Motor, Steer Encoder
        public static int[]
            CAN_RR = { 16, 15, 7 },
            CAN_RL = { 18, 17, 8 },
            CAN_FR = { 14, 13, 6 },
            CAN_FL = { 12, 11, 5 };
    
        public static double
            kWheelBase  = Units.inchesToMeters( 29 ), // Front-to-back distance from wheel to wheel
            kTrackWidth = Units.inchesToMeters( 29 ); // Side-to-side width from wheel to wheel
        
        public static double[]
            Trans2d_FL = {  kWheelBase/2,  kTrackWidth/2 },
            Trans2d_FR = {  kWheelBase/2, -kTrackWidth/2 },
            Trans2d_RL = { -kWheelBase/2,  kTrackWidth/2 },
            Trans2d_RR = { -kWheelBase/2, -kTrackWidth/2 };

            // Trans2d_FL = { -1, -1 },
            // Trans2d_FR = { -1,  1 },
            // Trans2d_RL = {  1, -1 },
            // Trans2d_RR = {  1,  1 };
    }
}