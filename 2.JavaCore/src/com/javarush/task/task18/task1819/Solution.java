package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.Scanner;

/**
 * Объединение файлов
 * Считать с консоли 2 имени файла.
 * В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна два раза считать имена файлов с консоли.
 * 2. Не используй в программе статические переменные.
 * 3. Для первого файла создай поток для чтения и считай его содержимое.
 * 4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
 * 5. Содержимое первого и второго файла нужно объединить в первом файле.
 * 6. Сначала должно идти содержимое второго файла, затем содержимое первого.
 * 7. Созданные для файлов потоки должны быть закрыты.
 */

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileOne = scanner.next();
        String fileTwo = scanner.next();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try (FileInputStream readerOne = new FileInputStream(fileOne);
             FileInputStream readerTwo = new FileInputStream(fileTwo)){

            while (readerTwo.available() > 0) {
                baos.write(readerTwo.read());
            }

            while (readerOne.available() > 0) {
                baos.write(readerOne.read());
            }
        }

        try (FileOutputStream writer = new FileOutputStream(fileOne)) {
            baos.writeTo(writer);
        }
    }
}
