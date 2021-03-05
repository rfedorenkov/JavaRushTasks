package com.javarush.task.jdk13.task12.task1201;

/**
 * Из маленькой корзинки в большую
 * При перемножении двух long чисел, результат может превысить размеры типа long.
 * Если точность не важна, то одним из вариантов может быть сохранение результата в виде вещественного числа.
 * Реализуй метод getSquare. Он должен возвращать квадрат входящего аргумента.
 *
 *
 * Требования:
 * 1. Метод getSquare должен возвращать квадрат входящего аргумента в виде числа double.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getSquare(7)); // 49.0
        System.out.println(getSquare(100_000_001)); // 1.00000002E16
        System.out.println(getSquare(9_000_000_000_000_000_001L)); // 8.1E37
    }

    public static double getSquare(long number) {
        return Math.pow(number, 2);
    }
}
