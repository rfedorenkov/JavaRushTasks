package com.javarush.task.task39.task3912;

/**
 * Максимальная площадь
 * Реализуй метод int maxSquare(int[][] matrix), возвращающий площадь самого большого квадрата
 * состоящего из единиц в двумерном массиве matrix.
 * Массив matrix заполнен только нулями и единицами.
 *
 *
 * Requirements:
 * 1. Метод maxSquare должен быть реализован в соответствии с условием задачи.
 * 2. Метод maxSquare должен эффективно работать с большими массивами.
 * 3. Метод maxSquare должен быть публичным.
 * 4. Метод maxSquare должен возвращать число типа int.
 * 5. Метод maxSquare должен быть статическим.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        int max = 0;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i][j - 1], Math.min(matrix[i - 1][j - 1], matrix[i - 1][j])) + 1;
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max * max;
    }
}
