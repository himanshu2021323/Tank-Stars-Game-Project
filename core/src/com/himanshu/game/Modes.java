package com.himanshu.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJoint;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;




public class Modes implements Screen {
    private MyOwnGame tankStars;
    private Texture txt;
    private Viewport viewport;
    private OrthographicCamera cam;

    private Skin sk;
    private Sound sd;
    private Stage st;
    private World wd;
    private Body box, box1;
    private Image rm,set,set1,save,closemusic,ext,b1,b2;
    private Box2DDebugRenderer rd;
    private float speed=1.25f;
    private SpriteBatch batch;
    private Sprite bs,bs1;
    private final int A=8,B=3;
    private final float C=1/60f;
    private Vector2 mv=new Vector2();
    private Vector2 f = new Vector2();
    private Vector2 mv1=new Vector2();
    private Vector2 f1 = new Vector2();
    private int h1=10,h2=10;
    public static int flag;
    private int x=300,y=300;

    private Array<Body> list=new Array<Body>();
    public Modes(final MyOwnGame tankStars) {
        this.tankStars=tankStars;
        viewport = new FillViewport(1400,647,new OrthographicCamera());
        st =new Stage(viewport);

        sd = Gdx.audio.newSound(Gdx.files.internal("SoundEffects.mp3"));
        sd.play();

        txt = new Texture(Gdx.files.internal("playbg.png"));
        Image img = new Image(txt);
        st.addActor(img);

        b1=new Image(new Texture("healthbar.png"));
        b1.setPosition(300,550);
        b1.setSize(300, 100);
        st.addActor(b1);

        b2=new Image(new Texture("healthbar1.png"));
        b2.setPosition(800,550);
        b2.setSize(300, 100);
        st.addActor(b2);

        set = new Image(new Texture("6.png"));
        set.setPosition(0,550);
        set.setSize(100, 50);
        set.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                set1 = new Image(new Texture("resumebg.png"));
                set1.setPosition(500,25);
                set1.setSize(500,600);
                st.addActor(set1);

                rm = new Image(new Texture("rename.png"));
                rm.setPosition(580,400);
                rm.setSize(300, 200);
                rm.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        tankStars.setScreen(new Modes(tankStars));
                    }
                });
                st.addActor(rm);

                ext = new Image(new Texture("exitg.png"));
                ext.setPosition(580,290);
                ext.setSize(300, 200);
                ext.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        sd.pause();
                        tankStars.setScreen(new Gameplay(tankStars));
                    }
                });
                st.addActor(ext);

                save = new Image(new Texture("saveandexit.png"));
                save.setPosition(580,180);
                save.setSize(300, 200);
                save.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        sd.pause();
                        tankStars.setScreen(new Gameplay(tankStars));
                    }
                });
                st.addActor(save);

                closemusic = new Image(new Texture("musicoff.png"));
                closemusic.setPosition(580,70);
                closemusic.setSize(300, 200);
                closemusic.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        sd.pause();
                    }
                });
                st.addActor(closemusic);
            }
        });
        st.addActor(set);

        Gdx.input.setInputProcessor(st);
    }

    @Override
    public void show() {
        wd=new World(new Vector2(0,-50),true);
        rd=new Box2DDebugRenderer();
        batch =new SpriteBatch();
        cam = new OrthographicCamera(Gdx.graphics.getWidth()/100, Gdx.graphics.getHeight()/100);

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyUp(int keycode) {
                switch (keycode){

                    case Input.Keys.W:

                    case Input.Keys.A:
                        mv.x=0;
                        break;
                    case Input.Keys.S:
                        mv.x=0;
                        break;
                    case Input.Keys.D:
                        fire();
                        break;
                    case Input.Keys.UP:
                        fire2();
                        break;
                    case Input.Keys.LEFT:
                        mv1.x=0;
                        break;
                    case Input.Keys.RIGHT:
                        mv1.x=0;
                        break;
                }
                return true;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }

            @Override
            public boolean keyDown(int keycode) {
                switch (keycode){
                    case Input.Keys.ESCAPE:
                        tankStars.setScreen(new Gameplay(tankStars));
                        break;
                    case Input.Keys.W:
                        break;
                    case Input.Keys.A:
                        mv.x=-speed;
                        break;
                    case Input.Keys.S:
                        mv.x=speed;
                        break;
                    case Input.Keys.LEFT:
                        mv1.x=-speed;
                        break;
                    case Input.Keys.RIGHT:
                        mv1.x=speed;
                        break;
                }
                return true;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }
        });

        BodyDef body=new BodyDef();
        FixtureDef fix =new FixtureDef();


        body.type= BodyDef.BodyType.StaticBody;
        body.position.set(0,0);

        ChainShape gs=new ChainShape();
        gs.createChain(new Vector2[]{new Vector2(-7,10),new Vector2(-7,-.7f),new Vector2(-6.8f,-.7f),new Vector2(-6.1f,-.1f),new Vector2(-5.1f,-.1f),new Vector2(-3.95f,-1.45f),new Vector2(-1.7f,-1.45f),new Vector2(-1f,-1.9f),new Vector2(0.95f,-1.9f),new Vector2(1.7f,-1.45f),new Vector2(4,-1.45f),new Vector2(5,-.1f),new Vector2(6.2f,-.1f),new Vector2(6.8f,-.6f),new Vector2(7,-.6f),new Vector2(7,10)});
        fix.shape=gs;
        fix.friction=0f;
        fix.restitution=0;

        wd.createBody(body).createFixture(fix);

        gs.dispose();

        body.type= BodyDef.BodyType.DynamicBody;
        body.position.set(-5.8f,0);

        PolygonShape shape1=new PolygonShape();
        shape1.setAsBox(0.4f,0.2f);

        fix.shape=shape1;
        fix.friction=0;
        fix.restitution=0;
        fix.density=10;

        box=wd.createBody(body);
        box.createFixture(fix);

        bs=new Sprite(new Texture("abramstank.png"));
        bs.setSize(1.2f,0.6f);
        bs.setOrigin(bs.getWidth()/2,bs.getHeight()/2);

        box.setUserData(bs);
        shape1.dispose();

        body.type= BodyDef.BodyType.DynamicBody;
        body.position.set(5.8f,0);

        PolygonShape tank2=new PolygonShape();
        tank2.setAsBox(0.4f,0.2f);

        fix.shape=tank2;
        fix.friction=0;
        fix.restitution=0;
        fix.density=10;

        box1=wd.createBody(body);
        box1.createFixture(fix);

        bs1=new Sprite(new Texture("abramstank.png"));
        bs1.flip(true,false);
        bs1.setSize(1.2f,0.6f);
        bs1.setOrigin(bs1.getWidth()/2,bs1.getHeight()/2);

        box1.setUserData(bs1);
        tank2.dispose();

        CircleShape bullet=new CircleShape();
        bullet.setRadius(0.1f);

        body.type= BodyDef.BodyType.DynamicBody;
        fix.friction=0;
        body.position.set(-5.4f,0);

        fix.restitution=0;
        fix.density=0;
        fix.shape = bullet;

        bulletbd =  wd.createBody(body);
        bulletbd.createFixture(fix);

        PrismaticJointDef defJoint = new PrismaticJointDef ();
        defJoint.initialize(box, bulletbd,new Vector2(0,0),new Vector2(-2, 1));

        bulletJoint = (PrismaticJoint) wd.createJoint(defJoint);
        bulletJoint.setLimits(0,0);
        bulletJoint.enableLimit(true);
        bullet.dispose();

        CircleShape bullet2=new CircleShape();
        bullet2.setRadius(0.1f);

        body.type= BodyDef.BodyType.DynamicBody;
        fix.friction=0;
        body.position.set(5.4f,0);
        fix.restitution=0;
        fix.density=0;
        fix.shape = bullet2;

        bulletbd2 =  wd.createBody(body);
        bulletbd2.createFixture(fix);

        PrismaticJointDef defJoint2 = new PrismaticJointDef ();
        defJoint2.initialize(box1, bulletbd2,new Vector2(0,0),new Vector2(2, 1));

        bulletJoint2 = (PrismaticJoint) wd.createJoint(defJoint2);
        bulletJoint2.setLimits(0,0);
        bulletJoint2.enableLimit(true);
        bullet2.dispose();

    }
    PrismaticJoint bulletJoint, bulletJoint2;
    Body bulletbd, bulletbd2;
    void fire(){
        h1--;
        x=x-30;
        b1.setSize(x,100);

        System.out.println("h1;"+h1);
        if(h1<=0){
            flag=2;
            tankStars.setScreen(new Win(tankStars));
        }
        wd.destroyJoint(bulletJoint);
        bulletbd.setLinearVelocity(50,2f);

        BodyDef body=new BodyDef();
        FixtureDef fix =new FixtureDef();
        CircleShape bullet=new CircleShape();

        bullet.setRadius(0.1f);
        body.type= BodyDef.BodyType.DynamicBody;
        fix.friction=0;
        body.position.set(box.getPosition());

        fix.restitution=0;
        fix.density=0;
        fix.shape = bullet;

        bulletbd =  wd.createBody(body);
        bulletbd.createFixture(fix);

        PrismaticJointDef defJoint = new PrismaticJointDef ();
        defJoint.initialize(box, bulletbd,new Vector2(0,0),new Vector2(-2, 1));

        bulletJoint = (PrismaticJoint) wd.createJoint(defJoint);
        bulletJoint.setLimits(0,0);
        bulletJoint.enableLimit(true);
        bullet.dispose();
    }
    void fire2(){
        h2--;
        y=y-30;
        b2.setSize(y,100);

        System.out.println("h2:"+h2);
        if(h2<=0){
            flag=1;
            tankStars.setScreen(new Win(tankStars));
        }
        wd.destroyJoint(bulletJoint2);
        bulletbd2.setLinearVelocity(-50f,2f);

        BodyDef body=new BodyDef();
        FixtureDef fix =new FixtureDef();
        CircleShape bullet2=new CircleShape();

        bullet2.setRadius(0.1f);
        body.type= BodyDef.BodyType.DynamicBody;
        fix.friction=0;
        body.position.set(box1.getPosition());

        fix.restitution=0;
        fix.density=0;
        fix.shape = bullet2;

        bulletbd2 =  wd.createBody(body);
        bulletbd2.createFixture(fix);

        PrismaticJointDef defJoint2 = new PrismaticJointDef ();
        defJoint2.initialize(box1, bulletbd2,new Vector2(0,0),new Vector2(-2, 1));

        bulletJoint2 = (PrismaticJoint) wd.createJoint(defJoint2);
        bulletJoint2.setLimits(0,0);
        bulletJoint2.enableLimit(true);
        bullet2.dispose();
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        st.act(delta);
        st.draw();
        wd.step(C,A,B);
        box.applyForceToCenter(f,false);
        box.applyForceToCenter(f1,false);
        box.setLinearVelocity(mv);
        box1.setLinearVelocity(mv1);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        wd.getBodies(list);

        for(Body body:list){
            if(body.getUserData()!=null && body.getUserData() instanceof Sprite){
                Sprite sprite=(Sprite) body.getUserData();
                sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
                sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
                sprite.draw(batch);
            }
        }

        batch.end();
        rd.render(wd,cam.combined);

    }

    @Override
    public void pause() {

    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        st.dispose();
        wd.dispose();
        bs.getTexture().dispose();
        bs1.getTexture().dispose();
    }

    @Override
    public void hide() {
        dispose();
    }
}
