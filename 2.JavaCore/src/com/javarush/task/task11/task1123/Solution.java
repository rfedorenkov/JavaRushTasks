package com.javarush.task.task11.task1123;

/**
 * Минимакс
 * Напиши метод, который возвращает минимальное и максимальное числа в массиве.
 *
 *
 * Требования:
 * 1. Программа не должна считывать данные с клавиатуры.
 * 2. Класс Pair не изменяй.
 * 3. Метод main не изменяй.
 * 4. Допиши реализацию метода getMinimumAndMaximum: он должен возвращать пару из минимума и максимума.
 * 5. Программа должна вывести правильный результат.
 * 6. Метод getMinimumAndMaximum не должен изменять массив inputArray.
 */
public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair<>(null, null);
        }

        int max = inputArray[0];
        int min = inputArray[0];

        for (int i : inputArray) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return new Pair<>(min, max);
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
