package com.javarush.task.jdk13.task07.task0711;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Удали последнюю строку и вставь её в начало
 * 1. Создай список строк.
 * 2. Добавь в него 5 строк с клавиатуры.
 * 3. Выполни 13 раз: удалить последнюю строку и вставить её в начало.
 * 4. Используя цикл выведи содержимое результирующего списка на экран, каждое значение с новой строки.
 *
 * Требования:
 * 1. Объяви переменную типа список строк и сразу проинициализируй ee.
 * 2. Программа должна считывать 5 строк с клавиатуры.
 * 3. Удали последнюю строку и вставь её в начало. Повторить 13 раз.
 * 4. Программа должна выводить список на экран, каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add(scanner.next());
        }

        IntStream.range(0, 13)
                .mapToObj(i -> strings.remove(strings.size() - 1))
                .forEach(remove -> strings.add(0, remove));

        strings.forEach(System.out::println);
    }
}
