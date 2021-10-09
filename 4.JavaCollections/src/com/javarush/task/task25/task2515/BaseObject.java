package com.javarush.task.task25.task2515;

/**
 * Базовый класс.
 */
public abstract class BaseObject {
    // Координата 'x'
    private double x;
    // Координата 'y'
    private double y;
    // Радиус
    private double radius;

    // Объект жив или уже нет
    private boolean isAlive;

    /**
     * Конструктор объекта.
     * При создании устанавливается параметр isAlive = true.
     *
     * @param x Координата 'x'
     * @param y Координата 'y'
     * @param radius Радиус
     */
    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        isAlive = true;
    }

    /**
     * Геттер координаты 'x'.
     *
     * @return x.
     */
    public double getX() {
        return x;
    }

    /**
     * Геттер координаты 'x'.
     *
     * @param x Координата 'x'.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Геттер координаты 'y'.
     *
     * @return x.
     */
    public double getY() {
        return y;
    }

    /**
     * Геттер координаты 'y'.
     *
     * @param y Координата 'y'.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Геттер радиуса.
     *
     * @return radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Сеттер радиуса.
     *
     * @param radius Радиус.
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Проверяет жив ли объект.
     * @return true если объект жив.
     */
    public boolean isAlive() {
        return isAlive;
    }
}