package com.javarush.task.task18.task1803;

import java.io.*;
import java.util.*;

/**
 * Самые частые байты
 * Ввести с консоли имя файла.
 * Найти байт или байты с максимальным количеством повторов.
 * Вывести их на экран через пробел.
 * Закрыть поток ввода-вывода.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
 * 4. Данные в консоль должны выводится в одну строку.
 * 5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        scanner.close();

        byte[] bytes = new byte[256];

        try (FileInputStream fis = new FileInputStream(filename)) {
            while (fis.available() > 0) {
                bytes[fis.read()] += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte max = bytes[0];
        for (byte b : bytes) {
            if (b > max) {
                max = b;
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
