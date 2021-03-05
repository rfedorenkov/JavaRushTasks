package com.javarush.task.jdk13.task03.task0313;

import java.util.Arrays;

/**
 * Мама мыла раму
 * Выведи на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
 *
 * Подсказка: их 6 штук. Каждую комбинацию нужно вывести с новой строки. Слова не разделять.
 *
 * Пример:
 * МылаРамуМама
 * РамуМамаМыла
 * ...
 *
 * Для формирования строк используй либо метод System.out.printf(), либо String.format().
 *
 *
 * Требования:
 * 1. Программа должна выводить текст.
 * 2. Выведенный текст должен содержать 6 строк.
 * 3. Текст в каждой строке должен быть уникален.
 * 4. Для формирования строк нужно использовать либо метод String.format(), либо метод System.out.printf().
 * 5. Нужно вывести все возможные комбинации.
*/

public class Solution {
    public static final String[] WORDS = "Мама Мыла Раму".split(" ");

    public static void main(String[] args) {
        allCombination(WORDS);
    }

    public static <T> void allCombination(T[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Massive is empty");
        }
        swapIteration(arr, 0);
    }

    private static <T> void swapIteration(T[] arr, int index) {
        if (index == arr.length) {
            Arrays.stream(arr).forEach(t -> System.out.printf("%s", t));
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            swapIteration(arr, index + 1);
            swap(arr, index, i);
        }
    }

    private static <T> void swap(T[] arr, int elemOne, int elemTwo) {
        T tmp = arr[elemOne];
        arr[elemOne] = arr[elemTwo];
        arr[elemTwo] = tmp;
    }
}
