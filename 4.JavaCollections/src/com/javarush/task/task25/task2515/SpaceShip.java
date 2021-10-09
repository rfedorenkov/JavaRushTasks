package com.javarush.task.task25.task2515;

/**
 * Класс космического корабля, который стреляет ракетами в НЛО.
 */
public class SpaceShip extends BaseObject {

    /**
     * Конструктор объекта.
     * При создании устанавливается параметр isAlive = true.
     *
     * @param x      Координата 'x'
     * @param y      Координата 'y'
     * @param radius Радиус
     */
    public SpaceShip(double x, double y, double radius) {
        super(x, y, radius);
    }
}
