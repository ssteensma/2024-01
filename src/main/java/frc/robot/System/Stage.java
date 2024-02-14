package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Stage {

	public static double   AutonStartTime;
	public static double   AutonFinalTime;
	public static double   StageStartTime;
	
	public static int      Number;
	public static boolean  ReadyToAdvance;	
	public static double[] StageDistance = new double[10];
	public static double[] StageTime     = new double[10];

	public static double   NegTilt = 0;
	public static double   PosTilt = 0;
	

	public static void Initialize () {
		AutonStartTime = System.currentTimeMillis();
		StageStartTime = AutonStartTime;
		Number         = 0;
	}

	public static void Display () {
		SmartDashboard.putNumber("Robot-Stage Number",   Number             );
		SmartDashboard.putNumber("Robot-Stage Distance", GetDistance()      );
		SmartDashboard.putNumber("Robot-Stage Time",     GetStageTime()     );
		SmartDashboard.putNumber("Robot-Auton Time",     GetAutonDuration() );
	}

//
// The Next method advances to the next stage after storing Stage
// information. The Last method stops 
//
	public static void Begin () {
		Autopilot.Stop();
		ReadyToAdvance = true;
	}

	public static void Next () {
		if ( ReadyToAdvance == true ) {
			StageDistance[Number] = GetDistance();
			StageTime    [Number] = GetStageTime();
			ResetOdometer();
			StageStartTime = System.currentTimeMillis();
			Number++;
		}
	}

	public static void Last () {
		AutonFinalTime = System.currentTimeMillis();
		ReadyToAdvance = false;
	}

	public static void Fail () {
		AutonFinalTime = System.currentTimeMillis();
		ReadyToAdvance = false;
		Number         = 100;
	}

//
// Get...Time methods are is useful in auton mode to determine the amount
// of time that the current stage or the entire auton process has been
// executing.
//
	public static double GetAutonDuration () {
		return ( System.currentTimeMillis() - AutonStartTime ) / 1000.0;
	}

	public static double GetStageTime () {
		return ( System.currentTimeMillis() - StageStartTime ) / 1000.0;
	}

	public static void WaitForDuration ( double Duration ) {
		if ( GetStageTime() < Duration ) {
			ReadyToAdvance = false;
		}
	}

//
//
//
	public static double GetDistance () {
		double FL = Drivetrain.FL_module.DriveMotor.getPosition().getValueAsDouble();
		double FR = Drivetrain.FL_module.DriveMotor.getPosition().getValueAsDouble();
		double RL = Drivetrain.FL_module.DriveMotor.getPosition().getValueAsDouble();
		double RR = Drivetrain.FL_module.DriveMotor.getPosition().getValueAsDouble();

		// ABS SINCE SOME WHEELS GOING BACKWARD
		FL = Math.abs( FL );
		FR = Math.abs( FR );
		RL = Math.abs( RL );
		RR = Math.abs( RR );
		
		// TAKE AN AVERAGE FOR SIMPLICITY
		return ( FL + FR + RL + RR ) * 2048 / 4;
	}

	public static void ResetOdometer () {
		Drivetrain.FL_module.DriveMotor.setPosition( 0 );
		Drivetrain.FR_module.DriveMotor.setPosition( 0 );
		Drivetrain.RL_module.DriveMotor.setPosition( 0 );
		Drivetrain.RR_module.DriveMotor.setPosition( 0 );
	}

	public static void WaitForDistance ( double Distance ) {
		if ( GetDistance() < Distance ) {
			ReadyToAdvance = false;
		}
	}

//
//
//
	public static void WaitForHeading ( double Heading, double Tolerance ) {
		double diff = Autopilot.HeadingDiff( Heading );
		if ( Math.abs( diff ) < Tolerance ) {
			ReadyToAdvance = false;
		}
	}

//
// Second draft of code to be used in auton. Drive forward until we notice an incline.
// At that point we advance stages and continue to drive forward until we notice a
// balanced condition. It would be good to also have a maximum distance travelled for
// each stage and fail if the condition is not met.
//
	public static void WaitForBalance ( double Tolerance ) {
		double pitch = Navigation.GetPitch();
		if ( Math.abs( pitch ) > Tolerance ) {
			ReadyToAdvance = false;
		}
	}

	public static void WaitForIncline ( double Angle ) {
		double pitch = Navigation.GetPitch();
		if ( Math.abs( pitch ) < Angle ) {
			ReadyToAdvance = false;
		}
	}

//
//
//
	// public static void WaitForWheelAlignment ( double Angle ) {

	// }
	// public static void WaitForHeading ( double Heading, double Tolerance ) {

	// }

//	public static boolean WaitForHeading( double targetHeading, double tolerance ) {
//		if ( Math.abs(Navigation.GetDelta(targetHeading)) < tolerance ) { return true; }
//	}
//	
//
//	public static boolean WaitForTarget( double tolerance ) {
//		if ( Drivetrain.TargetMin<-tolerance || Drivetrain.TargetMax>tolerance ) {
//			StillWorking = true;
//			return true;
//		}
//		else {
//			return false;
//		}
//	
//	}
	
	
}
