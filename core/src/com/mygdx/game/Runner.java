package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Runner extends Image
{
	ArrayList<Coordinate> coordinates;
	private String name;
	//Base Speed is 50
	float speed=50;
	private Coordinate start;
	private Coordinate end;
	private float fdistance;
	private float directionX;
	private float directionY;
	private int next=1;
	private boolean clicked=false;
	private double swimSpeed;
	private double runSpeed;
	private double cycleSpeed;
	private boolean moving=true;
	private int code=0;
	public Runner(Texture text,String n,double s, double c, double r,int i)
	{
		super(text);
		name=n;
		swimSpeed=s+50;
		runSpeed=r+50;
		cycleSpeed=c+50;
		speed=(float)swimSpeed;
		code=i;
		setBounds(getX(),getY(),getWidth(),getHeight());
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x,float y,int pointer,int button)
			{
				clicked=true;
				return true;
			}
		});
	}
	public Runner(Texture text, String n, ArrayList<Coordinate> list,double s, double c, double r,int i)
	{
		super (text);
		name=n;
		coordinates = list;
		coordinates.add(9,new Coordinate(36,10));
		coordinates.add(12,new Coordinate(37,10));
		coordinates.add(30,new Coordinate(38,10));
		coordinates.add(33, new Coordinate(39,10));
		coordinates.add(34, new Coordinate(40,10));
		coordinates.add(35, new Coordinate(41,10));
		coordinates.add(36, new Coordinate(42,10));
		coordinates.add(41,new Coordinate(43,10));
		coordinates.add(42,new Coordinate(44,10));
		coordinates.add(43,new Coordinate(45,10));
		coordinates.add(44,new Coordinate(46,10));
		coordinates.add(46,new Coordinate(47,10));
		coordinates.add(47,new Coordinate(48,10));
		coordinates.add(48,new Coordinate(49,10));
		coordinates.add(49,new Coordinate(50,10));
		coordinates.add(50,new Coordinate(51,10));
		code=i;
		// 9   551 188
		// 12    534 217
		//28 628 564
		//30 627 526, 594 444, 559 323, 547 262
		//34 534 217, 563 397, 577 441, 622 548
		//35 701 654, 627 526, 594 444, 559 323, 547 262
		
		swimSpeed=s+50;
		runSpeed=r+50;
		cycleSpeed=c+50;
		speed=(float)swimSpeed;
		setBounds(getX(),getY(),getWidth(),getHeight());
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x,float y,int pointer,int button)
			{
				clicked=true;
				return true;
			}
		});
	}
	/*public void draw(SpriteBatch spriteBatch)
	{
		super.draw(spriteBatch);
	}*/
	public void addCoordinate(Coordinate c)
	{
		coordinates.add(c);
	}
	public void addCoordinate(int i,Coordinate c)
	{
		coordinates.add(i, c);
	}
	public void setCoordinates(ArrayList<Coordinate> list)
	{
		coordinates=list;
	}
	public String getName()
	{
		return name;
	}
	public void setStartEnd(Coordinate s,Coordinate e)
	{
		start=s;
		end=e;
		next++;
		fdistance=(float)Math.sqrt(Math.pow(end.getX()-start.getX(),2)+Math.pow(end.getY()-start.getY(),2));
		//Sets Speed
		if(e.getPivot()==9){
			speed=(float)cycleSpeed;
			//this.setDrawable(new SpriteDrawable(new Sprite(new Texture("Bike.png"))));
			this.setDrawable(new SpriteDrawable(new Sprite(new Texture("Bike"+(code+1)+".png"))));
			
		}
		if(e.getPivot()==32){
			speed=(float)runSpeed;
			//this.setDrawable(new SpriteDrawable(new Sprite(new Texture("Sneakers.png"))));
			this.setDrawable(new SpriteDrawable(new Sprite(new Texture("Sneakers"+(code+1)+".png"))));
		}
		directionX = (end.getX()-start.getX()) / fdistance;
		directionY = (end.getY()-start.getY()) / fdistance;
	}
	
	public float getDistance()
	{
		return fdistance;
	}
	public float getDirectionX()
	{
		return directionX;
	}
	public float getDirectionY()
	{
		return directionY;
	}
	public Coordinate getFirst()
	{
		return coordinates.get(0);
	}
	public Coordinate getNext()
	{
		return coordinates.get(next);
	}
	public Coordinate getEnd()
	{
		return end;
	}
	public int getIndex()
	{
		return next;
	}
	public int getSize()
	{
		return coordinates.size();
	}
	public Coordinate getStart()
	{
		return start;
	}
	public float getSpeed()
	{
		return speed;
	}
	@Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
	public boolean getClicked()
	{
		if(clicked==true)
		{
			clicked=false;
			return true;
		}
		else
		{
			return false;
		}
	}
	public void move()
	{
		if(moving == true){
    	    this.setPosition((this.getDirectionX()   * this.getSpeed() * Gdx.graphics.getDeltaTime())+this.getX(), (this.getDirectionY() * this.getSpeed() * Gdx.graphics.getDeltaTime())+this.getY());
    	    //System.out.println(this.getY());
    	    if(Math.sqrt(Math.pow(this.getX()-this.getStart().getX(),2)+Math.pow(this.getY()-this.getStart().getY(),2)) >= this.getDistance()){
    	        this.setPosition(this.getEnd().getX(), this.getEnd().getY());
    	        if(this.getIndex()==this.getSize())
    	        	moving = false;
    	        else
    	        {
    	        	this.setStartEnd(this.getEnd(), this.getNext());
    	        }
    	    }
    	}
	}
	public void setMoving(boolean check)
	{
		moving=check;
	}
	
	
	
	
	
}
