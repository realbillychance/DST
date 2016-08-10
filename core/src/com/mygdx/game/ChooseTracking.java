package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ChooseTracking implements Screen {

	final DYNAMO game;
	private Button GPS;
	private Button ARFID;
	private Button PRFID;
	private Stage stage;
	private BitmapFont pos;
	
	public ChooseTracking(final DYNAMO gam)
	{
		game=gam;
		GPS= new Button("GPS.png");
		GPS.setPosition(0, 0);
		ARFID= new Button("Active RFID.png");
		ARFID.setPosition(0,100);
		PRFID= new Button("Passive RFID.png");
		PRFID.setPosition(0, 200);
		pos= new BitmapFont();
		pos.setColor(Color.RED);
		stage= new Stage();
		stage.addActor(GPS);
		stage.addActor(ARFID);
		stage.addActor(PRFID);
		Gdx.input.setInputProcessor(stage);
	}
	 @Override
	    public void render(float delta) {
	        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	        
	        game.batch.begin();
	        pos.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(819-Gdx.input.getY()), 200, 500);
	        game.batch.end();
	        
	        stage.act(Gdx.graphics.getDeltaTime());
	        stage.draw();
	        
	        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
	    		if(GPS.getClicked() || ARFID.getClicked() || PRFID.getClicked())
	    		{
	    			game.setScreen(new GPSOptions(game));
	                dispose();
	    		}
	    	}
	    }
	    public void hide()
	    {
	    	
	    }
	    public void dispose()
	    {
	    	
	    }
	    public void resize(int n, int j)
	    {
	    	
	    }
	    public void show()
	    {

	    	
	    }
	    public void pause()
	    {
	    	
	    }
	    public void resume()
	    {
	    	
	    }
}
