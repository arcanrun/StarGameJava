package com.arcan;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background {
    Texture bgImg;

    public Background(Texture bgImg) {
        this.bgImg = bgImg;
    }

    public void render(SpriteBatch batch){
        batch.draw(bgImg, 0 , 0);
    }
}
