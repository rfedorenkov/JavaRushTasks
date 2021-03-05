package com.javarush.task.task14.task1404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Коты
 * Давай напишем программу, которая будет давать имена всем котикам, выпускаемым на нашей котофабрике.
 * Для этого нужно:
 * Считывать строки (параметры) с консоли, пока пользователь не введет пустую строку (Enter).
 * Для каждого параметра (имени кота):
 * создать объект cat класса Cat, который равен коту из getCatByKey(String параметр).
 * вывести на экран cat.toString().
 *
 * Требования:
 * 1. Программа должна считывать данные с клавиатуры.
 * 2. Программа должна прекращать считывать данные после ввода пустой строки.
 * 3. Программа должна выводить на экран описание каждого кота (cat.toString).
 * 4. Программа должна создавать объект класса Cat для каждого введенного имени кота (строки,
 * считанной с клавиатуры) c помощью метода getCatByKey.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true){
                String name = reader.readLine();
                if (name.isEmpty()) {
                    return;
                }
                Cat cat = CatFactory.getCatByKey(name);
                System.out.println(cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private final String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        @Override
        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
