package com.mygdx.game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.files.FileHandle;

//note: even if the end of one section is the same point as the beginning of the next, this treats them as separate pivots

public class TriathlonTime
{	
	ArrayList<Double> swimPivots; // 0 - lat1, 1 - long1, 2 - lat2, 3 - long2, etc.
	ArrayList<Double> runPivots;
	ArrayList<Double> cyclePivots;
	
	double swimSpeed;
	double runSpeed;
	double cycleSpeed;
	ArrayList<Coordinate> list;
	double transition1;
	double transition2;
	
	public TriathlonTime(FileHandle swimPivots, FileHandle runPivots, FileHandle cyclePivots, double swimSpeed, double cycleSpeed, double runSpeed, double transition1, double transition2)
	{
		this.swimPivots = getPath(swimPivots);
		this.runPivots = getPath(runPivots);
		this.cyclePivots = getPath(cyclePivots);
		
		this.swimSpeed = swimSpeed;
		this.runSpeed = runSpeed;
		this.cycleSpeed = cycleSpeed;
		
		this.transition1 = transition1;
		this.transition2 = transition2;
		list= new ArrayList<Coordinate>();
	}
	
	/*public ArrayList<Double> getPath(File pivots) // reads the text file and inputs it into an ArrayList
	{
		ArrayList<Double> points = new ArrayList<Double>();
		try
		{
			Scanner sc = new Scanner(pivots);
			while(sc.hasNextLine())
			{
				points.add(Double.parseDouble(sc.nextLine()));
			}
			sc.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		return points;
	}*/
	public ArrayList<Double> getPath(FileHandle pivots) // reads the text file and inputs it into an ArrayList
	{
		ArrayList<Double> points = new ArrayList<Double>();
	
		Scanner sc = new Scanner(pivots.readString());
		while(sc.hasNextLine())
		{
			points.add(Double.parseDouble(sc.nextLine()));
		}
		sc.close();
		return points;
	}
	public void swimSim()
	{
		GPS gps = new GPS(this.swimPivots.get(0), this.swimPivots.get(1));
		int pivot = 0;
		System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);	
		for(int i = 2; i < swimPivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(swimPivots.get(i), swimPivots.get(i+1), swimSpeed);
			System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
		}
	}
	
	public void runSim()
	{
		GPS gps = new GPS(this.runPivots.get(0), this.runPivots.get(1));
		int pivot = swimPivots.size()/2;
		System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
		for(int i = 2; i < runPivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(runPivots.get(i), runPivots.get(i+1), runSpeed);
			System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
		}
	}

	public void cycleSim()
	{
		GPS gps = new GPS(this.cyclePivots.get(0), this.cyclePivots.get(1));
		int pivot = swimPivots.size()/2 + runPivots.size()/2;
		System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
		for(int i = 2; i < cyclePivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(cyclePivots.get(i), cyclePivots.get(i+1), cycleSpeed);
			System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
		}
	}
	
	public ArrayList<Coordinate> triathlonSim()
	{
		GPS gps = new GPS(this.swimPivots.get(0), this.swimPivots.get(1));
		int pivot = 0;
		//System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);	
		list.add(new Coordinate(pivot,(int)gps.getTimeDiff()));
		for(int i = 2; i < swimPivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(swimPivots.get(i), swimPivots.get(i+1), swimSpeed);
			//System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
			list.add(new Coordinate(pivot,(int)gps.getTimeDiff()));
		}
		
		pivot++;
		gps.addTotalTime(transition1);
		gps.setCoords(runPivots.get(0), runPivots.get(1));
		//System.out.println("Time: " + transition1  + ", Pivot: " + pivot);
		list.add(new Coordinate(pivot,(int)transition1));
		for(int i = 2; i < runPivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(runPivots.get(i), runPivots.get(i+1), runSpeed);
			//System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
			list.add(new Coordinate(pivot,(int)gps.getTimeDiff()));
		}

		pivot++;
		gps.addTotalTime(transition2);
		gps.setCoords(cyclePivots.get(0), cyclePivots.get(1));
		//System.out.println("Time: " + transition2  + ", Pivot: " + pivot);
		list.add(new Coordinate(pivot,(int)transition2));
		for(int i = 2; i < cyclePivots.size(); i += 2)
		{
			pivot++;
			gps.calcNext2(cyclePivots.get(i), cyclePivots.get(i+1), cycleSpeed);
			//System.out.println("Time: " + gps.getTimeDiff() + ", Pivot: " + pivot);
			list.add(new Coordinate(pivot,(int)gps.getTimeDiff()));
		}
		return list;
	}
	public double getSwimSpeed()
	{
		return swimSpeed;
	}
	public double getRunSpeed()
	{
		return runSpeed;
	}
	public double getCycleSpeed()
	{
		return cycleSpeed;
	}
}
