package com.javarush.task.task31.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * Читаем конфиги
 * Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
 * fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
 * Нужно обеспечить корректное чтение свойств.
 * При возникновении ошибок должен возвращаться пустой объект.
 * Метод main не участвует в тестировании.
 *
 * Подсказка: возможно тебе понадобится File.separator.
 *
 *
 * Requirements:
 * 1. Класс Solution должен содержать метод Properties getProperties(String fileName).
 * 2. Метод getProperties должен корректно считывать свойства из xml-файла.
 * 3. Метод getProperties должен корректно считывать свойства из любого другого файла с любым расширением.
 * 4. Метод getProperties должен возвращать пустой объект, если во время чтения свойств возникла ошибка.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution
                .getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution
                .getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution
                .getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(new File(fileName))) {
            if (fileName.endsWith(".xml")) {
                properties.loadFromXML(is);
            } else {
                properties.load(is);
            }
        } catch (IOException ignored) {
        }
        return properties;
    }
}
