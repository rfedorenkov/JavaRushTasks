package com.javarush.task.task19.task1923;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Слова с цифрами
 * В метод main первым параметром приходит имя файла1, вторым - файла2.
 * Файл1 содержит строки со словами, разделенными пробелом.
 * Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа НЕ должна считывать данные с консоли.
 * 2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
 * 3. Поток чтения из файла (FileReader) должен быть закрыт.
 * 4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
 * 5. Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             FileWriter writer = new FileWriter(args[1])) {

            StringBuilder data = new StringBuilder();
            Pattern pattern = Pattern.compile("\\p{Digit}");

            while (reader.ready()) {
                String[] arr = reader.readLine().split(" ");
                for (String s : arr) {
                    if (pattern.matcher(s).find()) {
                        data.append(s);
                        data.append(" ");
                    }
                }
            }

            writer.write(data.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
