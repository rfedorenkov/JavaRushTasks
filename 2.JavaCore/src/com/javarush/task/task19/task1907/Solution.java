package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.Scanner;

/**
 * Считаем слово
 * Считать с консоли имя файла.
 * Файл содержит слова, разделенные знаками препинания.
 * Вывести в консоль количество слов "world", которые встречаются в файле.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли (используй BufferedReader).
 * 2. BufferedReader для считывания данных с консоли должен быть закрыт.
 * 3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
 * 4. Поток чтения из файла (FileReader) должен быть закрыт.
 * 5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String filename = br.readLine();
            try (Scanner reader = new Scanner(new FileReader(filename))) {
                int count = 0;
                while (reader.hasNextLine()) {
                    String line = reader.nextLine().replaceAll("\\p{P}", " ");
                    for (String s : line.split(" ")) {
                        if ("world".equals(s)) {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
