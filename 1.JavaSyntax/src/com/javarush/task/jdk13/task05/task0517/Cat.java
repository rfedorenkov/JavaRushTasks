package com.javarush.task.jdk13.task05.task0517;

/**
 * Конструируем котиков
 * У кота (класс Cat) должно быть пять конструкторов:
 *
 * Имя;
 * Имя, вес, возраст;
 * Имя, возраст (вес стандартный);
 * вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный);
 * вес, цвет, адрес (чужой домашний кот).
 * Задача конструктора – сделать объект валидным.
 * Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
 * Кот не может нисколько не весить. То же касаемо возраста.
 * А вот имени, как и адреса, может и не быть (null).
 *
 * Требования:
 * 1. У класса Cat должна быть переменная name с типом String.
 * 2. У класса Cat должна быть переменная age с типом int.
 * 3. У класса Cat должна быть переменная weight с типом int.
 * 4. У класса Cat должна быть переменная address с типом String.
 * 5. У класса Cat должна быть переменная color с типом String.
 * 6. У класса должен быть конструктор, принимающий в качестве параметра имя,
 * но инициализирующий все переменные класса, кроме адреса.
 * 7. У класса должен быть конструктор, принимающий в качестве параметров имя,
 * вес, возраст и инициализирующий все переменные класса, кроме адреса.
 * 8. У класса должен быть конструктор, принимающий в качестве параметров имя,
 * возраст и инициализирующий все переменные класса, кроме адреса.
 * 9. У класса должен быть конструктор, принимающий в качестве параметров вес,
 * цвет и инициализирующий все переменные класса, кроме имени и адреса.
 * 10. У класса должен быть конструктор, принимающий в качестве параметров вес,
 * цвет, адрес и инициализирующий все переменные класса, кроме имени.
*/

public class Cat {
    String name;
    int age = 3;
    int weight = 2;
    String address;
    String color = "Black";

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        this.weight = weight;
        this.address = address;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}