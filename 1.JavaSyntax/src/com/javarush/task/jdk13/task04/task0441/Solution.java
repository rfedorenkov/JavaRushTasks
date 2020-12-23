package com.javarush.task.jdk13.task04.task0441;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Среднее такое среднее
 * Введи с клавиатуры три числа, выведи на экран среднее из них. Т.е. не самое большое и не самое маленькое.
 * Если все числа равны, выведи любое из них.
 *
 *
 * Требования:
 * 1. Программа должна считывать числа c клавиатуры.
 * 2. Программа должна выводить число на экран.
 * 3. Программа должна выводить среднее из трех чисел.
 * 4. Если все числа равны, вывести любое из них.
 * 5. Если два числа из трех равны, вывести любое из двух.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = scanner.nextInt();
        }
        scanner.close();

        Arrays.sort(numbers);
        System.out.println(numbers[1]);
    }
}
