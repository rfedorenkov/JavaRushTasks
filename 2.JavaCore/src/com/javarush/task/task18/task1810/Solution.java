package com.javarush.task.task18.task1810;

import java.io.*;
import java.util.Scanner;

/**
 * DownloadException
 * 1 Считывать с консоли имена файлов.
 * 2 Если файл меньше 1000 байт, то:
 * 2.1 Закрыть потоки работы с файлами.
 * 2.2 Выбросить исключение DownloadException.
 *
 *
 * Требования:
 * 1. Программа должна считать имена файлов с консоли.
 * 2. Для чтения из файлов используй поток FileInputStream.
 * 3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
 * 4. Программа должна завершиться исключением DownloadException.
 * 5. Поток FileInputStream должен быть закрыт.
 */

public class Solution {
    public static void main(String[] args) throws DownloadException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try (FileInputStream is = new FileInputStream(scanner.next())) {
                if (is.available() < 1000) {
                    throw new DownloadException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static class DownloadException extends Exception {

    }
}
