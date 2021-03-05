package com.javarush.task.pro.task05.task0517;

import java.util.Arrays;

/**
 * Делим массив
 * Реализуй метод main(String[]), который делит массив array на два подмассива
 * и заполняет ими двухмерный массив result. Если длина массива нечетная,
 * то большую часть нужно скопировать в первый подмассив.
 * Для разделения массива используй метод Arrays.copyOfRange(int[], int, int).
 * Порядок элементов не меняй.
 * При тестировании значения полей класса Solution будут разными, учти это.
 *
 *
 * Требования:
 * 1. Реализуй метод main(String[]) согласно условию.
*/

public class Solution {

    public static int[][] result = new int[2][];
    public static int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

    public static void main(String[] args) {
        int middle = array.length / 2;
        int delimiter = array.length % 2 == 0 ? middle : middle + 1;
        result[0] = Arrays.copyOfRange(array, 0, delimiter);
        result[1] = Arrays.copyOfRange(array, delimiter, array.length);
        System.out.println(Arrays.deepToString(result));
    }
}
