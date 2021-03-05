package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Максимальный байт
 * Ввести с консоли имя файла.
 * Найти максимальный байт в файле, вывести его на экран.
 * Закрыть поток ввода-вывода.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль должен выводиться максимальный байт, считанный из файла.
 * 4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        scanner.close();

        System.out.println(getMaxByteFromFile(filename));


    }

    public static byte getMaxByteFromFile(String filename) throws IOException {
        try (FileInputStream fis = new FileInputStream(filename)) {
            byte max = Byte.MIN_VALUE;
            while (fis.available() > 0) {
                byte b = (byte) fis.read();
                if (max < b) {
                    max = b;
                }
            }
            return max;
        }
    }
}
