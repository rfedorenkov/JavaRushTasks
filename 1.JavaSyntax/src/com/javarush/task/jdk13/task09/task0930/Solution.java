package com.javarush.task.jdk13.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Задача по алгоритмам
 * Программа считывает с клавиатуры слова и числа, добавляет их в список,
 * преобразует список к массиву, выводит массив на экран.
 * Реализуй сортировку массива, чтобы слова вывелись в возрастающем порядке, а числа - в убывающем.
 * Пример ввода: Вишня 1 Боб 3 Яблоко 22 0 Арбуз
 * Пример вывода: Арбуз 22 Боб 3 Вишня 1 0 Яблоко
 *
 * Требования:
 * 1. Программа должна считывать данные с клавиатуры.
 * 2. Программа должна выводить данные на экран.
 * 3. Выведенные слова должны быть упорядочены по возрастанию. Используй готовый метод isGreaterThan(String, String).
 * 4. Выведенные числа должны быть упорядочены по убыванию.
 * 5. В методе main(String[]) нужно использовать метод sort(String[]).
 * 6. В методе sort(String[]) нужно использовать методы isGreaterThan(String, String) и isNumber(String).
*/

public class Solution {

    public static ArraySorter arraySorter = new ArraySorter();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String line = reader.readLine();
        while (!line.isEmpty()) {
            list.add(line);
            line = reader.readLine();
        }

        String[] array = list.toArray(new String[0]);
        arraySorter.sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }
}
