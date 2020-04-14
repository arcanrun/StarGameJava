package ru.geekbrains.pool;

import ru.geekbrains.base.SpritesPool;
import ru.geekbrains.sprites.Bonus;

public class BonusPool extends SpritesPool<Bonus> {

    @Override
    protected Bonus newObject() {
        return new Bonus();
    }
}
