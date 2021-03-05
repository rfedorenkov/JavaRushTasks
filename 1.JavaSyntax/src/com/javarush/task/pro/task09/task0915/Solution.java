package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * StringTokenizer
 * Используя StringTokenizer раздели query на части по разделителю delimiter.
 *
 * Пример:
 * getTokens("com.javarush.task.pro.task09.task0915", ".a")
 * возвращает массив строк
 * {"com", "j", "v", "rush", "t", "sk", "pro", "t", "sk09", "t", "sk0915"}
 *
 *
 * Требования:
 * 1. Нужно, чтобы метод getTokens(String, String) использовал StringTokenizer.
 * 2. Нужно, чтобы метод getTokens(String, String) возвращал массив типа String, заполненный согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "com.javarush.task.pro.task09.task0915";
        String[] tokens = getTokens(packagePath, ".a");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] result = new String[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            result[i++] = tokenizer.nextToken();
        }
        return result;
    }
}
