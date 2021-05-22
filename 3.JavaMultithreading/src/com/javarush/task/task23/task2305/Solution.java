package com.javarush.task.task23.task2305;

/**
 * Inner
 * Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
 * Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
 * Инициализация всех данных должна происходить только в методе getTwoSolutions.
 *
 *
 * Requirements:
 * 1. В классе Solution должен быть реализован метод getTwoSolutions.
 * 2. Метод getTwoSolutions должен быть статическим.
 * 3. Метод getTwoSolutions должен быть публичным.
 * 4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
 */

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];
        for (int i = 0; i < result.length; i++) {
            Solution solution = new Solution();
            for (int j = 0; j < solution.innerClasses.length; j++) {
                solution.innerClasses[j] = solution.new InnerClass();
            }
            result[i] = solution;
        }
        return result;
    }

    public static void main(String[] args) {
    }

    public class InnerClass {

    }
}
