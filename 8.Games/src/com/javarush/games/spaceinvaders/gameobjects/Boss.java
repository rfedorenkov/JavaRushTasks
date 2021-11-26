package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;

import static com.javarush.games.spaceinvaders.ShapeMatrix.*;

public class Boss extends EnemyShip {

    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        setAnimatedView(true, BOSS_ANIMATION_FIRST, BOSS_ANIMATION_SECOND);
        score = 100;
    }

    @Override
    public void nextFrame() {
        frameCount++;
        if (frameCount % 10 == 0 || !isAlive) {
            super.nextFrame();
        }
    }

    @Override
    public Bullet fire() {
        if (isAlive) {
            double dx = matrix == BOSS_ANIMATION_FIRST ? x + 6 : x;
            double dy = y + height;
            return new Bullet(dx, dy, Direction.DOWN);
        }
        return null;
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            setAnimatedView(false, KILL_BOSS_ANIMATION_FIRST, KILL_BOSS_ANIMATION_SECOND, KILL_BOSS_ANIMATION_THIRD);
        }
    }
}