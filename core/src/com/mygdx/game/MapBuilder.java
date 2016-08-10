package com.mygdx.game;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class MapBuilder
{	
	UrlBuilder urlBuilder;
	
	public MapBuilder(ArrayList<Double> lats, ArrayList<Double> longs)
	{
		urlBuilder = new UrlBuilder(lats, longs);
	}
	
	public Texture displayMap() 
	{    	
		//JFrame map = new JFrame("Google Maps");
		
		try
		{
			String destinationFile = "image.jpg";
			URL url = new URL(urlBuilder.buildUrl());
			System.out.println(url);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(destinationFile);

			byte[] b = new byte[2048];
			int length;
			while((length = is.read(b)) != -1)
			{
				os.write(b, 0, length);
			}
			is.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		//map.add(new JLabel(new ImageIcon((new ImageIcon("image.jpg")).getImage())));
		//map.setVisible(true);
		//map.pack();
		Texture f = new Texture("Face.png");
		//return new Texture("assets/image.jpg");
		return new Texture("image.jpg");

	}
}