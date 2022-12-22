package com.himanshu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.himanshu.game.Modes.flag;

public class Win implements Screen {
    private final MyOwnGame tankStars;
    private Stage st;
    private Viewport viewport;
    private Texture txt;
    private Image winner, ExitGame;
    public Win(final MyOwnGame tankStars){
        this.tankStars=tankStars;
        viewport = new FillViewport(1400,647,new OrthographicCamera());
        st =new Stage(viewport);
        txt = new Texture(Gdx.files.internal("victory.png"));
        Image img=new Image(txt);
        st.addActor(img);

        System.out.println("helejf"+ flag);

        if(flag==1){
            winner=new Image(new Texture("p2tank.png"));
            winner.setPosition(100,100);
            winner.setSize(700,350);
            st.addActor(winner);
        }
        else if (flag==2) {
            winner=new Image(new Texture("p1tank.png"));
            winner.setPosition(100,100);
            winner.setSize(700,350);
            st.addActor(winner);
        }
        ExitGame =  new Image(new Texture("exit.png"));
        ExitGame.setPosition(900,-20);
        ExitGame.setSize(500,250);
        ExitGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tankStars.setScreen(new Gameplay(tankStars));
            }
        });
        st.addActor(ExitGame);
        Gdx.input.setInputProcessor(st);
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        st.act(delta);
        st.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void resume() {

    }
}
