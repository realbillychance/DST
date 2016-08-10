package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Abstract implements Screen {

    final DYNAMO game;
    private Texture back;
    private Button btnreturn;
   // private BitmapFont pos;
    private Stage stage;
    


    public Abstract(final DYNAMO gam) {
        game = gam;
        //back = new Texture("DYNAMO Abstract.png");
        back = new Texture("Abstract.fw.png");
        btnreturn= new Button("Back.png");
        btnreturn.setPosition(409, 130);
       // pos= new BitmapFont();
       // pos.setColor(Color.RED);
        stage = new Stage();
        stage.addActor(btnreturn);
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
    		if(btnreturn.getClicked())
    		{
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
