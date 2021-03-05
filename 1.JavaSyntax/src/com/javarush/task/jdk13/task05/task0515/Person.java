package com.javarush.task.jdk13.task05.task0515;

/**
 * Инициализация объектов
 * Изучи внимательно класс Person.
 * Исправь класс так, чтобы только один метод initialize инициализировал все переменные класса Person.
 *
 *
 * Требования:
 * 1. У класса Person должно быть 5 переменных.
 * 2. У класса должен быть один метод initialize.
 * 3. Метод initialize должен иметь пять параметров.
*/

public class Person {
    String name;
    char sex;
    int money;
    int weight;
    double size;

    public void initialize(String name, int money, char sex, int weight, double size) {
        this.name = name;
        this.money = money;
        this.sex = sex;
        this.weight = weight;
        this.size = size;
    }

    public static void main(String[] args) {

    }
}
