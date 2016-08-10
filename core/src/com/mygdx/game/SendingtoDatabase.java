package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.sun.glass.ui.CommonDialogs.Type;





public class SendingtoDatabase implements Screen {
	final DYNAMO game;
//	SpriteBatch batch;
	Texture img;
	Texture body;
	private BitmapFont font;
	Runner player;
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
	private Stage stage;
	Image win;
	Button closew;
	double v;
	double d;
	int t;
	double c;
	int m;
	int val=10;
	int x;
	int y;
	int num=0;
	boolean yak=true;
	boolean xeta=true;
	int p;
	int o=0;
	ArrayList<Integer> q;
	ArrayList<Integer> w;
	public SendingtoDatabase (final DYNAMO gam) {
		this.game=gam;
		img = new Texture("Maps.png");
		body= new Texture("Swimming.png");
		font= new BitmapFont();
		font.setColor(Color.BLUE);
		
		ArrayList<Coordinate> list = new ArrayList<Coordinate>();
		q= new ArrayList<Integer>();
		w= new ArrayList<Integer>();
		
		FileHandle swim = Gdx.files.internal("swim.txt");
		FileHandle cycle = Gdx.files.internal("cycle.txt");
		FileHandle run = Gdx.files.internal("run.txt");

		TriathlonTime triathlon = new TriathlonTime(swim, cycle, run, 5, 5, 5, 5, 5);
		list=triathlon.triathlonSim();
		for(int i =1; i<list.size();i++)
		{
			if(list.get(i).getX()!=list.get(i-1).getX()&&list.get(i).getY()!=list.get(i-1).getY()){
				t=list.get(i).getDeltaTime();
				d=Math.sqrt(Math.pow(list.get(i).getX()-list.get(i-1).getX(),2)+Math.pow(list.get(i).getY()-list.get(i-1).getY(),2));
				v=triathlon.getRunSpeed();
				m=(int)((list.get(i).getY()-list.get(i-1).getY())/(list.get(i).getX()-list.get(i-1).getX()+0.0001));
				c=v*val;
				//False is negative
				if(list.get(i).getY()-list.get(i-1).getY()<0){
					yak=false;
				}
				else{
					yak=true;
				}
				if(list.get(i).getX()-list.get(i-1).getX()<0){
					xeta=false;
				}
				else{
					xeta=true;
				}
				if(xeta==false && yak ==false){
					x=((int)(-1*(c/Math.sqrt(Math.pow(m, 2)+1))))+list.get(i-1).getX();
					y=((int)((c/Math.sqrt(Math.pow(m, 2)+1))*m))+list.get(i-1).getY();
				}
				else
				{
					if(xeta==false){
						x=((int)(-1*(c/Math.sqrt(Math.pow(m, 2)+1))))+list.get(i-1).getX();
						y=(int)((c/Math.sqrt(Math.pow(m, 2)+1))*m*-1)+list.get(i-1).getY();
						System.out.println("HELLLLLLOOOOO Y: "+ y);
					}
					else{
						if(yak==false){
							x=((int)(c/Math.sqrt(Math.pow(m, 2)+1)))+list.get(i-1).getX();
							y=((int)((c/Math.sqrt(Math.pow(m, 2)+1))*m)*-1)+list.get(i-1).getY();
						}
						else{
							x=((int)(c/Math.sqrt(Math.pow(m, 2)+1)))+list.get(i-1).getX();
							y=(int)((c/Math.sqrt(Math.pow(m, 2)+1))*m)+list.get(i-1).getY();
						}
					}
				}
				num=num+val;
				System.out.println("Name: Alistair Brownlee "+ "X: "+x+" Y: "+y+" Time: "+t+" M: "+m+" V: "+v);
				q.add(x);
				w.add(y);
			}
		}
		
	}

	@Override
	public void render (float delta) {
	Gdx.gl.glClearColor(1, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	game.batch.begin();
	game.batch.draw(img, 0, 0);
	if(p>75 && o<q.size()){
		p=0;
		o++;
	}
	game.batch.draw(body, q.get(o), w.get(o));
	game.batch.end();
	p++;
	}
	
	@Override
	public void dispose () {
		game.batch.dispose();
		img.dispose();
		font.dispose();
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
