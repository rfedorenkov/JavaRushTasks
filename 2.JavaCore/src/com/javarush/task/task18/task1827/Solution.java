package com.javarush.task.task18.task1827;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Прайсы
 * CrUD для таблицы внутри файла.
 * Считать с консоли имя файла для операций CrUD.
 *
 * Программа запускается со следующим набором параметров:
 * -c productName price quantity
 *
 * Значения параметров:
 * где id - 8 символов.
 * productName - название товара, 30 символов.
 * price - цена, 8 символов.
 * quantity - количество, 4 символа.
 * -c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
 * инкрементируя максимальный id, найденный в файле.
 *
 * В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
 * id productName price quantity
 *
 * Данные дополнены пробелами до их длины.
 *
 * Пример:
 * 19846   Шорты пляжные синие           159.00  12
 * 198478  Шорты пляжные черные с рисунко173.00  17
 * 19847983Куртка для сноубордистов, разм10173.991234
 *
 *
 * Требования:
 * 1. Программа должна считать имя файла для операций CrUD с консоли.
 * 2. В классе Solution не должны быть использованы статические переменные.
 * 3. При запуске программы без параметров список товаров должен остаться неизменным.
 * 4. При запуске программы с параметрами "-c productName price quantity" в конец файла должна
 * добавится новая строка с товаром.
 * 5. Товар должен иметь следующий id, после максимального, найденного в файле.
 * 6. Форматирование новой строки товара должно четко совпадать с указанным в задании.
 * 7. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        if (args.length != 0) {
            addCrud(args);
        }
    }

    private static void addCrud(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        int productID = 0;

        try (Scanner reader = new Scanner(new FileInputStream(filename))) {
            while (reader.hasNextLine()) {
                String s = reader.nextLine();
                int n = Integer.parseInt(s.substring(0, 8).trim());
                if (n >= productID) {
                    productID = n;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String productName = args[1].length() < 30 ? args[1] : args[1].substring(0, 30);
        String productPrice = args[2];
        String productCount = args[3];
        String value = String.format("%n%-8d%-30s%-8s%-4s", ++productID, productName, productPrice, productCount);
        try (FileWriter write = new FileWriter(filename, true)) {
            write.append(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
