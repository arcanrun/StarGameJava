package ru.geekbrains.utils;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.math.Rect;
import ru.geekbrains.pool.BonusPool;
import ru.geekbrains.sprites.Bonus;

public class BonusEmitter {
    private BonusPool bonusPool;
    private TextureAtlas atlas;
    private TextureRegion texure;
    private Bonus.BonusType bonusType;
    private final float HEIGHT;
    private Rect worldBounds;
    private int bonusValue;

    public BonusEmitter(BonusPool bonusPool, TextureAtlas atlas, Rect worldBounds) {
        this.bonusPool = bonusPool;
        this.atlas = atlas;
        this.HEIGHT = 0.05f;
        this.worldBounds = worldBounds;


    }

    public void generate(Vector2 pos) {
        Bonus bonus = bonusPool.obtain();

        bonusType = Bonus.BonusType.values()[
                MathUtils.random(
                        0,
                        Bonus.BonusType.values().length - 1)
                ];
        switch (bonusType) {
            case HP:
                texure = atlas.findRegion("hospital");
                bonusValue = MathUtils.random(5, 50);
                break;
            case AMMO:
                texure = atlas.findRegion("bullet");
                bonusValue = MathUtils.random(1, 5);
                break;
            case SCORE:
                texure = atlas.findRegion("coin");
                bonusValue = MathUtils.random(50, 200);
                break;

        }

        bonus.set(texure, pos, new Vector2(0, -0.4f), HEIGHT, worldBounds, bonusValue, bonusType);
    }


}
