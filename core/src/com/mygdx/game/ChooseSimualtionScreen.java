package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class ChooseSimualtionScreen implements Screen {

    final DYNAMO game;
    private Texture back;
    private Texture btri;
    boolean tclicked;
    private Button tri;
    private Button water;
    private Button shooter;
    private Button land;
    private Button about;
   // private BitmapFont pos;
    private Button btnGPS;
    private Button btnARFID;
    private Button btnPRFID;
    private Stage stage;
    


    public ChooseSimualtionScreen(final DYNAMO gam) {
        game = gam;
        back = new Texture("MainBackgroundsFinishedSensorData.fw.png");
        tri = new Button("Triathlon.PNG");
        tri.setPosition(23,254);
        btnGPS = new Button("GPS.png");
        btnGPS.setPosition(290, 63);
        btnARFID= new Button("Active RFID.png");
        btnARFID.setPosition(420, 63);
        btnPRFID=new Button("Passive RFID.png");
        btnPRFID.setPosition(550, 63);
        water = new Button("Water Search.PNG");
        water.setPosition(503, 254);
        shooter=new Button("Shooter.PNG");
        shooter.setPosition(263, 254);
        land=new Button("Land.PNG");
        land.setPosition(743, 254);
        about=new Button("About.PNG");
        about.setPosition(409, 450);
      //  pos= new BitmapFont();
      //  pos.setColor(Color.RED);
        stage = new Stage();
        stage.addActor(tri);
        stage.addActor(water);
        stage.addActor(shooter);
        stage.addActor(land);
        stage.addActor(about);
        stage.addActor(btnGPS);
        stage.addActor(btnARFID);
        stage.addActor(btnPRFID);
        Gdx.input.setInputProcessor(stage);
        //stage.setKeyboardFocus(stage.getActors().first());
        
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.batch.begin();
        game.batch.draw(back, 0, 0);
       // pos.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(819-Gdx.input.getY()), 200, 500);
        game.batch.end();
        
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
    		if(tri.getClicked()){
    			//game.setScreen(new ChooseTracking(game));
    			game.setScreen(new ChooseTriathlonScreen(game));
                dispose();
    		}
    		if(about.getClicked()){
    			game.setScreen(new Abstract(game));
                dispose();
    		}
    		if(btnGPS.getClicked()){
    			game.setScreen(new InputforGenericGPS(game));
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
