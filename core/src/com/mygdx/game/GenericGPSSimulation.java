package com.mygdx.game;

public class GenericGPSSimulation
{ 
	double iLat; // the initial latitude
	double currLat; // the current latitude
	double prevLat; // the previous latitude
	
	double iLong; // the initial longitude
	double currLong; // the current longitude
	double prevLong; // the previous longitude
	
	double currDisp; // the current total displacement
	double prevDisp; // the previous total displacement
	
	double dist; // the change in radians (distance/radius)
	
	public GenericGPSSimulation(double initLong, double initLat, double velocity, int timeInterval)
	{
		iLat = initLat;
		currLat = initLat;
		iLong = initLong;
		currLong = initLong;
		dist = velocity*timeInterval/6371000;
	}
	
	public double calcLat(double angle) // calculates the current latitude
	{
		prevLat = currLat;
		currLat = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(currLat))*Math.cos(dist)+Math.cos(Math.toRadians(currLat))*Math.sin(dist)*Math.cos(Math.toRadians(angle))));
		return prevLat;
	}
	
	public double calcLong(double angle) // calculates the current longitude *NOTE: must calculate latitude first
	{
		prevLong = currLong;
		currLong = Math.toDegrees(Math.toRadians(currLong) + Math.atan2(Math.sin(Math.toRadians(angle)) * Math.sin(dist) * Math.cos(Math.toRadians(prevLat)), Math.cos(dist) - Math.sin(Math.toRadians(prevLat)) * Math.sin(Math.toRadians(currLat))));
		return prevLong;
	}
	
	public double calcTotalDis() // calculates the total current displacement - must calculate latitude and longitude first
	{
		prevDisp = currDisp;
		double dLong = currLong - iLong;
		double dLat = currLat - iLat;
		double a = Math.pow(Math.sin(Math.toRadians(dLat/2)),2) + Math.cos(Math.toRadians(iLat))*Math.cos(Math.toRadians(currLat))*Math.pow(Math.sin(Math.toRadians(dLong/2)), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		currDisp = 6371000*c;
		return prevDisp;
	}
}
