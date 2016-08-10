package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.DYNAMO;
public class ScreensLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=948;
		config.height=819;
		new LwjglApplication(new DYNAMO(), config);
		//Look into stats page
		//Check the next gps simulation
		//Start looking at map for college map for simualtion
	}
	
}
   