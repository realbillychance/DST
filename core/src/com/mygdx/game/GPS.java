package com.mygdx.game;
public class GPS
{ 
	double prevLat;
	
	double currLat;
	double currLong;
	
	double time = 0;
	double timeDiff;
	
	public GPS(double initLat, double initLong)
	{
		currLat = initLat;
		currLong = initLong;
	}
	
	public void calcNext(double distance, double velocity, double angle) // calculates the next latitude, longitude, time difference, time
	{
		double d = distance/6371000;
		prevLat = currLat;
		currLat = Math.toDegrees(Math.asin(Math.sin(Math.toRadians(currLat))*Math.cos(d)+Math.cos(Math.toRadians(currLat))*Math.sin(d)*Math.cos(Math.toRadians(angle))));
		currLong = Math.toDegrees(Math.toRadians(currLong) + Math.atan2(Math.sin(Math.toRadians(angle)) * Math.sin(d) * Math.cos(Math.toRadians(prevLat)), Math.cos(d) - Math.sin(Math.toRadians(prevLat)) * Math.sin(Math.toRadians(currLat))));
		timeDiff = distance/velocity;
		time += timeDiff;
	}
	
	public void calcNext2(double newLat, double newLong, double velocity) // calculates the next time difference, time
	{
		timeDiff = calcDistances(currLat, currLong, newLat, newLong)/velocity;
		time += timeDiff;
		prevLat = currLat;
		currLat = newLat;
		currLong = newLong;
	}
	
	public double calcDistances(double lat1, double lon1, double lat2, double lon2) // calculates the distance between two points
	{
		double xat1 = Math.toRadians(lat1);
		double xat2 = Math.toRadians(lat2);
		double dlat = Math.toRadians(Math.abs(lat1-lat2));
		double dlon = Math.toRadians(Math.abs(lon1-lon2));
		double a = Math.pow((Math.sin(dlat/2)), 2) + Math.cos(xat1) * Math.cos(xat2) * Math.pow((Math.sin(dlon/2)),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		return 6371000 * c;
	}
	
	public double getTimeDiff()
	{
		return timeDiff;
	}
	
	public void addTotalTime(double time) // adds a set amount of time to the total time
	{
		this.time += time;
	}
	public double getTotalTime()
	{
		return time;
	}
	public void setCoords(double currLat, double currLong) // sets the current latitude and longitude
	{
		this.currLat = currLat;
		this.currLong = currLong;
	}
}
