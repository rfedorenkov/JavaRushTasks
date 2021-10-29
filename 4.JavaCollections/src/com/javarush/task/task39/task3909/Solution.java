package com.javarush.task.task39.task3909;

import java.util.Arrays;

/**
 * Одно изменение
 * Реализуй метод isOneEditAway(String first, String second) который будет возвращать true,
 * если возможно изменить/добавить/удалить один символ в одной из строк и получить другую.
 *
 * Символы в анализируемой строке ограничены кодировкой ASCII.
 * Регистр символов учитывается.
 *
 *
 * Requirements:
 * 1. Метод isOneEditAway должен корректно работать для строк одинаковой длины.
 * 2. Метод isOneEditAway должен корректно работать для строк разной длины.
 * 3. Метод isOneEditAway должен корректно работать для пустых строк.
 * 4. Метод isOneEditAway должен быть публичным.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if (first.isEmpty() || second.isEmpty()) {
            return true;
        }

        if (first.equals(second)) {
            return true;
        }

        int[][] arr = new int[first.length() + 1][second.length() + 1];
        for (int i = 0; i <= first.length(); i++) {
            for (int j = 0; j <= second.length(); j++) {
                if (i == 0) {
                    arr[i][j] = j;
                } else if (j == 0) {
                    arr[i][j] = i;
                } else {
                    arr[i][j] = min(arr[i - 1][j - 1]
                            + costOfSubstitution(first.charAt(i - 1), second.charAt(j - 1))
                            , arr[i - 1][j] + 1,
                            arr[i][j - 1] + 1);
                }
            }
        }
        return arr[first.length()][second.length()] < 2;
    }


    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }
}
