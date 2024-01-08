package org.firstinspires.ftc.teamcode.utils;

import static java.lang.Math.PI;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.hardware.PIDFC;

import java.util.Map;

@Config
public class RobotVars {
    public static boolean USE_TELE = true;
    public static boolean USE_LOCALIZER = true;
    public static boolean USE_DIFFY = false;
    public static boolean USE_DIRECTION_PID = true;
    public static boolean MOVE_SWERVE = true;

    public static double pcoef = 1.0; // Power coefficient

    public static int RBOT_POS = 5;
    public static int RMIU_POS = 5;
    public static int RMID_POS = 5;
    public static int RTOP_POS = 5;

    public static String LES = "RF";
    public static String RES = "RB";
    public static String FES = "LB";
    public static boolean LER = true;
    public static boolean RER = true;
    public static boolean FER = true;

    public static double OFFLF = -0.4752787675627523;
    public static double OFFLB = -2.7166934353886925;
    public static double OFFRF = -0.08555017816129543;
    public static double OFFRB = -0.4809821127735054;

    public static PIDFC WheelPidLFF = new PIDFC(0.4, 0.0, 0.0, 0.03);
    public static PIDFC WheelPidLFB = new PIDFC(0.38, 0.1, 0.0, 0.015);

    public static PIDFC WheelPidLBF = new PIDFC(0.4, 0.0, 0.0, 0.04);
    public static PIDFC WheelPidLBB = new PIDFC(0.38, 0.1, 0.0, 0.03);

    public static PIDFC WheelPidRFF = new PIDFC(0.4, 0.0, 0.0, 0.03);
    //public static PIDFC WheelPidRFF = new PIDFC(0.38, 0.0, 0.0, 0.050);
    public static PIDFC WheelPidRFB = new PIDFC(0.38, 0.8, 0.0, 0.040);

    public static PIDFC WheelPidRBF = new PIDFC(0.4, 0.0, 0.0, 0.04);
    public static PIDFC WheelPidRBB = new PIDFC(0.41, 0.09, 0.0, 0.03);

    public static double WheelAlignMin = 0.30;
    public static double WheelAlignMax = 1.00;
    public static double WheelAlignStart = PI / 2 - PI / 4;
    public static double WheelAlignEnd = PI / 2 - PI / 8;

    public static double WheelMaxErr = 0.00;

    public static double WheelULF = -0.0;
    public static double WheelDLF = -0.0;
    public static double WheelULB = -0.0;
    public static double WheelDLB = -0.0;
    public static double WheelURF = -0.0;
    public static double WheelDRF = -0.0;
    public static double WheelURB = -0.0;
    public static double WheelDRB = -0.0;

    public static double SwerveHeadPidP = 1.0;
    public static double SwerveHeadPidI = 0.0;
    public static double SwerveHeadPidD = 0.0;
    public static double SwerveHeadPidF = 0.0;

    public static double GhearaSDESCHIS = 0.75;
    public static double GearaSINCHIS = 0.65;

    public static double IntakePower = -0.7;

    public static double IntakePDown = 0.44;
    public static double IntakePUp = 0.48;

    public static double DIFLOFF = -5.220461982909272;
    public static double DIFROFF = -5.469508057112154;

    public static boolean CHANGE_DIFFY_POS = false;
    public static PIDFC DiffyPid = new PIDFC(-0.2, 0.0, 0.0, -0.025);

    public static double DIFGRAT = 1.0;
    public static double DIFUP = 4.5;
    public static double DIFDOWN = -0.05;
    public static double DIFFUP = 0.0;
    public static double DIFFDOWN = 3.14;

    public static double FUNKYLU = 0.01;
    public static double FUNKYLD = 0.84;
    public static double FUNKYRU = 0.55;
    public static double FUNKYRD = 0.0;
    public static double KMSCONF = 5;

    public static boolean canInvertMotor = true;
    public static boolean _MOVE_SWERVE = true;
    public static double HEADP = 1.0;

    public static double SwerveAngP = -0.38;

    public static boolean LOG_STATUS = false;

    public static double SERVO_GEAR_RATIO = 1.021;

    public static double TRACK_WIDTH = 21.0;
    public static double WHEEL_BASE = 21.0;

    public static String WheelsPerpName = "RBM";
    public static Pose WheelsPerpPos = new Pose(-13, -0.75, PI / 2);
    public static Integer WheelsPerpDir = 1;
    public static String WheelsParRName = "LBM";
    public static Pose WheelsParRPos = new Pose(-8.5, 4.75, 0.0);
    public static Integer WheelsParRDir = -1;
    public static String WheelsParLName = "RidR";
    public static Pose WheelsParLPos = new Pose(-8.5, -4.75, 0.0);
    public static Integer WheelsParLDir = 1;
    public static Double WheelsTicksToCm = 1.8 * 2 * PI / 8192.0; // Radius * 2pi / Ticks/Rev

    public static Map<String, Integer> nrRots;


    /*
     * Expansion:
     *     Motors:
     *         0: RidL
     *         1: Intake
     *         2: RidR
     *         3:
     *     Servos:
     *         0: FunkyL
     *         1: DifRS (5 sus in jos)
     *         2: DifLS (3 sus in jos)
     *         3: Clown (1 sus in jos)
     *         4: FunkyR
     *         5: RidIntake (6 sus in jos)
     *      Analog:
     *         0-1: DifLE DifRE
     * Control:
     *     Motors:
     *         0: LBM
     *         1: LFM
     *         2: RBM
     *         3: RFM
     *     Servos:
     *         0: RBS
     *         1:
     *         2: LFS
     *         3: LBS
     *         4: RFS
     *         5: Pewpew
     *      Analog:
     *         0-1: LFE LBE
     *         2-3: RBE RFE
     */
}
