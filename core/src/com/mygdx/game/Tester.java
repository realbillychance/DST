package com.mygdx.game;
import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class Tester
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<Double> test1 = new ArrayList<Double>(); //ArrayList of latitudes
		test1.add(51.477222); //test data
		test1.add(59.677222);
		test1.add(45.977222);
		ArrayList<Double> test2 = new ArrayList<Double>(); //ArrayList of longitudes
		test2.add(0.0); //test data
		test2.add(10.2);
		test2.add(12.6);
		MapBuilder mapBuilder = new MapBuilder(test1, test2);
		mapBuilder.displayMap();
	}
}
