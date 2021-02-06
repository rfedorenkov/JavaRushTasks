package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Сортировка байт
 * Ввести с консоли имя файла.
 * Считать все байты из файла.
 * Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
 * Вывести на экран.
 * Закрыть поток ввода-вывода.
 *
 * Пример байт входного файла:
 * 44 83 44
 *
 * Пример вывода:
 * 44 83
 *
 *
 * Требования:
 * 1. Программа должна считывать имя файла с консоли.
 * 2. Для чтения из файла используй поток FileInputStream.
 * 3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
 * 4. Данные в консоль должны выводится в одну строку.
 * 5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();

        Set<Integer> bytes = new TreeSet<>();

        try (FileInputStream fis = new FileInputStream(filename)) {
            while (fis.available() > 0) {
                bytes.add(fis.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        bytes.stream().map(b -> b + " ").forEach(System.out::print);
    }
}
