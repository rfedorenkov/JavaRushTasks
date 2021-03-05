package com.javarush.task.jdk13.task09.task0931;

/**
 * Удаление пробелов
 * Реализуй метод deleteSpaces(String) чтобы в строке, полученной входящим параметром, были удалены все пробелы.
 *
 * Требования:
 * 1. Нужно, чтобы метод deleteSpaces(String) удалял все пробелы из строки, полученной входящим параметром.
*/

public class Solution {
    public static void main(String[] args) {
        String stringWithoutSpaces = deleteSpaces("Добрый день! Как дела?");
        System.out.println(stringWithoutSpaces);
    }

    public static String deleteSpaces(String string) {
        return string.replaceAll(" ", "");
    }
}
