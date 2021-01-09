package com.javarush.task.jdk13.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Максимальное и минимальное числа в массиве
 * Создать массив на 20 чисел. Заполнить его числами с клавиатуры.
 * Найти максимальное и минимальное числа в массиве.
 * Вывести на экран максимальное и минимальное числа через пробел.
 *
 * Требования:
 * 1. Создай массив и инициализируй его значением new int[20].
 * 2. Считай с клавиатуры 20 целых чисел и добавь их в массив.
 * 3. Найди и выведи через пробел максимальное и минимальное числа.
 * 4. Используй цикл for.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;

        int[] ints = new int[20];

        for (int i = 0; i < ints.length; i++) {
            int value = Integer.parseInt(reader.readLine());

            if (maximum < value) {
                maximum = value;
            }

            if (minimum > value) {
                minimum = value;
            }

            ints[i] = value;
        }

        System.out.print(maximum + " " + minimum);
    }
}
