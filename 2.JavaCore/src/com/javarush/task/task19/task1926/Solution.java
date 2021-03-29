package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Перевертыши
 * 1. Считать с консоли имя файла. Считать содержимое файла.
 * 2. Для каждой строки в файле:
 * 2.1. переставить все символы в обратном порядке.
 * 2.2. вывести на экран.
 * 3. Закрыть потоки.
 *
 * Пример тела входного файла:
 * я - программист.
 * Амиго
 *
 * Пример результата:
 * .тсиммаргорп - я
 * огимА
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли (используй BufferedReader).
 * 2. BufferedReader для считывания данных с консоли должен быть закрыт.
 * 3. Программа должна считывать содержимое файла (используй FileReader).
 * 4. Поток чтения из файла (FileReader) должен быть закрыт.
 * 5. Программа должна выводить в консоль все символы из файла в обратном порядке.
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(console.readLine()))) {
            while (reader.ready()) {
                System.out.println(new StringBuilder(reader.readLine()).reverse());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
