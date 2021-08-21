package com.javarush.task.task29.task2913;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Замена рекурсии
 * В программе случайным образом генерируются два целых числа A и В в диапазоне
 * от 0 (включая) до 1000 (не включая). Нужно вывести все целые числа от A до B включительно,
 * в порядке возрастания, если A меньше B, или в порядке убывания в противном случае.
 *
 * Задача реализована с использованием рекурсии.
 * Иногда в результате работы программы получаем Exception in thread "main" java.lang.StackOverflowError.
 *
 * Твоя задача: перепиши код без использования рекурсии.
 * Метод recursion() переименуй на getAllNumbersBetween().
 *
 *
 * Requirements:
 * 1. Метод recursion() необходимо переименовать на getAllNumbersBetween().
 * 2. Ни в одном методе класса Solution не должно быть рекурсивных вызовов.
 * 3. В конце строчки вывода последовательности чисел не должно быть пробела.
 * 4. Логика работы программы должна остаться прежней.
 * 5. Метод main() не изменять.
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int numberA, int numberB) {
        StringJoiner sb = new StringJoiner(" ");
        if (numberA < numberB) {
            for (int i = numberA; i <= numberB; i++) {
                sb.add(String.valueOf(i));
            }
        } else {
            for (int i = numberA; i >= numberB; i--) {
                sb.add(String.valueOf(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);

        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}