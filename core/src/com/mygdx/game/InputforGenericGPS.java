package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class InputforGenericGPS implements Screen {
	final DYNAMO game;
	private Stage stage;
	private BitmapFont pos;
	private TextField initlongitude;
	private TextField initlatitude;
	private TextField velocity;
	private TextField center;
	private TextField deviation;
	private TextField interval;
	private TextField maxd;
	private TextField maxt;
	private Button enter;
	private Skin textboxskin;
	private Texture back;
	private BitmapFont name;
	private BitmapFont age;
	private BitmapFont height;
	private BitmapFont weight;
	private BitmapFont country;
	private Texture face;
	private double  initlong ;
	private double initlat;
	private double  v;
	private double  c ;
	private double d ;
	private int inter;
	private double mdist;
	private double mtime;
	private int m=0;
	private Button home;
	private Button question;
	private Texture box;
	private Texture logo;
	boolean status;
	private Image labels;
	public InputforGenericGPS (final DYNAMO gam)
	{
		game=gam;
		//back=new Texture("GPS Backgrounds.png");
		back=new Texture("GoogleMapsBackgrounedResized.png");
		logo= new Texture("Google Maps Logo.png");
		face= new Texture("Face.png");
		textboxskin= new Skin(Gdx.files.internal("uiskin.json"));
		initlongitude= new TextField("Enter initial longitude ",textboxskin);
		initlongitude.setPosition(0, 190);
		initlatitude= new TextField("Enter initial latitude ",textboxskin);
		initlatitude.setPosition(200, 190);
		velocity= new TextField("Enter average velocity m/s ",textboxskin);
		velocity.setPosition(400, 190);
		center= new TextField("Enter angle center in degrees ",textboxskin);
		center.setPosition(600, 190);
		deviation= new TextField("Enter standard deviation ",textboxskin);
		deviation.setPosition(800, 190);
		interval= new TextField("Enter time interval in seconds ",textboxskin);
		interval.setPosition(200, 125);
		maxd= new TextField("Enter maximum distance ",textboxskin);
		maxd.setPosition(600, 125);
		maxt= new TextField("Enter maximum time ",textboxskin);
		maxt.setPosition(400, 125);
		enter= new Button("Enter.png");
		enter.setPosition(425, 25);
		pos= new BitmapFont();
		pos.setColor(Color.RED);
		name=new BitmapFont();
		name.setColor(Color.BLACK);
		age=new BitmapFont();
		age.setColor(Color.BLACK);
		height=new BitmapFont();
		height.setColor(Color.BLACK);
		weight=new BitmapFont();
		weight.setColor(Color.BLACK);
		country=new BitmapFont();
		country.setColor(Color.BLACK);
		home= new Button("Home Button.PNG");
		home.setPosition(0, 700);
		question=new Button("Question Icon.png");
		question.setPosition(10, 109);
		box= new Texture("AboutGPS.fw.png");
		labels=new Image(box);
		labels.setPosition(120, 0);
		labels.setVisible(false);
		status=false;
		stage= new Stage();
		stage.addActor(initlongitude);
		stage.addActor(initlatitude);
		stage.addActor(velocity);
		stage.addActor(center);
		stage.addActor(deviation);
		stage.addActor(enter);
		stage.addActor(interval);
		stage.addActor(maxd);
		stage.addActor(maxt);
		stage.addActor(home);
		stage.addActor(question);
		stage.addActor(labels);
		Gdx.input.setInputProcessor(stage);
	}
	@Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        game.batch.begin();
        game.batch.draw(back,0,0);
        game.batch.draw(logo,170,400);
      //  game.batch.draw(face,400,440);
        //pos.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(819-Gdx.input.getY()), 200, 500);
      //  name.draw(game.batch, "Simon Whitefield", 428, 700);
       // age.draw(game.batch, "Age: 41", 428, 400);
      //  height.draw(game.batch, "Height: 5ft 10in", 428, 350);
       // weight.draw(game.batch, "Weight: 154 lbs", 428, 300);
      //  country.draw(game.batch, "Country: Canada", 428, 250);
        game.batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
    		if(enter.getClicked())
    		{
    			//if(m==0)
    			//{
    				
    			//}
    			//else
    			//{
    		
    			
    				initlong=Double.parseDouble(initlongitude.getText());
    				initlat=Double.parseDouble(initlatitude.getText());
    				v=Double.parseDouble(velocity.getText());
    				c=Double.parseDouble(center.getText());
    				d=Double.parseDouble(deviation.getText());
    				inter=Integer.parseInt(interval.getText());
    				mdist=Double.parseDouble(maxd.getText());
    				mtime=Double.parseDouble(maxt.getText());
    				m++;
    				initlongitude.setText("Enter swim speed");
    				initlatitude.setText("Enter cycle speed");
    				velocity.setText("Enter run speed");
    				center.setText("Enter transition 1 speed");
    				deviation.setText("Enter transition 2 speed");
    				game.setScreen(new DisplayGoogle(game,initlong,initlat,v,c,d,inter,mdist,mtime));
    				dispose();
    		}
    		if(home.getClicked()){
				game.setScreen(new ChooseSimualtionScreen(game));
	            dispose();
    		}
    		if(question.getClicked()){
    			if(status==false){
    				labels.setVisible(true);
    				status=true;
    			}
    			else{
    				labels.setVisible(false);
    				status=false;
    			}
    		}
    			//}		
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
