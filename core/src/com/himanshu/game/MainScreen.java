package com.himanshu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainScreen extends ApplicationAdapter implements Screen  {
    private Stage st;
    private Sound sd;
    private final MyOwnGame tankStars;
    class MyCharacter extends Actor {
        Texture texture = new Texture(Gdx.files.internal("loadingscreen1.png"));

        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(texture, 0, 0);
        }
    }
    public MainScreen(MyOwnGame tankStars) {
        st =new Stage(new ScreenViewport());
        MyCharacter actor = new MyCharacter();
        st.addActor(actor);

        Sound sd = Gdx.audio.newSound(Gdx.files.internal("GamePlay.mp3"));
        this.sd=sd;
        sd.play();

        Gdx.input.setInputProcessor(st);
        this.tankStars=tankStars;
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        st.draw();

        if(Gdx.input.justTouched()){
            sd.pause();
            tankStars.setScreen(new Gameplay(tankStars));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void dispose() {
        st.dispose();

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
}
