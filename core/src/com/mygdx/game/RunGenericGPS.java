package com.mygdx.game;
import java.util.*;

public class RunGenericGPS
{
	public RunGenericGPS(String[] args)
	{		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input initial longitude");
		double longitude = sc.nextDouble();
		System.out.println("Please input initial latitude");
		double latitude = sc.nextDouble();
		System.out.println("Please input average velocity in meters/second");
		double velocity = sc.nextDouble();
		System.out.println("Please input angle center in degrees");
		double angle = sc.nextDouble();
		System.out.println("Please input standard deviation");
		double stndDev = sc.nextDouble();
		System.out.println("Please input desired time interval in seconds");
		int timeInterval = sc.nextInt();
		
		GenericGPSSimulation gps = new GenericGPSSimulation(longitude, latitude, velocity, timeInterval);
		
		System.out.println("Please input maxiumum distance in meters");
		double maxDistance = sc.nextDouble();
		System.out.println("Please input maxiumum time in seconds");
		double maxTime = sc.nextDouble();
		
		sc.close();
		
		int time = 0; // time in seconds
		while(gps.calcTotalDis() <= maxDistance && time <= maxTime)
		{
			angle = randAngle(angle, stndDev);
			System.out.println("Time: " + time);
			System.out.println("Angle: " + angle);
			System.out.println("Latitude: " + gps.calcLat(angle));
			System.out.println("Longitude: " + gps.calcLong(angle));
			System.out.println("Total Displacement: " + gps.calcTotalDis());
			
			time += timeInterval;
		}
	}
	
	public static double randAngle(double prevAngle, double stndDev)
	{
		Random r = new Random();
		return r.nextGaussian()*stndDev + prevAngle;
	}
}