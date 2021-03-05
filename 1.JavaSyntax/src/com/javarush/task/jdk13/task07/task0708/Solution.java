package com.javarush.task.jdk13.task07.task0708;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Самое большое число
 * 1. Считай с клавиатуры 5 чисел и добавь в список integers.
 * 2. Найди максимальное число в списке.
 * 3. Выведи найденное число на экран.
 *
 * Требования:
 * 1. Программа должна считывать 5 чисел с клавиатуры и записывать их в поле integers класса Solution.
 * 2. Программа должна выводить максимальное число на экран.
*/

public class Solution {

    private static ArrayList<Integer> integers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            integers.add(scanner.nextInt());
        }
        integers.sort((x, y) -> Integer.compare(y, x));
        System.out.println(integers.get(0));
    }
}
