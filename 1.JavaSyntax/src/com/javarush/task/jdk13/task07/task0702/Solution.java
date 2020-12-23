package com.javarush.task.jdk13.task07.task0702;

import java.util.Scanner;

/**
 * Массив из строчек в обратном порядке
 * 1. Создать массив на 10 строк.
 * 2. Ввести с клавиатуры 8 строк и сохранить их в массив.
 * 3. Вывести содержимое всего массива (10 элементов) на экран в обратном порядке. Каждый элемент - с новой строки.
 *
 * Требования:
 * 1. Программа должна создавать массив и инициализировать его значением new String[10].
 * 2. Программа должна считывать 8 строк для массива с клавиатуры.
 * 3. Программа должна выводить на экран 10 строк, каждую с новой строки.
 * 4. Программа должна выводить на экран массив (10 элементов) в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[10];
        for (int i = 0; i < 8; i++) {
            strings[i] = scanner.next();
        }
        scanner.close();
        for (int i = strings.length - 1; i >= 0 ; i--) {
            System.out.println(strings[i]);
        }
    }
}