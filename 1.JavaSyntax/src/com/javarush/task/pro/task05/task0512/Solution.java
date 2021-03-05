package com.javarush.task.pro.task05.task0512;

/**
 * 3D
 * В методе main(String[]) выведи на экран все числа из трехмерного массива multiArray.
 *
 *
 * Требования:
 * 1. В классе Solution должна быть публичная статическая переменная multiArray типа int[][][].
 * 2. В методе main(String[]) выведи на экран все числа из multiArray.
*/

public class Solution {

    public static int[][][] multiArray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1}, {2}, {3}, {4, 5}}};

    public static void main(String[] args) {
        for (int[][] ints : multiArray) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
