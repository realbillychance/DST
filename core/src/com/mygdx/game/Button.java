package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Button extends Image
{
	private int clickx;
	private int clicky;
	boolean clicked=false;

	public Button(String t)
	{
		super(new Texture(t));
		setBounds(getX(),getY(),getWidth(),getHeight());
		addListener(new InputListener(){
			public boolean touchDown(InputEvent event, float x,float y,int pointer,int button)
			{
				clicked=true;
				return true;
			}
		});
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
	@Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch,parentAlpha);
    }
	
	
}
