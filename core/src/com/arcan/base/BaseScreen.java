package com.arcan.base;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class BaseScreen implements Screen {
    protected SpriteBatch batch;
    protected abstract void update(float dt);
}
