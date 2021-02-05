package com.javarush.task.task18.task1807;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Подсчет запятых
 * С консоли считать имя файла.
 * Посчитать в файле количество символов ',', количество вывести на консоль.
 * Закрыть потоки.
 *
 * Подсказка:
 * нужно сравнивать с ascii-кодом символа ','.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль должно выводится число запятых в считанном файле.
 * 4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        scanner.close();

        try (Scanner scan = new Scanner(new FileInputStream(fileName))) {
            int count = 0;
            while (scan.hasNext()) {
                for (char c : scan.next().toCharArray()) {
                    if (c == ',') {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
