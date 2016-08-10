package com.mygdx.game;
import java.util.ArrayList;

public class OldUrlBuilder
{	
	final static int MAPSIZE = 640; //the size of the map
	
	final static String MAPTYPE = "terrain"; //the type of map
	
	ArrayList<Double> lats; //list of latitudes the object passes through
	ArrayList<Double> longs; //list of longitudes the object passes through
	
	final static String KEY = "AIzaSyDNnPw5xXp5VwgAjatiQz93ux5crC3GOk0";
	
	public OldUrlBuilder(ArrayList<Double> lats, ArrayList<Double> longs)
	{
		this.lats = lats;
		this.longs = longs;
	}

    
    public String buildUrl() //creates the URL for the map
    {
    	String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?"; //base URL
    	imageUrl += "size=" + MAPSIZE + "x" + MAPSIZE; //sets the size of the map window
    	imageUrl += "&maptype=" + MAPTYPE; //sets the type of map
    	imageUrl += "&path=color:0x0000ff|weight:5"; //sets the path parameters
    	for(int i = 0; i < lats.size(); i++) //sets the path coordinates
    	{
    		imageUrl += "|" + lats.get(i) + "," + longs.get(i);
    	}
    	imageUrl += "&key=" + KEY; //adds the key
    	return imageUrl;
    }
}
