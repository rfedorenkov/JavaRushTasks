package com.javarush.task.task19.task1909;

import java.io.*;

/**
 * Замена знаков
 * Считать с консоли 2 имени файла.
 * Первый Файл содержит текст.
 * Считать содержимое первого файла и заменить все точки "." на знак "!".
 * Результат вывести во второй файл.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
 * 2. BufferedReader для считывания данных с консоли должен быть закрыт.
 * 3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
 * 4. Поток чтения из файла (BufferedReader) должен быть закрыт.
 * 5. Программа должна записывать во второй файл содержимое первого файла,
 * где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
 * 6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String fileOne = br.readLine();
            String fileTwo = br.readLine();

            try (BufferedReader reader = new BufferedReader(new FileReader(fileOne));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(fileTwo))) {
                while (reader.ready()) {
                    String s = reader.readLine().replaceAll("\\.", "!");
                    writer.write(s);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
