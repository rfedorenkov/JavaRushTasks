package com.javarush.task.jdk13.task02.task0213;

/**
 * У каждого животного должна быть хозяйка
 * Создай объект типа Cat (кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
 * Присвой каждому животному владельца (owner).
 *
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. В методе main создай объекты типа Cat, Dog, Fish, Woman и занеси их ссылки в переменные.
 * 3. В методе main присвой каждому животному владельца Woman.
 * 4. Класс Cat, Dog, Fish должен содержать только одну переменную Woman owner.
 * 5. Класс Woman не должен содержать переменные.
*/

public class Solution {
    public static void main(String[] args) {
        Woman woman = new Woman();

        Cat cat = new Cat();
        cat.owner = woman;

        Dog dog = new Dog();
        dog.owner = woman;

        Fish fish = new Fish();
        fish.owner = woman;
    }

    public static class Cat {
        public Woman owner;
    }

    public static class Dog {
        public Woman owner;
    }

    public static class Fish {
        public Woman owner;
    }

    public static class Woman {
    }
}
