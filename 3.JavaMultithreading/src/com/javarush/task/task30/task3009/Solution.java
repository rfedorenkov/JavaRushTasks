package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Палиндром?
 * Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number),
 * в котором нужно определить, в каких системах счисления (от 2 до 36 включительно)
 * представление числа number (передается в десятичной системе счисления) является
 * палиндромом и добавить индекс таких систем в результат.
 * Если переданное число некорректно - возвращай пустой HashSet.
 * В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы.
 * К примеру, числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.
 * <p>
 * Метод main не принимает участие в тестировании.
 * <p>
 * P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.
 * <p>
 * <p>
 * Requirements:
 * 1. Необходимо объявить приватный статический метод Set<Integer> getRadix(String number).
 * 2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
 * 3. Методе getRadix не должен бросать NumberFormatException.
 * 4. Метод getRadix не должен ничего выводить в консоль.
 * 5. Метод getRadix должен возвращать множество согласно условию задачи.
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String s) {
        Set<Integer> set = new HashSet<>();
        try {
            int number = Integer.parseInt(s);
            set = IntStream.rangeClosed(Character.MIN_RADIX, Character.MAX_RADIX)
                    .filter(i -> isPalindrome(Integer.toString(number, i)))
                    .boxed()
                    .collect(Collectors.toSet());
        } catch (NumberFormatException ignored) {
        }
        return set;
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}