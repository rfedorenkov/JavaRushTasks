package com.javarush.task.jdk13.task04.task0418;

import java.util.Scanner;

/**
 * Минимум двух чисел
 * Введи с клавиатуры два целых числа и выведи на экран минимальное из них. Если два числа равны между собой, необходимо вывести любое.
 *
 *
 * Требования:
 * 1. Программа должна считывать числа c клавиатуры.
 * 2. Программа должна выводить число на экран.
 * 3. Программа должна выводить на экран минимальное из двух целых чисел.
 * 4. Если два числа равны между собой, необходимо вывести любое.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();
        System.out.println(Math.min(numberOne, numberTwo));
        scanner.close();
    }
}