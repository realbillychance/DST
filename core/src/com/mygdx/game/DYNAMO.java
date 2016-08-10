package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class DYNAMO extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    private double [] s;
    private double [] c;
    private double [] r;
    private double [] t1;
    private double [] t2;
    public void create() {
        batch = new SpriteBatch();
        //Use LibGDX's default Arial font.
        font = new BitmapFont();
        s = new double [10];
        c= new double [10];
        r= new double [10];
        t1= new double [10];
        t2= new double [10];
        s[0]=5;
        c[0]=8;
        r[0]=6;
        t1[0]=3;
        t2[0]=3;
        //this.setScreen(new MapGui(this,s,c,r,t1,t1));
        //this.setScreen(new SendingtoDatabase(this));
      this.setScreen(new ChooseSimualtionScreen(this));
        
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}