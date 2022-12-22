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

public class Tanks1 implements Screen {
    private final MyOwnGame tankStars;
    private Stage st;
    private Texture txt;
    private Viewport viewport;
    private Image aTank,fTank,bTank,aTank1,fTank1,bTank1,aTank2,fTank2,bTank2,p1,p2,pt1,pt2,back,play;
    private int  i = 0, j = -1;
    public Tanks1(final MyOwnGame tankStars) {
        this.tankStars = tankStars;
        viewport = new FillViewport(MyOwnGame.V_WIDTH,MyOwnGame.V_HEIGHT,new OrthographicCamera());
        st =new Stage(viewport);

        txt = new Texture(Gdx.files.internal("room.png"));
        Image img = new Image(txt);
        st.addActor(img);

        aTank =  new Image(new Texture("AbramsTank.png"));
        aTank.setPosition(80,90);
        aTank.setSize(700,400);
        aTank.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        st.addActor(aTank);

        aTank2 =  new Image(new Texture("abramslogo.png"));
        aTank2.setPosition(120,350);
        aTank2.setSize(500,350);
        aTank2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        st.addActor(aTank2);

        pt1 =  new Image(new Texture("play.png"));
        pt1.setPosition(870,80);
        pt1.setSize(400,200);
        pt1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                pt1.remove();

                pt2 =  new Image(new Texture("play.png"));
                pt2.setPosition(870,80);
                pt2.setSize(400,200);
                pt2.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        play =  new Image(new Texture("play.png"));
                        play.setPosition(870,80);
                        play.setSize(400,200);
                        play.addListener(new ClickListener(){
                            @Override
                            public void clicked(InputEvent event, float x, float y) {
                                tankStars.setScreen(new Modes(tankStars));
                            }
                        });
                        st.addActor(play);
                    }
                });
                st.addActor(pt2);
                j=1;
                p2 =  new Image(new Texture("p2.png"));
                p2.setPosition(928,235);
                p2.setSize(350,180);
                p2.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(p2);
            }
        });
        st.addActor(pt1);

        p1 =  new Image(new Texture("pl1 .png"));
        p1.setPosition(928,235);
        p1.setSize(350,180);
        p1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        st.addActor(p1);

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
                if(j==-1) {
                    if (i == 1) {
                        fTank.remove();
                    } else if (i == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (i == 2) {
                        bTank.remove();
                    }
                    i = 1;
                    p1.setPosition(758,235);
                }
                else{
                    if (j == 1) {
                        fTank.remove();
                        fTank2.remove();
                    } else if (j == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (j == 2) {
                        bTank.remove();
                        bTank2.remove();
                    }
                    j = 1;
                    p2.setPosition(758,235);
                }
                fTank =  new Image(new Texture("frosttank.png"));
                fTank.setPosition(30,50);
                fTank.setSize(810,450);
                fTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(fTank);
                fTank2 =  new Image(new Texture("frostlogo.png"));
                fTank2.setPosition(120,350);
                fTank2.setSize(500,350);
                fTank2.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(fTank2);
            }
        });
        st.addActor(fTank1);

        aTank1 =  new Image(new Texture("abramstank1.png"));
        aTank1.setPosition(950,250);
        aTank1.setSize(300,150);
        aTank1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(j==-1) {
                    if (i == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (i == 1) {
                        fTank.remove();
                        fTank2.remove();
                    } else if (i == 2) {
                        bTank.remove();
                        bTank2.remove();
                    }
                    i = 0;
                    p1.setPosition(928,235);
                }
                else{
                    if (j == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (j == 1) {
                        fTank.remove();
                        fTank2.remove();
                    } else if (j == 2) {
                        bTank.remove();
                        bTank2.remove();
                    }
                    j = 0;
                    p2.setPosition(928,235);
                }

                aTank =  new Image(new Texture("abramstank.png"));
                aTank.setPosition(80,90);
                aTank.setSize(700,400);
                aTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(aTank);

                aTank2 =  new Image(new Texture("abramslogo.png"));
                aTank2.setPosition(120,350);
                aTank2.setSize(500,350);
                aTank2.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(aTank2);
            }
        });
        st.addActor(aTank1);

        bTank1 =  new Image(new Texture("buratinotank1.png"));
        bTank1.setPosition(1120,250);
        bTank1.setSize(300,150);
        bTank1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(j==-1) {
                    if (i == 2) {
                        bTank.remove();
                        bTank2.remove();
                    }
                    else if (i == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (i == 1) {
                        fTank.remove();
                        fTank2.remove();
                    }
                    p1.setPosition(1098, 235);
                    i = 2;
                }
                else{
                    if (j == 2) {
                        bTank.remove();
                        bTank2.remove();
                    }
                    else if (j == 0) {
                        aTank.remove();
                        aTank2.remove();
                    } else if (j == 1) {
                        fTank.remove();
                        fTank2.remove();
                    }
                    p2.setPosition(1098, 235);
                    j = 2;
                }
                bTank =  new Image(new Texture("buranitotank.png"));
                bTank.setPosition(80,65);
                bTank.setSize(700,400);
                bTank.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(bTank);

                bTank2 =  new Image(new Texture("buratinologo.png"));
                bTank2.setPosition(120,350);
                bTank2.setSize(500,350);
                bTank2.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {

                    }
                });
                st.addActor(bTank2);

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