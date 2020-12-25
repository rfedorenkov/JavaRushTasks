package com.javarush.task.pro.task05.task0514;

import java.util.Arrays;

/**
 * Выводим двумерные массивы
 * Реализуй метод main(String[]), который выводит массивы strings и ints
 * в консоли c помощью метода Arrays.deepToString(Object[][]).
 *
 *
 * Требования:
 * 1. В классе Solution должна быть публичная статическая переменная strings типа String[][].
 * 2. В классе Solution должна быть публичная статическая переменная ints типа int[][].
 * 3. В методе main(String[]) выведи в консоли массив strings с помощью метода Arrays.deepToString(Object[][]).
 * 4. В методе main(String[]) выведи в консоли массив ints с помощью метода Arrays.deepToString(int[][]).
*/

public class Solution {

    public static String[][] strings = new String[][]{
            {"🙂", "🙂", "🙂", "🙂"},
            {"🙃", "🙃", "🙃", "🙃"},
            {"😋", "😋", "😋", "😋"},
            {"😎", "😎", "😎", "😎"},
    };
    public static int[][] ints = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(strings));
        System.out.println(Arrays.deepToString(ints));
    }
}
