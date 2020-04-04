package ru.geekbrains.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import com.arcan.base.Sprite;
import com.arcan.exception.GameException;

public class Logo extends Sprite {
    //    private static final float V_LEN = 0.001f;
    private Vector2 velocity;
    private Vector2 destination;

//    private Vector2 tmp;

    public Logo(Texture texture) throws GameException {
        super(new TextureRegion(texture));
        setHeightProportion(0.25f);
        velocity = new Vector2();
        destination = new Vector2();
//        tmp = new Vector2();

    }

    @Override
    public void update(float delta) {

        if (roundTwo(pos.x) != roundTwo(destination.y) && roundTwo(pos.y) != roundTwo(destination.y)) {
            pos.mulAdd(velocity, delta);
        }else {
            pos.set(destination);
            velocity.set(destination);
        }



//        tmp.set(destination);
//        float remainingDistance = (tmp.sub(pos)).len();
//        System.out.println(remainingDistance);
//        if (remainingDistance > V_LEN) {
//            pos.add(velocity);
//        } else {
//            velocity.setZero();
//            pos.set(destination);
//        }

    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        destination.set(touch);
        velocity.set(touch.sub(pos));

        System.out.print("DE");
        System.out.println(destination);
        System.out.print("VE");
        System.out.println(velocity);
//        velocity.set(touch.cpy().sub(pos)).setLength(V_LEN);
        System.out.println(pos.len());
        System.out.println(velocity.len());
        return false;
    }

    private float roundTwo(float number) {
        return Math.round(number * 100) / 100.0f;
    }


}

