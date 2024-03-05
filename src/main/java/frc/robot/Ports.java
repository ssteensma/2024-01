package frc.robot;

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
            
        public static int[]
            Trans2d_FL = { -1, -1 },
            Trans2d_FR = { -1,  1 },
            Trans2d_RL = {  1, -1 },
            Trans2d_RR = {  1,  1 };

    }
}