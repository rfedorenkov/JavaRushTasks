package com.javarush.task.jdk13.task07.task0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Самая короткая строка
 * 1. Создай список строк.
 * 2. Считай с клавиатуры 5 строк и добавь в список.
 * 3. Используя цикл, найди самую короткую строку в списке.
 * 4. Выведи найденную строку на экран.
 * 5. Если таких строк несколько, выведи каждую с новой строки.
 *
 * Требования:
 * 1. Создай объект типа список строк.
 * 2. Программа должна считывать 5 строк с клавиатуры и записывать их в список.
 * 3. Программа должна выводить самую короткую строку на экран.
 * 4. Если есть несколько строк с длиной равной минимальной, то нужно вывести каждую из них с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            strings.add(br.readLine());
        }

        int min = strings.get(0).length();
        for (String string : strings) {
            if (string.length() < min) {
                min = string.length();
            }
        }

        for (String string : strings) {
            if (string.length() == min) {
                System.out.println(string);
            }
        }
    }
}
