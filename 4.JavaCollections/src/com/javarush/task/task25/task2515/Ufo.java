package com.javarush.task.task25.task2515;

/**
 * Класс НЛО, который сбрасывает на космический корабль бомбы.
 */
public class Ufo extends BaseObject {

    /**
     * Конструктор объекта.
     * При создании устанавливается параметр isAlive = true.
     *
     * @param x      Координата 'x'
     * @param y      Координата 'y'
     * @param radius Радиус
     */
    public Ufo(double x, double y, double radius) {
        super(x, y, radius);
    }
}
