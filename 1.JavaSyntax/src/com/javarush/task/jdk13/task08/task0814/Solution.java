package com.javarush.task.jdk13.task08.task0814;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Больше 10? Вы нам не подходите
 * Создать множество чисел(Set), занести туда 20 различных чисел. Удалить из множества все числа больше 10.
 *
 * Требования:
 * 1. Класс Solution должен содержать только три метода.
 * 2. Метод createSet() должен создавать и возвращать множество Set состоящих из 20 различных чисел.
 * 3. Метод removeAllNumbersGreaterThan10() должен удалять из множества все числа больше 10.
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random(47);
        do {
            set.add(random.nextInt(40) - 10);
        } while (set.size() != 20);
        return set;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(i -> i > 10);
    }

    public static void main(String[] args) {

    }
}
