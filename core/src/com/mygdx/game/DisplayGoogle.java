package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class DisplayGoogle implements Screen {
	final DYNAMO game;
	private double longitude;
	private double latitude;
	private double velocity;
	private double center;
	private int interval;
	private double maxDistance;
	private double maxTime;
	private double deviation;
	private ArrayList<Double> lats= new ArrayList<Double>();
	private ArrayList<Double> longs= new ArrayList<Double>();
	private Texture map;
	private Texture back;
	private Button home;
	private Stage stage;
	public DisplayGoogle(final DYNAMO gam,double longi, double lat, double v, double c, double d, int i, double maxd, double maxt )
	{
		// 51, 0, 5,50,2,1,100,500
		game=gam;
		longitude=longi;
		latitude=lat;
		velocity=v;
		center=c;
		interval=i;
		maxDistance=maxd;
		maxTime=maxt;
		deviation=d;
		home= new Button("Home Button.PNG");
        home.setPosition(0, 700);
		//back= new Texture("GPS Backgrounds.png");
        back=new Texture("GoogleMapsBackgrounedResized.png");
		GenericGPSSimulation gps = new GenericGPSSimulation(longitude, latitude, velocity, interval);
		
		
		int time = 0; // time in seconds
		while(gps.calcTotalDis() <= maxDistance && time <= maxTime)
		{
			center = randAngle(center, deviation);
			lats.add(gps.calcLat(center));
			longs.add(gps.calcLong(center));
	
			time += interval;
		}
		MapBuilder mapBuilder = new MapBuilder(lats, longs);
		map=mapBuilder.displayMap();
		stage=new Stage();
		stage.addActor(home);
		 Gdx.input.setInputProcessor(stage);
	}
	public static double randAngle(double prevAngle, double stndDev)
	{
		Random r = new Random();
		return r.nextGaussian()*stndDev + prevAngle;
	}
	public void render (float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(back,0,0); 
		game.batch.draw(map,150,100); 
		game.batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
			if(home.getClicked()){
				game.setScreen(new ChooseSimualtionScreen(game));
	            dispose();
			}
		}
	}
	//@Override
	public void dispose () {
		//game.batch.dispose();
	}
	 public void resize(int width, int height) {
	    }

	    @Override
	    public void show() {
	        
	    }

	    @Override
	    public void hide() {
	    }

	    @Override
	    public void pause() {
	    }

	    @Override
	    public void resume() {
	    }
}


