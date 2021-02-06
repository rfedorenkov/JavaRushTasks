package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Самые редкие байты
 * Ввести с консоли имя файла.
 * Найти байт или байты с минимальным количеством повторов.
 * Вывести их на экран через пробел.
 * Закрыть поток ввода-вывода.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
 * 4. Данные в консоль должны выводится в одну строку.
 * 5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        scanner.close();

        int[] bytes = new int[256];

        try (FileInputStream fis = new FileInputStream(filename)) {
            while (fis.available() > 0) {
                bytes[fis.read()] += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int min = Integer.MAX_VALUE;
        for (int b : bytes) {
            if (b > 0 && min > b) {
                min = b;
            }
        }

        for (int i = 0; i < bytes.length; i++) {
            if (min == bytes[i]) {
                System.out.print(i + " ");
            }

        }
    }
}