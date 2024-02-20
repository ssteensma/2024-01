package frc.robot;

public class Ports {

    public class pStick {
        public static int
            USB_Drive = 0,
            USM_Manip = 1;
    }

    public class pIntake {
        public static int 
            PWM_Lft = 0,
            PWM_Rgt = 1;
    }

    public class pSwerve {
        // Drive Motor, Steer Motor, Steer Encoder
        public static int[]
            CAN_FL = { 1, 2, 1 },
            CAN_FR = { 7, 8, 4 },
            CAN_RL = { 9, 10, 5},
            CAN_RR = { 5, 6, 3 };

        public static int[]
            Trans2d_FL = {  1, -1 },
            Trans2d_FR = {  1,  1 },
            Trans2d_RL = { -1, -1 },
            Trans2d_RR = { -1,  1 };
    }

}
