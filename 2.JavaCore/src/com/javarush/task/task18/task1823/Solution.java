package com.javarush.task.task18.task1823;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Нити и байты
 * Читайте с консоли имена файлов, пока не будет введено слово "exit".
 * Передайте имя файла в нить ReadThread.
 * Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
 * и добавить его в словарь resultMap,
 * где параметр String - это имя файла, параметр Integer - это искомый байт.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
 * 2. Для каждого файла создай нить ReadThread и запусти ее.
 * 3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
 * 4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
 * 5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String file = scanner.nextLine();
            if ("exit".equals(file)) {
                scanner.close();
                break;
            }
            new ReadThread(file);
        }
    }

    public static class ReadThread extends Thread {
        private final String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            int[] bytes = new int[256];

            try (FileInputStream fis = new FileInputStream(fileName)) {
                while (fis.available() > 0) {
                    int read = fis.read();
                    bytes[read]++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            int maxCount = 0;
            int maxCountByte = 0;

            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] > maxCount) {
                    maxCount = bytes[i];
                    maxCountByte = i;
                }
            }

            resultMap.put(fileName, maxCountByte);
        }
    }
}
