package com.javarush.task.jdk13.task05.task0510;

/**
 * Кошкоинициация
 * У кота (класс Cat) должно быть пять инициализаторов:
 *
 * Имя;
 * Имя, вес, возраст;
 * Имя, возраст (вес стандартный);
 * вес, цвет (имя, адрес и возраст неизвестны, это бездомный кот);
 * вес, цвет, адрес (чужой домашний кот).
 * Задача инициализатора – сделать объект валидным.
 * Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
 * Кот не может нисколько не весить.
 * То же касается возраста и цвета.
 * А вот имени может и не быть (null).
 * То же касается адреса: null.
 *
 *
 * Требования:
 * 1. У класса Cat должна быть переменная name с типом String.
 * 2. У класса Cat должна быть переменная age с типом int.
 * 3. У класса Cat должна быть переменная weight с типом int.
 * 4. У класса Cat должна быть переменная address с типом String.
 * 5. У класса Cat должна быть переменная color с типом String.
 * 6. У класса должен быть метод initialize, принимающий в качестве параметра имя,
 * но инициализирующий все переменные класса, кроме адреса.
 * 7. У класса должен быть метод initialize, принимающий в качестве параметров имя,
 * вес, возраст и инициализирующий все переменные класса, кроме адреса.
 * 8. У класса должен быть метод initialize, принимающий в качестве параметров имя,
 * возраст и инициализирующий все переменные класса, кроме адреса.
 * 9. У класса должен быть метод initialize, принимающий в качестве параметров вес,
 * цвет и инициализирующий все переменные класса, кроме имени и адреса.
 * 10. У класса должен быть метод initialize, принимающий в качестве параметров вес,
 * цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    String name;
    int weight = 2;
    int age = 5;
    String color = "Black";
    String address;

    public void initialize(String name) {
        this.name = name;
    }

    public void initialize(String name, int weight, int age) {
        initialize(name, weight);
        this.age = age;
    }

    public void initialize(String name, int weight) {
        initialize(name);
        this.weight = weight;
    }

    public void initialize(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public void initialize(int weight, String color, String address) {
        initialize(weight, color);
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
