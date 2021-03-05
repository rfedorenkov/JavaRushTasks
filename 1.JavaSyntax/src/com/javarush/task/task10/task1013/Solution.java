package com.javarush.task.task10.task1013;

import java.util.Date;

/**
 * Конструкторы класса Human
 * Напиши класс Human с 6 полями.
 * Придумай и реализуй 10 различных конструкторов для него.
 *
 *
 * Требования:
 * 1. Программа не должна считывать данные с клавиатуры.
 * 2. В классе Human должно быть 6 полей.
 * 3. Все поля класса Human должны быть private.
 * 4. В классе Human должно быть 10 конструкторов.
 * 5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private int age;
        private int height;
        private int weight;
        private String address;
        private Date birthday;

        public Human() {
        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, Date birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public Human(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public Human(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public Human(String name, String address, Date birthday) {
            this.name = name;
            this.address = address;
            this.birthday = birthday;
        }

        public Human(String name, int age, int height, int weight) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, int age, int height, int weight, String address) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.address = address;
        }

        public Human(String name, int age, int height, int weight, String address, Date birthday) {
            this.name = name;
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.address = address;
            this.birthday = birthday;
        }
    }
}
