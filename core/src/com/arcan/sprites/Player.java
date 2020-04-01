package com.arcan.sprites;


import com.arcan.base.Sprite;
import com.arcan.exception.GameException;
import com.arcan.math.Rect;
import com.arcan.math.Rnd;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {


    private Vector2 velocity;
    private Rect worldBounds;

    public Player(TextureAtlas atlas) throws GameException {
        super(new TextureRegion(atlas.findRegion("main_ship"), 0, 0, 200, 300));
        velocity = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {

        setHeightProportion(0.15f);
        this.pos.set(0, worldBounds.getBottom() + 0.2f);
        this.worldBounds = worldBounds;


    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        velocity.set(touch);
        return false;
    }

    @Override
    public void update(float dt) {
        pos.x += velocity.x * dt;
        if (pos.x - 0.05f <= worldBounds.getLeft()) {
            pos.x = worldBounds.getLeft() + 0.05f;
            velocity.setZero();
        }
        if (pos.x + 0.05f >= worldBounds.getRight()) {
            pos.x = worldBounds.getRight() - 0.05f;
            velocity.setZero();
        }


        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.setZero();
            pos.x -= 0.3f * dt;
            if (pos.x - 0.05f <= worldBounds.getLeft()) {
                pos.x = worldBounds.getLeft() + 0.05f;

            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.setZero();
            pos.x += 0.3f * dt;
            if (pos.x + 0.05f >= worldBounds.getRight()) {
                pos.x = worldBounds.getRight() - 0.05f;

            }

        }
        velocity.scl(0.99f);


    }
}


