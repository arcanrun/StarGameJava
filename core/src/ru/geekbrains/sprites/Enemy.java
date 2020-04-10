package ru.geekbrains.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Ship;
import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BulletPool;

public class Enemy extends Ship {
    private static final Vector2 WARP_SPEED = new Vector2(0, -0.5f);
    private Circle hitArea;

    public Enemy(BulletPool bulletPool, Rect worldBounds) {

        this.bulletPool = bulletPool;
        this.worldBounds = worldBounds;
        v = new Vector2();
        v0 = new Vector2();
        bulletV = new Vector2();
        hitArea = new Circle();


    }
    public void takeDamage(int amount){
        hp -= amount;
        if(hp<=0) destroy();
    }


    public Circle getHitArea() {
        return hitArea;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (worldBounds.getTop() - getTop() > 0) {
            v.set(v0);
            if (reloadTimer >= reloadInterval) {
                reloadTimer = 0f;
                shoot();
            }
            reloadTimer += delta;
        }

        hitArea.setPosition(pos);
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int damage,
            float reloadInterval,
            Sound shootSound,
            int hp,
            float height
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0, bulletVY);
        this.damage = damage;
        this.reloadInterval = reloadInterval;
        this.reloadTimer = reloadInterval;
        this.shootSound = shootSound;
        this.hp = hp;
        this.v.set(WARP_SPEED);
        setHeightProportion(height);
        hitArea.setPosition(pos);
        hitArea.setRadius(getHalfWidth());
    }
}
