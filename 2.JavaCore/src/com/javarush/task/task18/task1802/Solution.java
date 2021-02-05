package com.javarush.task.task18.task1802;

import java.io.*;
import java.util.Scanner;

/**
 * Минимальный байт
 * Ввести с консоли имя файла.
 * Найти минимальный байт в файле, вывести его на экран.
 * Закрыть поток ввода-вывода.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль должен выводиться минимальный байт, считанный из файла.
 * 4. Поток чтения из файла должен быть закрыт.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        scanner.close();

        System.out.println(getMinByteFromFile(fileName));

    }

    public static byte getMinByteFromFile(String fileName) {
        byte min = Byte.MAX_VALUE;
        try (InputStreamReader is = new InputStreamReader(new FileInputStream(fileName))) {
            while (is.ready()) {
                byte b = (byte) is.read();
                if (min > b) {
                    min = b;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return min;
    }

}
