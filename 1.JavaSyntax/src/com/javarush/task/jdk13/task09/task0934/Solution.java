package com.javarush.task.jdk13.task09.task0934;

/**
 * Палиндром слова
 * Реализуй метод isPalindrome(String) чтобы он проверял является ли палиндромом слово,
 * полученное входящим параметром. Палиндром - слово, одинаково читающееся в обоих направления.
 * Регистр букв не учитывай.
 *
 * Требования:
 * 1. Нужно чтобы метод isPalindrome(String) возвращал true, если полученное слово
 * палиндром и false - если не палиндром.
*/

public class Solution {
    public static void main(String[] args) {
        String word = "Ротор";
        String answer = isPalindrome(word) ? "Да" : "Нет";
        System.out.println("Слово \"" + word + "\" палиндром? " + answer);
    }

    public static boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}
