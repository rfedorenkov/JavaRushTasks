package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/**
 * Два в одном
 * Считать с консоли 3 имени файла.
 * Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна три раза считать имена файлов с консоли.
 * 2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
 * 3. Содержимое второго файла нужно переписать в первый файл.
 * 4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
 * 5. Созданные для файлов потоки должны быть закрыты.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileOne = scanner.next();
        String fileTwo = scanner.next();
        String fileThree = scanner.next();

        try (FileReader readerOne = new FileReader(fileTwo);
             FileReader readerTwo = new FileReader(fileThree);
             FileWriter writer = new FileWriter(fileOne)) {

            while (readerOne.ready()) {
                writer.write(readerOne.read());
            }

            while (readerTwo.ready()) {
                writer.write(readerTwo.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
