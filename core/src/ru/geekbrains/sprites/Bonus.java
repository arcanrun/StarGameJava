package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.geekbrains.base.Sprite;
import ru.geekbrains.math.Rect;

public class Bonus extends Sprite {

    public static enum BonusType{HP, AMMO, SCORE};

    private Rect worldBounds;
    private final Vector2 v = new Vector2();
    private int bonusValue;
    private BonusType bonusType;


    public Bonus() {
        regions = new TextureRegion[1];
    }

    public BonusType getBonusType(){
        return  bonusType;
    }

    public int getBonusValue(){
        return bonusValue;
    }
    public void set(
            TextureRegion region,
            Vector2 pos0,
            Vector2 v0,
            float height,
            Rect worldBounds,
            int bonusValue,
            BonusType bonusType
    ) {
        this.regions[0] = region;
        this.pos.set(pos0);
        this.v.set(v0);
        this.worldBounds = worldBounds;
        this.bonusValue = bonusValue;
        this.bonusType = bonusType;
        setHeightProportion(height);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if (isOutside(worldBounds)) {
            destroy();
        }
    }


}
