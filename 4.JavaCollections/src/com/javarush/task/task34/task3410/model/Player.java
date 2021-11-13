package com.javarush.task.task34.task3410.model;

import java.awt.*;

public class Player extends CollisionObject implements Movable {
    public Player(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.YELLOW);
        int x = getX() - (getWidth() / 2);
        int y = getY() - (getHeight() / 2);
        int radius = getHeight();
        graphics.drawOval(x, y, radius, radius);
        graphics.fillOval(x, y, radius, radius);
    }

    @Override
    public void move(int x, int y) {
        setX(getX() + x);
        setY(getY() + y);
    }
}

//Для того чтобы проверить как рисуется твой ящик или игрок,
// ты можешь создать объект типа Box или Player в методе paint() класса Field и вызвать у объекта метод draw().
// Сделай это исключительно для проверки методов draw(), в дальнейшем метод paint() мы реализуем иначе.
//
//
//Requirements:
//1. Создай класс игрока Player и класс ящика Box в пакете model. Каждый из них унаследуй от максимально подходящего класса.
//2. Классы Player и Box должны поддерживать интерфейс, отвечающий за движение объектов.
//3. Добавь в классы Player и Box конструкторы, принимающие int x и int y.
//4. В классах Player и Box реализуй метод, отвечающий за движение. Он должен смещать координаты объектов (x и y) на переданные значения.
//5. В классах Player и Box реализуй метод, отвечающий за отрисовку.