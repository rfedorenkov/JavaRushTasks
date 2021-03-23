package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Самый богатый
 * В метод main первым параметром приходит имя файла.
 * В этом файле каждая строка имеет следующий вид:
 * имя значение
 * где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.
 *
 * Для каждого имени посчитать сумму всех его значений.
 * Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
 * Имена разделять пробелом либо выводить с новой строки.
 * Закрыть потоки.
 *
 * Пример входного файла:
 * Петров 0.501
 * Иванов 1.35
 * Петров 0.85
 *
 * Пример вывода:
 * Петров
 *
 *
 * Требования:
 * 1. Программа НЕ должна считывать данные с консоли.
 * 2. Программа должна считывать содержимое файла (используй FileReader).
 * 3. Поток чтения из файла (FileReader) должен быть закрыт.
 * 4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> employees = readFileToMap(args[0]);

        Double maxSalary = employees.values()
                .stream()
                .filter(value -> value >= 0.0)
                .max(Double::compareTo).orElse(0.0);

        employees.entrySet()
                .stream()
                .filter(employee -> employee.getValue().equals(maxSalary))
                .forEach(employee -> System.out.println(employee.getKey()));

    }

    private static Map<String, Double> readFileToMap(String fileName) {
        Map<String, Double> map = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split(" ");
                map.merge(line[0], Double.valueOf(line[1]), Double::sum);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }
}
