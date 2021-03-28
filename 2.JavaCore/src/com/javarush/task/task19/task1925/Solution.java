package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Длинные слова
 * В метод main первым параметром приходит имя файла1, вторым - файла2.
 * Файл1 содержит слова, разделенные пробелом.
 * Записать через запятую в Файл2 слова, длина которых строго больше 6.
 * В конце файла2 запятой не должно быть.
 * Закрыть потоки.
 *
 * Пример выходных данных в файл2:
 * длинное,короткое,аббревиатура
 *
 *
 * Требования:
 * 1. Программа НЕ должна считывать данные с консоли.
 * 2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
 * 3. Поток чтения из файла (FileReader) должен быть закрыт.
 * 4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых
 * строго больше 6(используй FileWriter).
 * 5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                String[] words = reader.readLine().split(" ");
                for (String word : words) {
                    if (word.length() > 6) {
                        sb.append(word);
                        sb.append(",");
                    }
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            writer.write(sb.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
