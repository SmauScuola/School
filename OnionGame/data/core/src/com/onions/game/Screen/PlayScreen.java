package com.onions.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.onions.game.MainClass;

public class PlayScreen implements Screen {
		
	private MainClass Game;
	Texture background;
	
	private OrthographicCamera gamecam;
	private Viewport viewPort;
	
	public PlayScreen(MainClass game) {
		Game = game;
		
		gamecam = new OrthographicCamera();
		gamecam.position.x = 0;
		gamecam.position.y = 0;
		viewPort = new FitViewport(Game.SCREEN_W, Game.SCREEN_H, gamecam);
		
		background = new Texture("background.jpg");
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		Game.batch.begin();
		Game.batch.draw(background, 0, 0, 10, 10);
		Game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}

}
