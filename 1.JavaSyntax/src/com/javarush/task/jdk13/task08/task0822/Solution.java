package com.javarush.task.jdk13.task08.task0822;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Минимальное из N чисел
 * 1. Ввести с клавиатуры число N.
 * 2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
 * 3. Найти минимальное число среди элементов списка - метод getMinimum.
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Программа должна считывать значения с клавиатуры.
 * 3. Класс Solution должен содержать только три метода.
 * 4. Метод getIntegerList() должен считать с клавиатуры число N, потом вернуть список размером N элементов,
 * заполненный числами с клавиатуры.
 * 5. Метод getMinimum() должен вернуть минимальное число среди элементов списка.
 * 6. Метод main() должен вызывать метод getIntegerList().
 * 7. Метод main() должен вызывать метод getMinimum().
*/

public class Solution {
    public static void main(String[] args) {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> list) {
        return Collections.min(list);
    }

    public static List<Integer> getIntegerList() {
        List<Integer> integers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            integers.add(scanner.nextInt());
        }
        scanner.close();
        return integers;
    }
}
