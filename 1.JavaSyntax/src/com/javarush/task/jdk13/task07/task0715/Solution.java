package com.javarush.task.jdk13.task07.task0715;

import java.util.ArrayList;

/**
 * Продолжаем мыть раму
 * 1. Создай список из слов «мама», «мыла», «раму».
 * 2. После каждого слова вставь в список строку, содержащую слово «именно».
 * 3. Вывести результат на экран, каждый элемент списка с новой строки.
 *
 * Требования:
 * 1. Объяви переменную типа список строк и сразу проинициализируй ee.
 * 2. Добавь в список слова: «мама», «мыла», «раму».
 * 3. После каждого слова добавь в список строку, содержащую слово «именно».
 * 4. Выведи элементы списка на экран, каждый с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        for (int i = 0; i < strings.size(); i+=2) {
            strings.add(i + 1, "именно");
        }

        strings.forEach(System.out::println);
    }
}
