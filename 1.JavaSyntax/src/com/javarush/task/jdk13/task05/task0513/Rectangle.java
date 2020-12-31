package com.javarush.task.jdk13.task05.task0513;

/**
 * Собираем прямоугольник
 * Данными прямоугольника (класс Rectangle) будут top, left, width, height (верхняя координата, левая, ширина и высота).
 * Создай для него как можно больше методов initialize(…)
 *
 * Примеры:
 * заданы 4 параметра: left, top, width, height;
 * ширина/высота не задана (оба равны 0);
 * высота не задана (равна ширине) - создаём квадрат;
 * создаём копию другого прямоугольника (он и передаётся в параметрах).
 *
 * Требования:
 * 1. У класса Rectangle должны быть переменные top, left, width и height с типом int.
 * 2. У класса должен быть хотя бы один метод initialize.
 * 3. У класса должно быть хотя бы два метода initialize.
 * 4. У класса должно быть хотя бы три метода initialize.
 * 5. У класса должно быть хотя бы четыре метода initialize.
*/

public class Rectangle {
    int top;
    int left;
    int width;
    int height;

    public void initialize(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public void initialize(int left, int top) {
        this.left = left;
        this.top = top;
    }

    public void initialize(int left, int top, int width) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = width;
    }

    public void initialize(Rectangle rectangle) {
        this.left = rectangle.left;
        this.top = rectangle.top;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public static void main(String[] args) {

    }
}
