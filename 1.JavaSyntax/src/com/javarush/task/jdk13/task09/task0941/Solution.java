package com.javarush.task.jdk13.task09.task0941;

import java.util.*;

/**
 * IPv6
 * В методе map распарсь строку представляющую IPv6-адрес и верни результат в виде массива строк.
 * Например, для входящей строки:
 * 2001:db8:11a3:9d7:1f34:8a2e:7a0:765d
 * нужно вернуть такой массив:
 * [2001, db8, 11a3, 9d7, 1f34, 8a2e, 7a0, 765d]
 *
 * Для парсинга строки используй StringTokenizer.
 *
 *
 * Требования:
 * 1. Метод map должен возвращать IPv6-адрес в виде массива строк согласно условию.
 * 2. Нужно использовать StringTokenizer.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(map("2001:db8:11a3:9d7:1f34:8a2e:7a0:765d")));
    }

    public static String[] map(String ipv6) {
        StringTokenizer tokenizer = new StringTokenizer(ipv6, ":");
        String[] result = new String[tokenizer.countTokens()];
        for (int i = 0; i < result.length; i++) {
            result[i] = tokenizer.nextToken();
        }
        return result;
    }
}
