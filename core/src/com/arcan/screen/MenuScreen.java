package com.arcan.screen;

import com.arcan.base.BaseScreen;
import com.arcan.models.Planet;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Planet planet;

    @Override
    public void show() {
        bg = new Texture("space-bg.jpg");
        batch = new SpriteBatch();
        planet = new Planet(batch);
    }

    @Override
    public void render(float delta) {
        float dt = Gdx.graphics.getDeltaTime();
        update(dt);

        batch.begin();
        batch.draw(bg, 0, 0);
        planet.render(batch);
        batch.end();
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
        batch.dispose();
        bg.dispose();

    }

    @Override
    protected void update(float dt) {
        planet.update(dt);
    }
}
