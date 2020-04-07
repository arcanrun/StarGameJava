package com.arcan.sprites;

import com.arcan.base.Sprite;
import com.arcan.exception.GameException;
import com.arcan.math.Rect;
import com.arcan.pool.BulletPool;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Sprite {
    Rect worldBounds;
    Vector2 v;

    public Enemy() {
        regions = new TextureRegion[1];
        v = new Vector2();
    }


    public void set(
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds

    ) {

        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        setHeightProportion(height);
        this.worldBounds = worldBounds;

    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (pos.y < -1f) {
            destroy();
        }

    }
}
