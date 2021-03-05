package com.javarush.task.jdk13.task08.task0803;

import java.util.HashMap;
import java.util.Map;

/**
 * Коллекция Map из котов
 * Есть класс Cat с полем имя (name, String). Создать коллекцию Map<String, Cat>.
 * Добавить в коллекцию 10 котов, в качестве ключа использовать имя кота.
 * Вывести результат на экран, каждый элемент с новой строки.
 *
 * Требования:
 * 1. Программа не должна считывать значения с клавиатуры.
 * 2. Метод addCatsToMap() должен возвращать коллекцию всех котов из массива String[] cats, согласно условию.
 * 3. Программа должна выводить содержимое коллекции на экран, каждую пару через дефис и с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        String[] catsArray = new String[]{
                "васька", "мурка", "дымка", "рыжик", "серый", "снежок", "босс", "борис", "визя", "гарфи"};

        Map<String, Cat> map = addCatsToMap(catsArray);

        for (Map.Entry<String, Cat> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }


    public static Map<String, Cat> addCatsToMap(String[] cats) {
        Map<String, Cat> result = new HashMap<>();
        for (String name : cats) {
            result.put(name, new Cat(name));
        }
        return result;
    }


    public static class Cat {
        String name;

        public Cat(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name != null ? name.toUpperCase() : null;
        }
    }
}
