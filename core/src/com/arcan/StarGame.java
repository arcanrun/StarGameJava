package com.arcan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import javax.xml.soap.Text;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Texture bgImg;
	@Override
	public void create () {
		batch = new SpriteBatch();
		bgImg = new Texture("space-bg.jpg");
		background = new Background(bgImg);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		bgImg.dispose();
	}
}
