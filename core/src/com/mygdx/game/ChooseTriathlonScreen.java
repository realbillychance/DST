package com.mygdx.game;

import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class ChooseTriathlonScreen implements Screen {

    final DYNAMO game;
    private Texture back;
    private Texture btri;
    boolean tclicked;
    private Button rio;
    private Button ottawa;
    private Button chicago;
    private BitmapFont pos;
    private Button btnGPS;
    private Stage stage;
    private Button home;

    public ChooseTriathlonScreen(final DYNAMO gam)  {
        game = gam;
        
        back = new Texture("TriathlonMenuScreen.fw.png");
        rio = new Button("Rio2016.png");
        rio.setPosition(409,544);
        ottawa = new Button("Ottawa.png");
        ottawa.setPosition(409, 76);
        home= new Button("Home Button.PNG");
        home.setPosition(0, 700);
        chicago=new Button("Chicago.png");
        chicago.setPosition(409, 311);
        pos= new BitmapFont();
        pos.setColor(Color.RED);
        stage = new Stage();
        stage.addActor(rio);
        stage.addActor(ottawa);
        stage.addActor(chicago);
        stage.addActor(home);
        Gdx.input.setInputProcessor(stage);
        //stage.setKeyboardFocus(stage.getActors().first());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.batch.begin();
        game.batch.draw(back, 0, 0);
        //pos.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(819-Gdx.input.getY()), 200, 500);
        game.batch.end();
        
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
    		if(rio.getClicked()){
    			game.setScreen(new GPSOptions(game));
                dispose();
    		}
    		//if(about.getClicked()){
    		//	game.setScreen(new Abstract(game));
              //  dispose();
    		//}
    		if(home.getClicked()){
    			game.setScreen(new ChooseSimualtionScreen(game));
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
