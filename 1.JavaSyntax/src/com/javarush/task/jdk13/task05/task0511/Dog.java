package com.javarush.task.jdk13.task05.task0511;

/**
 * Заполнить класс Dog
 * У собаки (класс Dog) должно быть три инициализатора:
 *
 * Имя;
 * Имя, рост;
 * Имя, рост, цвет.
 *
 * Требования:
 * 1. У класса Dog должна быть переменная name с типом String.
 * 2. У класса Dog должна быть переменная height с типом int.
 * 3. У класса Dog должна быть переменная color с типом String.
 * 4. У класса должен быть метод initialize, принимающий в качестве параметра имя
 * и инициализирующий соответствующую переменную класса.
 * 5. У класса должен быть метод initialize, принимающий в качестве параметров имя,
 * рост и инициализирующий соответствующие переменные класса.
 * 6. У класса должен быть метод initialize, принимающий в качестве параметров имя,
 * рост, цвет и инициализирующий соответствующие переменные класса.
*/

public class Dog {
    String name;
    int height;
    String color;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public void initialize(String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
