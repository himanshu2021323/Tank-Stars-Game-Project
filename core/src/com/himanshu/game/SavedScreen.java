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

public class SavedScreen implements Screen {
    private final MyOwnGame tankStars;
    private Image g1,g2,g3;
    private Texture txt;
    private Viewport viewport;
    private Stage st;

    public SavedScreen(final MyOwnGame tankStars) {
        this.tankStars=tankStars;
        viewport = new FillViewport(1400,647,new OrthographicCamera());
        st =new Stage(viewport);

        txt = new Texture(Gdx.files.internal("savedgbg.png"));
        Image img = new Image(txt);
        st.addActor(img);

        g1 =  new Image(new Texture("sgame1.png"));
        g1.setPosition(100,300);
        g1.setSize(400,100);
        g1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tankStars.setScreen(new Modes(tankStars));
            }
        });
        st.addActor(g1);

        g2 =  new Image(new Texture("sgame2.png"));
        g2.setPosition(550,300);
        g2.setSize(400,100);
        g2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tankStars.setScreen(new Modes(tankStars));
            }
        });
        st.addActor(g2);

        g3 =  new Image(new Texture("sgame3.png"));
        g3.setPosition(980,300);
        g3.setSize(400,100);
        g3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tankStars.setScreen(new Modes(tankStars));
            }
        });
        st.addActor(g3);
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
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
