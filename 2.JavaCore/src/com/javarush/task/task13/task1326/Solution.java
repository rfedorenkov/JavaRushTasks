package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/**
 * Сортировка четных чисел из файла
 * В этой задаче тебе нужно:
 * Ввести имя файла с консоли.
 * Прочитать из него набор чисел.
 * Вывести в консоли только четные, отсортированные по возрастанию.
 * Пример ввода:
 * 5
 * 8
 * -2
 * 11
 * 3
 * -5
 * 2
 * 10
 *
 * Пример вывода:
 * -2
 * 2
 * 8
 * 10
 *
 *
 * Требования:
 * 1. Программа должна считывать данные с консоли.
 * 2. Программа должна создавать FileInputStream для введенной с консоли строки.
 * 3. Программа должна выводить данные на экран.
 * 4. Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
 * 5. Программа должна закрывать поток чтения из файла — FileInputStream.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();
        scanner.close();

        ArrayList<Integer> evenNumbers = new ArrayList<>();

        try(Scanner reader = new Scanner(new FileInputStream(fileName))) {
            while (reader.hasNext()) {
                int number = reader.nextInt();
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        evenNumbers.sort(Integer::compareTo);
        evenNumbers.forEach(System.out::println);
    }
}
