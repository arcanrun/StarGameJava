package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.arcan.exception.GameException;
import com.arcan.math.Rect;
import com.arcan.base.Sprite;

public class Background extends Sprite {

    public Background(Texture texture) throws GameException {
        super(new TextureRegion(texture));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(1f);
        pos.set(worldBounds.pos);
    }
}
