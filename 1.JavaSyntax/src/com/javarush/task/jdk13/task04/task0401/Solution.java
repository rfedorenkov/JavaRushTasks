package com.javarush.task.jdk13.task04.task0401;

/**
 * Shadowing variables
 * Подумай, что делает программа.
 * Исправьте ошибку в программе, чтобы переменная age объекта person изменила свое значение.
 *
 * Подсказка: тщательно просмотрите метод adjustAge.
 *
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Класс Person должен иметь публичное поле age типа int.
 * 3. Метод adjustAge класса Person должен выводить текст на экран.
 * 4. Метод adjustAge класса Person должен иметь только один параметр age типа int и тип возвращаемого значения void.
 * 5. Метод main должен вызывать метод adjustAge только один раз.
 * 6. Метод adjustAge класса Person должен увеличивать возраст человека (Person) на 20.
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println("Age is: " + person.age);
        person.adjustAge(person.age);
        System.out.println("Adjusted age is: " + person.age);
    }

    public static class Person {
        public int age = 20;

        public void adjustAge(int age) {
            this.age = age + 20;
            System.out.println("Age in adjustAge() is: " + age);
        }
    }
}
