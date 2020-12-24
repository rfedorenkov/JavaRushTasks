package com.javarush.task.pro.task05.task0510;

/**
 * Треугольный массив
 * Создай треугольный массив, где значение каждого элемента — это сумма его индексов. Например:
 * array[7][3] = 7 + 3 = 10,
 * array[3][0] = 3 + 0 = 3.
 *
 * Выведи массив на экран в следующем виде:
 * 0
 * 1 2
 * 2 3 4
 * 3 4 5 6
 * 4 5 6 7 8
 * 5 6 7 8 9 10
 * ...
 *
 * Задать треугольный массив можно следующим образом:
 * int[][] array = new int[10][];
 * array[0] = new int[1];
 * array[1] = new int[2];
 * array[2] = new int[3];
 * ...
 *
 *
 * Требования:
 * 1. В методе main(String[]) двухмерный массив result заполни числами согласно условию.
 * 2. Выведенный текст должен содержать 10 строк.
 * 3. Выведенные числа должны соответствовать условию.
*/

public class Solution {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = i + j;
                System.out.printf("%d ", result[i][j]);
            }
            System.out.println();
        }
    }
}
