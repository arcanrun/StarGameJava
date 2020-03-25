package com.arcan.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Planet {
    private Texture spaceShip;

    private Vector2 position;
    private Vector2 dest;


    public Planet(SpriteBatch batch) {
        spaceShip = new Texture("saturn.png");
        position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        dest = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);


    }


    public void render(SpriteBatch batch) {
        batch.draw(spaceShip, position.x - 32, position.y - 32);
    }

    public void update(float dt) {
        if (Gdx.input.isTouched()) {
            dest.x = Gdx.input.getX();
            dest.y = Gdx.graphics.getHeight() - Gdx.input.getY();
        }


        float pathX = dest.x - position.x;
        float pathY = dest.y - position.y;

        float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY);
        float directionX = pathX / distance;
        float directionY = pathY / distance;

        if ((int)position.x != (int)dest.x & (int)position.y != (int)dest.y){
            position.x += directionX * 300f * dt;
            position.y += directionY * 300f * dt;


        }



    }


}
