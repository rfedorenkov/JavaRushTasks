package com.javarush.task.jdk13.task01.task0117;

/**
 * Исправь программу
 * Внеси изменения в программу, чтобы на экран выводился текст: "Coding in java". Используй переменные.
 *
 *
 * Требования:
 * 1. Должно быть объявлено 3 переменных.
 * 2. Всем переменным должны быть присвоены значения сразу после создания.
 * 3. Команду вывода текста на экран изменять нельзя.
 * 4. Программа должна выводить текст "Coding in java".
*/

public class Solution {
    public static void main(String[] args) {
        String string1 = "Coding";
        String string2 = "in";
        String string3 = "java";
        System.out.println(string1 + " " + string2 + " " + string3);
    }
}
