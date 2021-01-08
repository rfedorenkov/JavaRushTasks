package com.javarush.task.jdk13.task07.task0712;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Минимальное или максимальное
 * 1. Проинициализируй поле strings в методе main.
 * 2. Добавь в список strings 10 строчек с клавиатуры.
 * 3. Узнай, какая строка в списке встретится раньше: самая короткая или самая длинная.
 * Если таких строк несколько, то должны быть учтены самые первые из них.
 * 4. Выведи на экран строку из п.3. Должна быть выведена одна строка.
 *
 * Требования:
 * 1. Поле strings типа список строк должно быть проинициализировано в методе main.
 * 2. Программа должна считывать 10 строк с клавиатуры и добавлять их в список.
 * 3. Программа должна выводить на экран самую короткую строку, если она была раньше самой длинной.
 * 4. Программа должна выводить на экран самую длинную строку, если она была раньше самой короткой.
 * 5. Должна быть выведена только одна строка.
*/

public class Solution {

    public static ArrayList<String> strings;

    public static void main(String[] args) {
        strings = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        IntStream.range(0, 10).forEach(i -> strings.add(scanner.next()));

        int min = strings.get(0).length();
        int max = min;

        for (String string : strings) {
            int length = string.length();
            if (min > length) {
                min = length;
            } else if (max < length) {
                max = length;
            }
        }

        for (String string : strings) {
            if (string.length() == max || string.length() == min) {
                System.out.println(string);
                return;
            }
        }
    }
}
