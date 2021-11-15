package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.ORANGE);
        int x = getX() - (getWidth() / 2);
        int y = getY() - (getHeight() / 2);
        graphics.fillRect(x, y, getWidth(), getHeight());
        graphics.setColor(Color.BLACK);
        graphics.drawRect(x, y, getWidth(), getHeight());
        graphics.drawLine(x, y, x + getWidth(), y + getHeight());
        graphics.drawLine(x + getWidth(), y, x, y + getHeight());
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}
