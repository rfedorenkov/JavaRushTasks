package com.javarush.task.pro.task09.task0919;

/**
 * Разворот строки
 * Используя StringBuilder в методе reverseString(String), разверни строку, полученную как параметр.
 *
 *
 * Требования:
 * 1. Нужно, чтобы метод reverseString(String) использовал StringBuilder.
 * 2. Нужно, чтобы метод reverseString(String) возвращал развернутую строку.
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Ходит кот задом наперед";
        System.out.println(string);
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        return new StringBuilder(string).reverse().toString();
    }
}
