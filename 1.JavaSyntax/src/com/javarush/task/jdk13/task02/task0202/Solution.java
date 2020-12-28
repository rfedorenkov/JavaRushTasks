package com.javarush.task.jdk13.task02.task0202;

/**
 * Класс Person
 * В классе Person объяви следующие переменные: name типа String, age типа int, weight типа int, money типа int.
 * В методе main создай объект Person, занеси его ссылку в переменную person.
 *
 * Подсказка: чтобы создать объект Person и занести его ссылку в переменную person, используй конструкцию:
 * ТипПеременной имяПеременной = new ТипСоздаваемогоОбъекта();
 *
 *
 * Требования:
 * 1. В классе Person объяви переменную name типа String.
 * 2. В классе Person объяви переменную age типа int.
 * 3. В классе Person объяви переменную weight типа int.
 * 4. В классе Person объяви переменную money типа int.
 * 5. В методе main создай объект Person и сразу присвой ссылку на него переменной person.
 * 6. Должно быть объявлено 5 переменных.
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
    }

    public static class Person {
        private String name;
        private int age;
        private int weight;
        private int money;
    }
}
