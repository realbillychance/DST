package com.mygdx.game;

import java.util.Random;

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

public class GPSOptions implements Screen {
	final DYNAMO game;
	private Stage stage;
	private BitmapFont pos;
	private TextField swim;
	private TextField cycle;
	private TextField run;
	private TextField tran1;
	private TextField tran2;
	private Button enter;
	private Skin textboxskin;
	private Texture back;
	private BitmapFont name;
	private BitmapFont age;
	private BitmapFont height;
	private BitmapFont weight;
	private BitmapFont country;
	private Texture face;
	private double [] s = new double[10];
	private double [] c = new double [10];
	private double [] r = new double [10];
	private double [] t1 = new double[10];
	private double [] t2 = new double[10];
	private int m=0;
	private Button home;
	private Button question;
	private Texture box;
	private Image labels;
	private boolean status;
	public GPSOptions (final DYNAMO gam)
	{
		game=gam;
		back=new Texture("Running Background.png");
		face= new Texture("Face.png");
		textboxskin= new Skin(Gdx.files.internal("uiskin.json"));
		swim= new TextField("Enter swim speed ",textboxskin);
		swim.setPosition(0, 190);
		cycle= new TextField("Enter cycle speed ",textboxskin);
		cycle.setPosition(200, 190);
		run= new TextField("Enter run speed ",textboxskin);
		run.setPosition(400, 190);
		tran1= new TextField("Enter transition 1 speed ",textboxskin);
		tran1.setPosition(600, 190);
		tran2= new TextField("Enter transition 2 speed ",textboxskin);
		tran2.setPosition(800, 190);
		enter= new Button("Enter.png");
		enter.setPosition(425, 100);
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
		int n=0;
		Random rand = new Random();
		for(int i=1;i<s.length;i++){
			n = rand.nextInt(5) + 1;
			s[i]=n;
		}
		for(int y=1;y<c.length;y++){
			n = rand.nextInt(10) + 3;
			c[y]=n;
		}
		for(int m=1;m<r.length;m++){
			n = rand.nextInt(8) + 2;
			r[m]=n;
		}
		for(int q=1;q<t1.length;q++){
			n = rand.nextInt(3) + 1;
			t1[q]=n;
		}
		for(int q=1;q<t2.length;q++){
			n = rand.nextInt(3) + 1;
			t2[q]=n;
		}
		home= new Button("Home Button.PNG");
		home.setPosition(0, 700);
		question=new Button("Question Icon.png");
		question.setPosition(65, 709);
		box= new Texture("AboutTri.fw.png");
		labels=new Image(box);
		labels.setPosition(120, 510);
		labels.setVisible(false);
		status=false;
		stage= new Stage();
		stage.addActor(swim);
		stage.addActor(cycle);
		stage.addActor(run);
		stage.addActor(tran1);
		stage.addActor(tran2);
		stage.addActor(enter);
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
        game.batch.draw(face,400,440);
        //pos.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(819-Gdx.input.getY()), 200, 500);
        name.draw(game.batch, "Simon Whitefield", 428, 700);
        age.draw(game.batch, "Age: 41", 428, 400);
        height.draw(game.batch, "Height: 5ft 10in", 428, 350);
        weight.draw(game.batch, "Weight: 154 lbs", 428, 300);
        country.draw(game.batch, "Country: Canada", 428, 250);
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
    			
    				s[m]=Double.parseDouble(swim.getText());
    				c[m]=Double.parseDouble(cycle.getText());
    				r[m]=Double.parseDouble(run.getText());
    				t1[m]=Double.parseDouble(tran1.getText());
    				t2[m]=Double.parseDouble(tran2.getText());
    				m++;
    				swim.setText("Enter swim speed");
    				cycle.setText("Enter cycle speed");
    				run.setText("Enter run speed");
    				tran1.setText("Enter transition 1 speed");
    				tran2.setText("Enter transition 2 speed");
    				game.setScreen(new MapGui(game,s,c,r,t1,t2));
    				dispose();
    			
    			//}
    		} 
    		if(home.getClicked()){
				game.setScreen(new ChooseSimualtionScreen(game));
	            dispose();
			}
    		if(question.getClicked()){
    			if(status==false){
    				labels.setVisible(true);
    				status=true;
    				System.out.println("HEEEEEEEEEEEEEEh");
    			}
    			else{
    				labels.setVisible(false);
    				status=false;
    			}
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
