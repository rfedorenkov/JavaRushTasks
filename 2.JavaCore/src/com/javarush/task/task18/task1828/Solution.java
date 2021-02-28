package com.javarush.task.task18.task1828;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Прайсы 2
 * CrUD для таблицы внутри файла
 * Считать с консоли имя файла для операций CrUD
 *
 * Программа запускается с одним из следующих наборов параметров:
 * -u id productName price quantity
 * -d id
 *
 * Значения параметров:
 * где id - 8 символов
 * productName - название товара, 30 символов
 * price - цена, 8 символов
 * quantity - количество, 4 символа
 * -u - обновляет данные товара с заданным id
 * -d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
 *
 * В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
 * id productName price quantity
 * Данные дополнены пробелами до их длины
 *
 * Пример:
 * 19847   Шорты пляжные синие           159.00  12
 * 198479  Шорты пляжные черные с рисунко173.00  17
 * 19847983Куртка для сноубордистов, разм10173.991234
 *
 *
 * Требования:
 * 1. Программа должна считать имя файла для операций CrUD с консоли.
 * 2. При запуске программы без параметров список товаров должен остаться неизменным.
 * 3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
 * 4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
 * 5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    private static final Map<String, String> PRODUCTS = new LinkedHashMap<>();
    public static void main(String[] args) {

        if (args.length != 0) {
            Scanner scanner = new Scanner(System.in);
            String filename = scanner.nextLine();

            loadData(filename);

            if (args[0].equals("-d")) {
                deleteCrud(args);
            } else if (args[0].equals("-u")) {
                upgradeCrud(args);
            }

            saveData(filename);
        }
    }

    private static void loadData(String filename) {
        try (Scanner reader = new Scanner(new FileReader(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String id = line.substring(0, 8).trim();
                PRODUCTS.put(id, line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveData(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String value : PRODUCTS.values()) {
                writer.write(value);
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteCrud(String[] args) {
        PRODUCTS.remove(args[1]);
    }

    private static void upgradeCrud(String[] args) {
        String id = args[1];
        String productName = args[2].length() < 30 ? args[2] : args[2].substring(0, 30);
        String productPrice = args[3];
        String productCount = args[4];

        String newValue = String.format("%-8s%-30s%-8s%-4s", id, productName, productPrice, productCount);

        if (PRODUCTS.containsKey(id)) {
            PRODUCTS.put(id, newValue);
        }
    }
}
