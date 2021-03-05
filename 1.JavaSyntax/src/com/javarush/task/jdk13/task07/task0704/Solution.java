package com.javarush.task.jdk13.task07.task0704;

import java.util.Scanner;

/**
 * Массив из чисел в обратном порядке
 * 1. Создать массив на 10 чисел.
 * 2. Ввести с клавиатуры 10 чисел и записать их в массив.
 * 3. Вывести на экран элементы массива в обратном порядке, каждое значение выводить с новой строки.
 *
 * Требования:
 * 1. Программа должна создавать массив и инициализировать его значением new int[10].
 * 2. Программа должна считывать числа для массива с клавиатуры.
 * 3. Программа должна выводить 10 строчек, каждую с новой строки.
 * 4. Массив должен быть выведен на экран в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = scanner.nextInt();
        }
        scanner.close();
        for (int i = ints.length - 1; i >= 0; i--) {
            System.out.println(ints[i]);
        }
    }
}

