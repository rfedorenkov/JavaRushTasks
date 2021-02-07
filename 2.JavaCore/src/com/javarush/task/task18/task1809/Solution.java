package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/**
 * Реверс файла
 * Считать с консоли 2 имени файла: файл1, файл2.
 * Записать в файл2 все байты из файл1, но в обратном порядке.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна два раза считать имена файлов с консоли.
 * 2. Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
 * 3. Во второй файл нужно записать все байты из первого в обратном порядке.
 * 4. Потоки FileInputStream и FileOutputStream должны быть закрыты.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileOne = scanner.next();
        String fileTwo = scanner.next();

        try (FileInputStream fis = new FileInputStream(fileOne);
             FileOutputStream fos = new FileOutputStream(fileTwo)) {

            byte[] buffer = new byte[fis.available()];
            int read = fis.read(buffer);
            for (int i = read - 1; i >= 0; i--) {
                fos.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
