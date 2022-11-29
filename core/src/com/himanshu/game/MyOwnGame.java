package com.himanshu.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyOwnGame extends Game {
	SpriteBatch batch;
	Texture img, img2, img3, img4;
	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("BlueNight.png");
		img2 = new Texture("GroundG.png");
		img3 = new Texture("Abrams.png");
		img4 = new Texture("image.png");

	}

	@Override
	public void render () {
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img2, 0, 0);
		batch.draw(img3, 0, 0);
		batch.draw(img4, 600, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		img2.dispose();
		img3.dispose();
		img4.dispose();
	}
}
