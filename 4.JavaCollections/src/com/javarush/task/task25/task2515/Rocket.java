package com.javarush.task.task25.task2515;

/**
 * Класс ракеты.
 */
public class Rocket extends BaseObject {

    /**
     * Конструктор объекта.
     * При создании устанавливается параметр isAlive = true.
     *
     * @param x      Координата 'x'
     * @param y      Координата 'y'
     */
    public Rocket(double x, double y) {
        super(x, y, 1);
    }

    @Override
    public void move() {
        y--;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.setPoint(x, y, 'R');
    }
}