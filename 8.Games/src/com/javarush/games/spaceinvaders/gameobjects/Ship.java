package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ship extends GameObject {

    public boolean isAlive = true;

    private List<int[][]> frames;
    private int frameIndex = 0;
    private boolean loopAnimation = false;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        setMatrix(viewFrame);
        frames = new ArrayList<>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;
        setMatrix(viewFrames[0]);
    }

    public void nextFrame() {
        frameIndex++;
        if (frameIndex >= frames.size() && loopAnimation) {
            frameIndex = 0;
        }
        if (frameIndex < frames.size()) {
            matrix = frames.get(frameIndex);
        }
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public boolean isVisible() {
        return isAlive || frameIndex < frames.size();
    }
}


