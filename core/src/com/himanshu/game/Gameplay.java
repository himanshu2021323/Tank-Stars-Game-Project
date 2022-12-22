package com.himanshu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Gameplay implements Screen {
    private final MyOwnGame tankStars;
    private Image Player, Computer, Saved, Exit, tanks;
    private Texture txt;
    private Viewport viewport;
    private Skin sk;
    private Sound sd;
    private Stage st;

    public Gameplay(final MyOwnGame tankStars) {
        this.tankStars = tankStars;

        Sound sd1 = Gdx.audio.newSound(Gdx.files.internal("GamePlay.mp3"));
        this.sd=sd1;
        sd.play();

        viewport = new FillViewport(1400,647,new OrthographicCamera());
        st =new Stage(viewport);

        txt = new Texture(Gdx.files.internal("bggamep.png"));
        Image img=new Image(txt);
        st.addActor(img);

        sk = new Skin(Gdx.files.internal("star-soldier/skin/star-soldier-ui.json"));
        tanks=new Image(new Texture("abramstank.png"));
        tanks.setSize(700,350);
        tanks.setPosition(100,100);
        st.addActor(tanks);

        Exit =  new Image(new Texture("exit.png"));
        Exit.setSize(500,250);
        Exit.setPosition(900,-20);
        Exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sd.pause();
                Gdx.app.exit();
            }
        });
        st.addActor(Exit);

        Saved=new Image(new Texture("savedg.png"));
        Saved.setSize(500,250);
        Saved.setPosition(900,130);
        Saved.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sd.pause();
                tankStars.setScreen(new SavedScreen(tankStars));
            }
        });
        st.addActor(Saved);

        Computer = new Image(new Texture("vscomputer.png"));
        Computer.setPosition(900,280);
        Computer.setSize(500,250);
        Computer.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                sd.pause();
                tankStars.setScreen(new Tanks2(tankStars));
            }
        });
        st.addActor(Computer);

        Player =  new Image(new Texture("vsplayer.png"));
        Player.setPosition(900,430);
        Player.setSize(500,250);
        Player.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
               sd.pause();
                tankStars.setScreen(new Tanks1(tankStars));
            }
        });
        st.addActor(Player);
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
    public void resume() {

    }

    @Override
    public void hide() {

    }
    @Override
    public void show() {

    }

    @Override
    public void dispose() {
        st.dispose();

    }

    @Override
    public void pause() {

    }
}
