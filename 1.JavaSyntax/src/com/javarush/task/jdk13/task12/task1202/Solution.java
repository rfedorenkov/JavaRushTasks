package com.javarush.task.jdk13.task12.task1202;

/**
 * Приблизительное значение
 * При преобразовании из целых чисел в дробные могут отбрасываться самые младшие части числа. Проверим это на практике.
 * В методе getDifference входящий аргумент уже преобразован в float.
 * Определи, что отбросилось при этом преобразовании, и верни недостающую часть.
 *
 *
 * Требования:
 * 1. Метод getDifference должен возвращать разницу между входящим аргументом и локальной переменной approx.
*/

public class Solution {

    public static void main(String[] args) {
        int big = 1234567890;

        System.out.println(getDifference(big)); // 46 или -46
    }

    public static int getDifference(int big) {
        float approx = big;

        return (int) approx - big;
    }
}
