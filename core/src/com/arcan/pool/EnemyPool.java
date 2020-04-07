package com.arcan.pool;

import com.arcan.base.SpritesPool;
import com.arcan.sprites.Bullet;
import com.arcan.sprites.Enemy;

public class EnemyPool extends SpritesPool<Enemy> {

    @Override
    protected Enemy newObject() {
        return new Enemy();
    }
}
