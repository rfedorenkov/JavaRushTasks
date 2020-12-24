package com.javarush.task.pro.task05.task0509;

/**
 * Таблица умножения
 * Проинициализируй массив MULTIPLICATION_TABLE значением new int[10][10],
 * заполни его таблицей умножения и выведи в консоли в следующем виде:
 * 1 2 3 4 …
 * 2 4 6 8 …
 * 3 6 9 12 …
 * 4 8 12 16 …
 * …
 *
 *
 * Требования:
 * 1. В методе main массив MULTIPLICATION_TABLE должен быть заполнен таблицей умножения.
 * 2. Выведенный текст должен содержать 10 строк.
 * 3. Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
 * 4. Выведенные числа должны быть таблицей умножения.
*/

public class Solution {

    public static int[][] MULTIPLICATION_TABLE = new int[10][10];

    public static void main(String[] args) {
        for (int i = 1; i <= MULTIPLICATION_TABLE.length; i++) {
            for (int j = 1; j <= MULTIPLICATION_TABLE[i - 1].length; j++) {
                int multi = i * j;
                MULTIPLICATION_TABLE[i - 1][j - 1] = multi;
                System.out.printf("%d ", multi);
            }
            System.out.println();
        }
    }
}
