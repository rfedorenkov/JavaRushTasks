package com.javarush.task.jdk13.task09.task0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Гласные и согласные буквы
 * Написать программу, которая вводит с клавиатуры строку текста.
 * Программа должна вывести на экран две строки:
 * 1. первая строка содержит только гласные буквы из введённой строки.
 * 2. вторая - только согласные буквы и знаки препинания из введённой строки.
 * Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
 * Пример ввода: Мама мыла раму.
 * Пример вывода: а а ы а а у М м м л р м .
 *
 * Требования:
 * 1. Программа должна считывать данные с клавиатуры.
 * 2. Программа должна выводить две строки.
 * 3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
 * 4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
 * 5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = br.readLine();
            StringBuilder vowels = new StringBuilder();
            StringBuilder others = new StringBuilder();

            for (char c : line.replace(" ", "").toCharArray()) {
                if (isVowel(c)) {
                    vowels.append(c).append(" ");
                } else {
                    others.append(c).append(" ");
                }
            }
            System.out.println(vowels);
            System.out.println(others);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char character) {
        character = Character.toLowerCase(character);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char vowel : vowels) {  // ищем среди массива гласных
            if (character == vowel) {
                return true;
            }
        }
        return false;
    }
}