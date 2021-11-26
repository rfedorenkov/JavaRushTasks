package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

import static com.javarush.games.spaceinvaders.ShapeMatrix.*;

public class EnemyShip extends Ship {

    public int score = 15;

    public EnemyShip(double x, double y) {
        super(x, y);
        setStaticView(ShapeMatrix.ENEMY);
    }

    public void move(Direction direction, double speed) {
        if (direction == Direction.RIGHT) {
            x += speed;
        } else if (direction == Direction.LEFT) {
            x -= speed;
        } else if (direction == Direction.DOWN) {
            y += 2;
        }
    }

    @Override
    public Bullet fire() {
        return new Bullet(x + 1, y + height, Direction.DOWN);
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            setAnimatedView(false, KILL_ENEMY_ANIMATION_FIRST, KILL_ENEMY_ANIMATION_SECOND, KILL_ENEMY_ANIMATION_THIRD);
        }
    }
}