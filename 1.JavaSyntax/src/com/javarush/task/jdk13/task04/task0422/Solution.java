package com.javarush.task.jdk13.task04.task0422;

import java.util.Scanner;

/**
 * 18+
 * Введи с клавиатуры имя и возраст. Если возраст меньше 18, выведи надпись: «Подрасти еще».
 *
 *
 * Требования:
 * 1. Программа должна дважды считать данные c клавиатуры.
 * 2. Программа должна использовать команду System.out.println() или System.out.print().
 * 3. Если возраст меньше 18, вывести только сообщение "Подрасти еще".
 * 4. Если возраст больше либо равно 18, ничего не выводить.
 */

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        if (age < 18) {
            System.out.println("Подрасти еще");
        }
        scanner.close();
    }
}
