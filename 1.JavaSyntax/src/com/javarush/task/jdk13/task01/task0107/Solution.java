package com.javarush.task.jdk13.task01.task0107;

/**
 * Обмен
 * Раскомментируй одну строчку, чтобы программа вывела на экран числа 12 и 2 (сначала 12, а затем 2).
 *
 *
 * Требования:
 * 1. Программа должна выводить на экран числа 12 и 2.
 * 2. Нельзя изменять строки с объявлением переменных.
 * 3. Программа должна содержать только две переменные типа int.
 * 4. Нельзя изменять строки, отвечающие за вывод в консоль.
 * 5. Нужно раскомментировать одну строку и не менять остальные.
*/

public class Solution {
    public static void main(String[] args) {
        int x = 2;
        int y = 12;

        // y = x * y;
         y = x + y;

        x = y - x;
        y = y - x;

        System.out.println(x);
        System.out.println(y);
    }
}