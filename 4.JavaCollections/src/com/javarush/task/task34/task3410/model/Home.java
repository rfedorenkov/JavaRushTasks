package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Home extends GameObject {
    public Home(int x, int y) {
        super(x, y);
        setWidth(2);
        setHeight(2);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        int x = getX() - (getWidth() / 2);
        int y = getY() - (getHeight() / 2);
        int radius = getHeight();
        graphics.drawOval(x, y, radius, radius);
    }
}