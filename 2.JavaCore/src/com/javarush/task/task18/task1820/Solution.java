package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Scanner;

/**
 * Округление чисел
 * Считать с консоли 2 имени файла.
 * Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
 * Округлить числа до целых и записать через пробел во второй файл.
 * Закрыть потоки.
 *
 * Принцип округления:
 * 3.49 => 3
 * 3.50 => 4
 * 3.51 => 4
 * -3.49 => -3
 * -3.50 => -3
 * -3.51 => -4
 *
 *
 * Требования:
 * 1. Программа должна два раза считать имена файлов с консоли.
 * 2. Для первого файла создай поток для чтения. Для второго - поток для записи.
 * 3. Считать числа из первого файла, округлить их и записать через пробел во второй.
 * 4. Должны соблюдаться принципы округления, указанные в задании.
 * 5. Созданные для файлов потоки должны быть закрыты.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileLoad = scanner.next();
        String fileSave = scanner.next();

        try (Scanner reader = new Scanner(new FileReader(fileLoad));
             PrintWriter writer = new PrintWriter(new FileWriter(fileSave))) {

            while (reader.hasNextLine()) {
                for (String value : reader.nextLine().split(" ")) {
                    double number = Double.parseDouble(value);
                    long roundedNumber = Math.round(number);
                    writer.print(roundedNumber + " ");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
