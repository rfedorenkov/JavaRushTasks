package com.javarush.task.jdk13.task07.task0705;

import java.util.Scanner;

/**
 * Один большой массив и два маленьких
 * 1. Создать массив на 20 чисел.
 * 2. Ввести в него значения с клавиатуры.
 * 3. Создать два массива на 10 чисел каждый.
 * 4. Скопировать большой массив в два маленьких:
 * половину чисел в первый маленький, вторую половину во второй маленький.
 * 5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
 *
 * Требования:
 * 1. Программа должна создавать большой массив и инициализировать его значением new int[20].
 * 2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
 * 3. Программа должна создавать два маленьких массива и инициализировать их значениями new int[10].
 * 4. Программа должна скопировать одну половину большого массива в первый маленький,
 * а вторую - во второй и вывести второй маленький массив на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] original = new int[20];
        for (int i = 0; i < original.length; i++) {
            original[i] = scanner.nextInt();
        }
        scanner.close();
        int[] partOne = new int[10];
        int[] partTwo = new int[10];
        System.arraycopy(original, 0, partOne, 0, original.length / 2);
        System.arraycopy(original, original.length / 2, partTwo, 0, original.length / 2);
        for (int i = 0; i < partTwo.length; i++) {
            System.out.println(partTwo[i]);
        }
    }
}
