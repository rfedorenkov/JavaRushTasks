package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;

/**
 * Встречаемость символов
 * Программа запускается с одним параметром - именем файла, который содержит английский текст.
 * Посчитать частоту встречания каждого символа.
 * Отсортировать результат по возрастанию кода ASCII (почитать в инете).
 *
 * Пример:
 * ','=44, 's'=115, 't'=116.
 *
 * Вывести на консоль отсортированный результат:
 * [символ1] частота1
 * [символ2] частота2
 * Закрыть потоки.
 *
 * Пример вывода:
 * , 19
 * - 7
 * f 361
 *
 *
 * Требования:
 * 1. Считывать с консоли ничего не нужно.
 * 2. Создай поток для чтения из файла, который приходит первым параметром в main.
 * 3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
 * 4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
 * 5. Поток для чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {

        String filename = args[0];

        int[] ascii = new int[128];

        try (FileReader reader = new FileReader(filename)) {
            while (reader.ready()) {
                ascii[reader.read()]++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] != 0) {
                System.out.println((char) i + " " + ascii[i]);
            }
        }
    }
}
