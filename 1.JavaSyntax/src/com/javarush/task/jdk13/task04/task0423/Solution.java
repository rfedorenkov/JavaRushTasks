package com.javarush.task.jdk13.task04.task0423;

import java.util.Scanner;

/**
 * И 18-ти достаточно
 * Введи с клавиатуры имя и возраст. Если возраст больше 20, выведи надпись: «И 18-ти достаточно».
 *
 *
 * Требования:
 * 1. Программа должна считывать строки c клавиатуры.
 * 2. Программа должна использовать команду System.out.println() или System.out.print().
 * 3. Если возраст больше 20, вывести только сообщение "И 18-ти достаточно".
 * 4. Если возраст меньше либо равно 20, ничего не выводить.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        if (age > 20) {
            System.out.println("И 18-ти достаточно");
        }
        scanner.close();
    }
}
