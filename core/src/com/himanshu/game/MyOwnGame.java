package com.himanshu.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MyOwnGame extends Game {
	public static final int V_WIDTH = 1400;
	public static final int V_HEIGHT = 647;
	Stage st;

	public void create() {
		st = new Stage(new ScreenViewport());
		this.setScreen(new MainScreen(this));
	}

	public void dispose() {
		st.dispose();
	}

	public void render() {
		super.render();
	}

}

