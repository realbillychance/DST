package com.mygdx.game;

import java.io.File;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class MapGui implements Screen {
	final DYNAMO game;
//	SpriteBatch batch;
	Texture img;
	Texture[] body= new Texture[10];
	private BitmapFont font;
	Runner player;
	Runner enemy;
	float startX, startY, endX, endY;
	float speed ;
	float elapsed;
	float distance;
	float directionX;
	float directionY;
	boolean moving;
	boolean pressed;
	int clickx;
	int clicky;
	int i=0;
	private Stage stage;
	Image win;
	Button closew;
	int totalTime=0;
	Triathlon [] triathlons;
	ArrayList<ArrayList<Coordinate>> list;
	ArrayList<Runner> runners;
	String[] names;
	private Button home;
	private Button start;
	private Button pause;
	public MapGui (final DYNAMO gam, double [] s, double [] c, double [] r,double [] t1,double [] t2) {
		this.game=gam;
		img = new Texture("Maps.png");
		//body= new Texture("Swimming.png");
		for(int i=0;i<body.length;i++){
			body[i]= new Texture("Swimming"+(i+1)+".png");
		}
		font= new BitmapFont();
		font.setColor(Color.RED);
		names= new String[10];
		names[0]="Simon Whitefield";
		names[1]="Anthony";
		names[2]="Ben";
		names[3]="Steve Rogers";
		names[4]="Thor Odinson";
		names[5]="Matt Murdock";
		names[6]="Bruce Banner";
		names[7]="Luke Cage";
		names[8]="Peter Parker";
		names[9]="Stephen Strange";
		//ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		triathlons= new Triathlon[10];
		list = new ArrayList<ArrayList<Coordinate>>();
		
		FileHandle swim = Gdx.files.internal("swim.txt");
		FileHandle cycle = Gdx.files.internal("cycle.txt");
		FileHandle run = Gdx.files.internal("run.txt");
		//S:5 C:8 R:6 T1:3 T2:3
		//Triathlon triathlon = new Triathlon(swim, cycle, run, s[0], c[0], r[0], t1[0], t2[0]);
		for(int i=0; i<triathlons.length;i++){
			triathlons[i]=new Triathlon(swim,cycle,run,s[i],c[i],r[i],t1[i],t2[i]);
			list.add(triathlons[i].triathlonSim());
		}
		//list=triathlon.triathlonSim();
		//for(int i=0; i<list.size();i++){
		//	System.out.println(list.get(i).getDeltaTime());
		//}
		runners= new ArrayList<Runner>();
		for(int i=0;i<list.size();i++){
			runners.add(new Runner(body[i],names[i],list.get(i),triathlons[i].getSwimSpeed(),triathlons[i].getCycleSpeed(),triathlons[i].getRunSpeed(),i));
		}
		
		for(int i=0; i<runners.size();i++){
			runners.get(i).setPosition(runners.get(i).getFirst().getX(), runners.get(i).getFirst().getY());
			runners.get(i).setStartEnd(runners.get(i).getFirst(),runners.get(i).getNext());
		}
		
		//player= runners.get(0);
		speed=50;
		 
		//player.setPosition(player.getFirst().getX(), player.getFirst().getY());
		//player.setStartEnd(player.getFirst(), player.getNext());
		moving = true;
		pressed=false;
		stage= new Stage();
		Gdx.input.setInputProcessor(stage);
		win= new Image(new Texture("Box.png"));
		win.setPosition(0, 0);
		closew= new Button("Close.png");
		closew.setPosition(20, 0);
		home=new Button("Home Button.PNG");
		home.setPosition(0, 700);
		start=new Button("Start.png");
		start.setPosition(75, 700);
		pause=new Button("Pause.png");
		pause.setPosition(200, 700);
		stage.addActor(home);
		stage.addActor(start);
		stage.addActor(pause);
		for(int i=0;i<runners.size();i++){
			stage.addActor(runners.get(i));
		}
		
		//stage.addActor(player);
		stage.addActor(win);
		stage.addActor(closew);
		win.setVisible(false);
		closew.setVisible(false);
		//player=runners.get(0);
		//enemy=runners.get(1);
	}

	@Override
	public void render (float delta) {
	/*
		if(player.getEnd().getPivot()<9){
	        if(i>12)
	        {
	        	totalTime+=5;
	        	System.out.println("Name: Simon Whitfield"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
	        	i=0;
	        }
	        i++;
		}
		else{
			if(player.getEnd().getPivot()<32){
		        if(i>19)
		        {
		        	totalTime+=5;
		        	System.out.println("Name: Simon Whitfield"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
		        	i=0;
		        }
		        i++;
			}
			else{
			    if(i>14){
			    	totalTime+=5;
			        System.out.println("Name: Simon Whitfield"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
			        i=0;
			    }
			    i++;
				}
		}
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			i=0;
			pressed=true;
		}
        if(pressed){
        	if(moving == true){
        	    player.setPosition((player.getDirectionX()   * player.getSpeed() * Gdx.graphics.getDeltaTime())+player.getX(), (player.getDirectionY() * player.getSpeed() * Gdx.graphics.getDeltaTime())+player.getY());
        	    //System.out.println(player.getY());
        	    if(Math.sqrt(Math.pow(player.getX()-player.getStart().getX(),2)+Math.pow(player.getY()-player.getStart().getY(),2)) >= player.getDistance()){
        	        player.setPosition(player.getEnd().getX(), player.getEnd().getY());
        	        if(player.getIndex()==player.getSize())
        	        	moving = false;
        	        else
        	        {
        	        	player.setStartEnd(player.getEnd(), player.getNext());
        	        }
        	    }
        	}
        } 
      

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(img, 0, 0);
		font.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(Gdx.input.getY()), 200, 200);
		//Comment next line out for testing
		//player.setPosition(Gdx.input.getX(), 819-Gdx.input.getY());
		game.batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	    if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
    		if(player.getClicked())
    		{
    			System.out.println("Name: "+player.getName());
    			win.setVisible(true);
    			closew.setVisible(true);
    		}
    		if(closew.getClicked())
    		{
    			stage.unfocus(win);
    			stage.unfocus(closew);
    			win.setVisible(false);
    			closew.setVisible(false);
    		}
    		if(home.getClicked()){
				game.setScreen(new ChooseSimualtionScreen(game));
	            dispose();
			} 
    	}
    	*/
		
		
		
		/*
		if(player.getEnd().getPivot()<9){
	        if(i>12)
	        {
	        	totalTime+=5;
	        	System.out.println("Name: Alistair Brownlee"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
	        	i=0;
	        }
	        i++;
		}
		else{
			if(player.getEnd().getPivot()<32){
		        if(i>19)
		        {
		        	totalTime+=5;
		        	System.out.println("Name: Alistair Brownlee"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
		        	i=0;
		        }
		        i++;
			}
			else{
			    if(i>14){
			    	totalTime+=5;
			        System.out.println("Name: Alistair Brownlee"+ " X: "+(player.getX()-141)+" Y: "+((819-player.getY())-107)+" Time: "+totalTime);
			        i=0;
			    }
			    i++;
				}
		}
		*/
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			i=0;
			pressed=true;
			runners.get(0).setMoving(true);
        	runners.get(1).setMoving(true);
        	runners.get(2).setMoving(true);
        	runners.get(3).setMoving(true);
        	runners.get(4).setMoving(true);
        	runners.get(5).setMoving(true);
        	runners.get(6).setMoving(true);
        	runners.get(7).setMoving(true);
        	runners.get(8).setMoving(true);
        	runners.get(9).setMoving(true);
		}
        if(pressed){
        	//player.move();
        	//enemy.move();
        	runners.get(0).move();
        	runners.get(1).move();
        	runners.get(2).move();
        	runners.get(3).move();
        	runners.get(4).move();
        	runners.get(5).move();
        	runners.get(6).move();
        	runners.get(7).move();
        	runners.get(8).move();
        	runners.get(9).move();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.P)){
        	runners.get(0).setMoving(false);
        	runners.get(1).setMoving(false);
        	runners.get(2).setMoving(false);
        	runners.get(3).setMoving(false);
        	runners.get(4).setMoving(false);
        	runners.get(5).setMoving(false);
        	runners.get(6).setMoving(false);
        	runners.get(7).setMoving(false);
        	runners.get(8).setMoving(false);
        	runners.get(9).setMoving(false);
        }
        

        Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(img, 0, 0);
		//font.draw(game.batch, "X: "+Gdx.input.getX()+" Y: "+(Gdx.input.getY()), 200, 200);
		//Comment next line out for testing
		//player.setPosition(Gdx.input.getX(), 819-Gdx.input.getY());
		game.batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
	    stage.draw();
	    if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
    		/*if(player.getClicked())
    		{
    			System.out.println("Name: "+player.getName());
    			win.setVisible(true);
    			closew.setVisible(true);
    		}*/
    		if(closew.getClicked())
    		{
    			stage.unfocus(win);
    			stage.unfocus(closew);
    			win.setVisible(false);
    			closew.setVisible(false);
    		}
    		if(home.getClicked()){
				game.setScreen(new ChooseSimualtionScreen(game));
	            dispose();
			}
    		if(start.getClicked()){
    			i=0;
    			pressed=true;
    			runners.get(0).setMoving(true);
            	runners.get(1).setMoving(true);
            	runners.get(2).setMoving(true);
            	runners.get(3).setMoving(true);
            	runners.get(4).setMoving(true);
            	runners.get(5).setMoving(true);
            	runners.get(6).setMoving(true);
            	runners.get(7).setMoving(true);
            	runners.get(8).setMoving(true);
            	runners.get(9).setMoving(true);
    		}
    		if(pause.getClicked()){
    			runners.get(0).setMoving(false);
            	runners.get(1).setMoving(false);
            	runners.get(2).setMoving(false);
            	runners.get(3).setMoving(false);
            	runners.get(4).setMoving(false);
            	runners.get(5).setMoving(false);
            	runners.get(6).setMoving(false);
            	runners.get(7).setMoving(false);
            	runners.get(8).setMoving(false);
            	runners.get(9).setMoving(false);
    		}
    	}
		
	}
	
	//@Override
	public void dispose () {
		//game.batch.dispose();
		//img.dispose();
		//font.dispose();
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
