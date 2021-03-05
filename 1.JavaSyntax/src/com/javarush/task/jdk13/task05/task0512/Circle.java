package com.javarush.task.jdk13.task05.task0512;

/**
 * Заполнить класс Circle
 * У круга (класс Circle) должно быть три инициализатора:
 *
 * centerX, centerY, radius;
 * centerX, centerY, radius, width;
 * centerX, centerY, radius, width, color.
 *
 * Требования:
 * 1. У класса Circle должны быть переменные centerX, centerY, radius, width и color с типом int.
 * 2. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY,
 * radius и инициализирующий соответствующие переменные класса.
 * 3. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY,
 * radius, width и инициализирующий соответствующие переменные класса.
 * 4. У класса должен быть метод initialize, принимающий в качестве параметров centerX, centerY,
 * radius, width, color и инициализирующий соответствующие переменные класса.
*/

public class Circle {
    //напишите тут ваш код
    int centerX;
    int centerY;
    int radius;
    int width;
    int color;

    public void initialize(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public void initialize(int centerX, int centerY, int radius, int width) {
        initialize(centerX, centerY, radius);
        this.width = width;
    }

    public void initialize(int centerX, int centerY, int radius, int width, int color) {
        initialize(centerX, centerY, radius, width);
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
