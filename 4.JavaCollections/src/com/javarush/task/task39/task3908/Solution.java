package com.javarush.task.task39.task3908;

/**
 * Возможен ли палиндром?
 * Реализуй метод isPalindromePermutation(String s) который будет возвращать true,
 * если из всех символов строки s можно составить палиндром. Иначе - false.
 *
 * Символы в анализируемой строке ограничены кодировкой ASCII.
 * Регистр букв не учитывается.
 *
 *
 * Requirements:
 * 1. Метод isPalindromePermutation должен возвращать true,
 * если выполнив перестановку символов входящей строки можно получить палиндром.
 * 2. Метод isPalindromePermutation должен возвращать false,
 * если выполнив перестановку символов входящей строки получить палиндром невозможно.
 * 3. Метод isPalindromePermutation должен быть публичным.
 * 4. Метод isPalindromePermutation должен быть статическим.
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isPalindromePermutation(String s) {
        int xor = 0, mask;
        for (int i = 0; i < s.length(); i++)
        {
            int x = s.charAt(i) - 'a';
            mask = 1 << x;
            xor = xor ^ mask;
        }

        return (xor & (xor - 1)) == 0;
    }
}