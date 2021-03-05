package com.javarush.task.jdk13.task03.task0319;

import java.util.Scanner;

/**
 * Зарплата через 5 лет
 * Введи с клавиатуры отдельно Имя, число1, число2. Выведи надпись:
 * «Имя» получает «число1» через «число2» лет.
 *
 * Пример:
 * Коля получает 3000 через 5 лет.
 *
 *
 * Требования:
 * 1. Программа должна выводить текст.
 * 2. Программа должна считывать данные с клавиатуры.
 * 3. Выведенный текст должен содержать введенное имя.
 * 4. Выведенный текст должен содержать введенное число1.
 * 5. Выведенный текст должен содержать введенное число2.
 * 6. Выведенный текст должен полностью соответствовать заданию.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int numberOne = scanner.nextInt();
        int numberTwo = scanner.nextInt();
        System.out.printf("%s получает %d через %d лет.", name, numberOne, numberTwo);
        scanner.close();
    }
}
