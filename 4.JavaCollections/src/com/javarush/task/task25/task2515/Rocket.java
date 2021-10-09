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
     * @param radius Радиус
     */
    public Rocket(double x, double y, double radius) {
        super(x, y, radius);
    }
}
