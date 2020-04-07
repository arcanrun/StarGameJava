package com.arcan.pool;

import com.arcan.base.SpritesPool;
import com.arcan.sprites.Bullet;

public class BulletPool extends SpritesPool<Bullet> {

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
