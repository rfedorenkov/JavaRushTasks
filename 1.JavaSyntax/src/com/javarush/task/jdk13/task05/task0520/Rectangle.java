package com.javarush.task.jdk13.task05.task0520;

/**
 * Заполнить класс прямоугольник (Rectangle)
 * Параметрами прямоугольника (класс Rectangle) будут
 * top, left, width, height (верхняя координата, левая, ширина и высота).
 * Создай для него как можно больше методов конструкторов.
 *
 * Примеры:
 *
 * заданы 4 параметра: left, top, width, height;
 * ширина/высота не задана (оба равны 0);
 * высота не задана (равна ширине) - создаём квадрат;
 * создаём копию другого прямоугольника (он и передаётся в параметрах).
 *
 * Требования:
 * 1. У класса Rectangle должны быть переменные top, left, width и height с типом int.
 * 2. У класса должен быть хотя бы один конструктор.
 * 3. У класса должно быть хотя бы два конструктора.
 * 4. У класса должно быть хотя бы три конструктора.
 * 5. У класса должно быть хотя бы четыре конструктора.
*/


public class Rectangle {
    int top;
    int left;
    int width;
    int height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left) {
        this(top, left, 0, 0);
    }

    public Rectangle(int top, int left, int width) {
        this(top, left, width, width);
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.top, rectangle.left, rectangle.width, rectangle.height);
    }

    public static void main(String[] args) {

    }
}
