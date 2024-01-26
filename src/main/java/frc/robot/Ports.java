package frc.robot;

public class Ports {

    public class pIntake {
        public static int 
            pPWM_Top = 0,
            pPWM_Bot = 1;
    }

    public class pStick {
        public static int
            pUSB_Drive = 0,
            pUSM_Manip = 1;
    }

    public class pSwerve {
        // Drive Motor, Steer Motor, Steer Encoder
        public static int[]
            pCAN_FL = { 0, 1, 0 },
            pCAN_FR = { 2, 3, 1 },
            pCAN_RL = { 9, 10, 5 },
            pCAN_RR = { 5, 6, 3 };

        public static int[]
            Trans2d_FL = {  1,  1 },
            Trans2d_FR = { -1, -1 },
            Trans2d_RL = { -1,  1 },
            Trans2d_RR = {  1, -1 };
    }

}
