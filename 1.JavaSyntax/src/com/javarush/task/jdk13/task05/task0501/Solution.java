package com.javarush.task.jdk13.task05.task0501;

/**
 * Кошачья бойня(4)
 * Создай три кота, используя класс Cat.
 * Проведи три боя попарно между котами.
 * Класс Cat создавать не надо. Для боя используй метод boolean fight(Cat anotherCat).
 * Результат каждого боя выведи на экран c новой строки.
 *
 *
 * Требования:
 * 1. В методе main(String[]) должно быть три объекта типа Cat.
 * 2. Нужно провести три боя.
 * 3. Программа должна вывести результат каждого боя с новой строки.
*/

public class Solution {

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

        public boolean fight(Cat anotherCat) {
            if (this == anotherCat) {
                return false;
            }
            int score = Integer.compare(this.strength, anotherCat.strength);
            score += Integer.compare(this.weight, anotherCat.weight);
            score += Integer.compare(this.age, anotherCat.age);
            return score > 0;
        }
    }

    public static void main(String[] args) {
        Cat vaska = new Cat("Vaska", 5, 4, 11);
        Cat boris = new Cat("Boris", 5, 5, 10);
        Cat murka = new Cat("Murka", 6, 4, 6);

        System.out.println(vaska.fight(boris));
        System.out.println(vaska.fight(murka));
        System.out.println(boris.fight(murka));
    }
}
