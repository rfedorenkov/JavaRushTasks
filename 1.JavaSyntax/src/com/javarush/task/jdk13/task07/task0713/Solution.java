package com.javarush.task.jdk13.task07.task0713;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Три массива
 * 1. Введи с клавиатуры 20 чисел, сохрани их в список numbers и рассортируй по трём другим спискам:
 * - число нацело делится на 3 (x%3==0) - попадает в список divBy3,
 * - нацело делится на 2 (x%2==0) - попадает в divBy2,
 * - и все остальные - попадают в others,
 * - нацело делится на 3 и на 2 одновременно, например 6 - попадает и в divBy3 и в divBy2.
 * Статические переменные списков уже созданны и инициализированы.
 * 2. Метод printList() должен выводить на экран все элементы списка с новой строки.
 * 3. Используя метод printList() выведи экран: сначала список divBy3, потом divBy2, потом others.
 *
 * Требования:
 * 1. Считать 20 чисел с клавиатуры и добавить их в список numbers.
 * 2. Добавить в список divBy3 все числа из numbers, которые нацело делятся на 3.
 * 3. Добавить в список divBy2 все числа из numbers, которые нацело делятся на 2.
 * 4. Добавить в список others все остальные числа из numbers.
 * 5. Метод printList() должен выводить на экран все элементы переданного списка, каждый с новой строки.
 * 6. Программа должна вывести списки divBy3, divBy2, others используя метод printList().
*/

public class Solution {

    public static ArrayList<Integer> numbers = new ArrayList<>();
    public static ArrayList<Integer> divBy3 = new ArrayList<>();
    public static ArrayList<Integer> divBy2 = new ArrayList<>();
    public static ArrayList<Integer> others = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntStream.range(0, 20).forEach(i -> numbers.add(scanner.nextInt()));

        for (Integer number : numbers) {
            if (number % 3 == 0 || number % 2 == 0) {
                if (number % 3 == 0) {
                    divBy3.add(number);
                }
                if (number % 2 == 0) {
                    divBy2.add(number);
                }
            } else {
                others.add(number);
            }
        }

        printList(divBy3);
        printList(divBy2);
        printList(others);
    }

    public static void printList(ArrayList<Integer> list) {
        list.forEach(System.out::println);
    }
}
