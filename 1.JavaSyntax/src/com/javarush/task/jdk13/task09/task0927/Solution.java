package com.javarush.task.jdk13.task09.task0927;

import java.util.*;

/**
 * Десять котов
 * Есть класс кот – Cat, с полем «имя» (String). Создать словарь Map<String, Cat>
 * и добавить туда 10 котов в виде «Имя»-«Кот». Получить из Map множество(Set) всех котов.
 * Вывести множество на экран (уже реализовано).
 *
 * Требования:
 * 1. Программа не должна считывать данные с клавиатуры.
 * 2. В методе createMap() необходимо создать новый объект HashMap<String, Cat>.
 * 3. В методе createMap() необходимо добавить в словарь 10 котов в виде «Имя»-«Кот», и вернуть созданный словарь.
 * 4. В методе convertMapToSet(Map<String, Cat>) необходимо создать и вернуть множество котов,
 * полученных из переданного словаря.
 * 5. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {

    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> cats = new HashMap<>();
        cats.put("Vaska", new Cat("Vaska"));
        cats.put("Boris", new Cat("Boris"));
        cats.put("Pirat", new Cat("Pirat"));
        cats.put("Romeo", new Cat("Romeo"));
        cats.put("Persik", new Cat("Persik"));

        cats.put("Murka", new Cat("Murka"));
        cats.put("Alisa", new Cat("Alisa"));
        cats.put("Sonya", new Cat("Sonya"));
        cats.put("Sima", new Cat("Sima"));
        cats.put("Bella", new Cat("Bella"));
        return cats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return new HashSet<>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cat " + this.name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Cat)) {
                return false;
            }
            Cat cat = (Cat) o;
            return Objects.equals(name, cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
