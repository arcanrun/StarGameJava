package com.arcan.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Planet {
    private Texture spaceShip;

    private Vector2 position;
    //    private Vector2 dest;
    int mouseX;
    int mouseY;


    public Planet(SpriteBatch batch) {
        spaceShip = new Texture("saturn.png");
        position = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
//        dest  = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        mouseX = Gdx.graphics.getWidth() / 2;
        mouseY = Gdx.graphics.getHeight() / 2;

    }


    public void render(SpriteBatch batch) {
        batch.draw(spaceShip, position.x - 32, position.y - 32);
    }

    public void update(float dt) {
        if (Gdx.input.isTouched()) {
            mouseX = Gdx.input.getX();
            mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        }


        float pathX = mouseX - position.x;
        float pathY = mouseY - position.y;

        float distance = (float) Math.sqrt(pathX * pathX + pathY * pathY);
        float directionX = pathX / distance;
        float directionY = pathY / distance;

        if ((int)position.x != (int)mouseX & position.y != (int)mouseY){
            position.x += directionX * 200f * dt;
            position.y += directionY * 200f * dt;
        }



    }


}
