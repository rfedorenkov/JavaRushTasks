package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.Scanner;

/**
 * Поиск данных внутри файла
 * Считать с консоли имя файла.
 * Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
 * Программа запускается с одним параметром: id (int).
 * Закрыть потоки.
 *
 * В файле данные разделены пробелом и хранятся в следующей последовательности:
 * id productName price quantity
 * где id - int.
 * productName - название товара, может содержать пробелы, String.
 * price - цена, double.
 * quantity - количество, int.
 *
 * Информация по каждому товару хранится в отдельной строке.
 *
 *
 * Требования:
 * 1. Программа должна считать имя файла с консоли.
 * 2. Создай для файла поток для чтения.
 * 3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
 * 4. Поток для чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filename = scanner.next();
        String id = args[0];

        try (Scanner reader = new Scanner(new FileReader(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.startsWith(id + " ")) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
