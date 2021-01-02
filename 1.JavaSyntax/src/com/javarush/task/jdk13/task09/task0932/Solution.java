package com.javarush.task.jdk13.task09.task0932;

/**
 * Количество слов в строке
 * Реализуй метод wordsCount(String) чтобы он возвращал количество слов в строке, полученной входящим параметром.
 * Подсказка: Слово - это последовательность символов не пробелов, которые разделены одним пробелом.
 *
 * Требования:
 * 1. Нужно, чтобы метод wordsCount(String) возвращал количество слов в строке, полученной входящим параметром.
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Кто желает поработать?";
        int wordsCount = wordsCount(string);
        System.out.println("Количество слов в строке \"" + string + "\" равно " + wordsCount);
    }

    public static int wordsCount(String string) {
        return string.split(" +").length;
    }
}
