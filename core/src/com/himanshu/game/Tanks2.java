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

public class Tanks2 implements Screen {
    private final MyOwnGame tankStars;
    private Texture txt;
    private Image aTank,fTank,bTank,aTank1,fTank1,bTank1,play,back;
    private Stage st;
    private Viewport viewport;
    private int  i= 0, j=0;
    public Tanks2(final MyOwnGame tankStars) {
        this.tankStars = tankStars;
        viewport = new FillViewport(1400,647,new OrthographicCamera());
        st =new Stage(viewport);

        txt = new Texture(Gdx.files.internal("room.png"));
        Image img = new Image(txt);
        st.addActor(img);

        aTank =  new Image(new Texture("abramstank.png"));
        aTank.setPosition(80,90);
        aTank.setSize(700,400);
        aTank.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        st.addActor(aTank);

        play =  new Image(new Texture("play.png"));
        play.setPosition(850,60);
        play.setSize(500,250);
        play.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                tankStars.setScreen(new Modes(tankStars));
            }
        });
        st.addActor(play);

        back =  new Image(new Texture("back.png"));
        back.setPosition(50,550);
        back.setSize(50,50);
        back.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                tankStars.setScreen(new Gameplay(tankStars));
            }
        });
        st.addActor(back);

        fTank1 =  new Image(new Texture("frosttank1.png"));
        fTank1.setPosition(780,250);
        fTank1.setSize(300,150);
        fTank1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(i==1){
                    fTank.remove();
                }
                else if(i==0) {
                    aTank.remove();
                }
                else if(i==2){
                    bTank.remove();
                }
                i=1;
                fTank =  new Image(new Texture("frosttank.png"));
                fTank.setPosition(30,50);
                fTank.setSize(810,450);
                fTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(fTank);
            }
        });
        st.addActor(fTank1);

        aTank1 =  new Image(new Texture("abramstank1.png"));
        aTank1.setPosition(950,250);
        aTank1.setSize(300,150);
        aTank1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(i==0){
                    aTank.remove();
                }
                else if(i==1) {
                    fTank.remove();
                }
                else if(i==2){
                    bTank.remove();
                }
                i=0;
                aTank =  new Image(new Texture("abramstank.png"));
                aTank.setPosition(80,90);
                aTank.setSize(700,400);
                aTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(aTank);
            }
        });
        st.addActor(aTank1);

        bTank1 =  new Image(new Texture("buratinotank1.png"));
        bTank1.setPosition(1120,250);
        bTank1.setSize(300,150);
        bTank1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(i==2){
                    bTank.remove();
                }
                if(i==0) {
                    aTank.remove();
                }
                else if(i==1){
                    fTank.remove();
                }
                i=2;
                bTank =  new Image(new Texture("buranitotank.png"));
                bTank.setPosition(80,65);
                bTank.setSize(700,400);
                bTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(bTank);

            }
        });
        st.addActor(bTank1);
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
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


    @Override
    public void show() {

    }

    @Override
    public void dispose() {

    }
}