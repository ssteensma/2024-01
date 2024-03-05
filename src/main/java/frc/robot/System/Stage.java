package frc.robot.System;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Mech.Mech;

public class Stage {

	public static double
		CurrentDist,
		CurrentTime;
	
	public static int
		MaxStages = 15,
		Number;

	public static boolean
		ReadyToAdvance;	

	public static double[]
		StageDist,
		StageTime,
		SystemDist = {},
		SystemTime = {};

	public static void Reset () {
		Number    = 0;
		ReadyToAdvance = true;
		SystemTime = new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		SystemDist = new double[]{ 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	}

	public static double GetDist() { return Math.abs( Drivetrain.FL_module.DriveMotor.getPosition().getValueAsDouble() * 2048 / 1320 ); }
	public static double GetStageDist( int n ) { return Math.abs( SystemDist[ n ] - SystemDist[ n-1 ] ); }

	public static double GetStageNumber() { return Number; }

	public static double GetSystemTime() { return System.currentTimeMillis() / 1000; }
	public static double GetAutonTime( int n ) { return SystemTime[ n ] - SystemTime[  0  ]; }
	public static double GetStageTime( int n ) { return SystemTime[ n ] - SystemTime[ n-1 ]; }

	public static void Begin () {
		Autopilot.Stop();
		Mech.Stop();
		ReadyToAdvance	= true;

		SystemTime[ Number ] = System.currentTimeMillis() / 1000;
		SystemDist[ Number ] = GetDist();
	}

	public static void Next () {
		if ( ReadyToAdvance == true ) { Number++; }
	}

	public static void Last()        { ReadyToAdvance = false; Autopilot.Stop(); }
	public static void Fail()        { ReadyToAdvance = false; Autopilot.Stop(); }
	public static void WaitForever() { ReadyToAdvance = false;                   }

	public static void WaitForAprilTagX( double X, double Error ) {
		if ( Math.abs( X - CamTarget.TX() ) > Error ) { ReadyToAdvance = false; }
	}

	public static void WaitForAprilTagY( double Y, double Error ) {
		if ( Math.abs( Y - CamTarget.TY() ) > Error ) { ReadyToAdvance = false; }
	}

	public static void WaitForMinDistance( double Distance ) {
		if ( GetStageDist( Number ) < Distance ) { ReadyToAdvance = false; }
	}

	public static void WaitForMinDuration( double Duration ) {
		if ( GetStageTime( Number ) < Duration ) { ReadyToAdvance = false; }
	}

	public static void WaitForHeading( double Heading, double Error ) {
		double Current = ( Navigation.GetDirection() + 360 ) % 360;
		if ( Math.abs( Current - Heading ) > Error ) { ReadyToAdvance = false; }
	}

}
