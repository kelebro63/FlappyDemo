package com.kelebro63.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;


/**
 * Created by Bistrov Alexey on 30.08.2016.
 */
public class Bird {
    public static final int GRAVITY = -15;
    private Vector3 position;
    private Vector3 velosity;

    private Texture bird;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velosity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");
    }

    public  void update(float dt) {
        System.out.println("1 velosity.y =  " + velosity.y + ",  position.y =  " + position.y);
        if (position.y > 0) {
            velosity.add(0, GRAVITY, 0);
        }

        velosity.scl(dt);
        position.add(0, velosity.y, 0);
        System.out.println("2 velosity.y =  " + velosity.y + ",  position.y =  " + position.y);
        if (position.y < 0) {
            position.y = 0;
        }
        velosity.scl(1 / dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    public void jump() {
     velosity.y = 250;
    }
}
