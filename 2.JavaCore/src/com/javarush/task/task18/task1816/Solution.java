package com.javarush.task.task18.task1816;

import java.io.FileReader;
import java.io.IOException;

/**
 * Английские буквы
 * В метод main первым параметром приходит имя файла.
 * Посчитать количество букв английского алфавита, которое есть в этом файле.
 * Вывести на экран число (количество букв).
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Считывать с консоли ничего не нужно.
 * 2. Создай поток чтения из файла, который приходит первым параметром в main.
 * 3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
 * 4. Нужно учитывать заглавные и строчные буквы.
 * 5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {

        try (FileReader reader = new FileReader(args[0])) {
            int countEnglishLetters = 0;

            while (reader.ready()) {
                char c = (char) reader.read();

                if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
                    countEnglishLetters++;
                }

            }
            System.out.println(countEnglishLetters);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
