package com.javarush.task.jdk13.task04.task0425;

import java.util.Scanner;

/**
 * Координатные четверти
 * Введи с клавиатуры два целых числа, которые будут координатами точки, не лежащей на осях OX и OY.
 * Выведи на экран номер координатной четверти, в которой находится данная точка.
 *
 * Подсказка:
 * Принадлежность точки с координатами (a,b) к одной из четвертей определяется следующим образом:
 *
 * для первой четверти - a>0 и b>0;
 * для второй четверти - a<0 и b>0;
 * для третьей четверти - a<0 и b<0;
 * для четвертой четверти - a>0 и b<0.
 * Пример для чисел 4 6:
 * 1
 * Пример для чисел -6 -6:
 * 3
 *
 *
 * Требования:
 * 1. Программа должна считывать числа c клавиатуры.
 * 2. Программа должна использовать команду System.out.println() или System.out.print().
 * 3. Если точка находится в первой координатной четверти, вывести "1".
 * 4. Если точка находится во второй координатной четверти, вывести "2".
 * 5. Если точка находится в третей координатной четверти, вывести "3".
 * 6. Если точка находится в четвёртой координатной четверти, вывести "4".
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        if (x > 0 && y > 0) {
            System.out.println(1);
        } else if (x < 0 && y > 0) {
            System.out.println(2);
        } else if (x < 0 && y < 0) {
            System.out.println(3);
        } else if (x > 0 && y < 0) {
            System.out.println(4);
        }

        scanner.close();
    }
}
