package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

/**
 * Использование TreeSet
 * Первым параметром приходит имя файла: файл1.
 * файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
 * Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
 * Если файл1 содержит менее 5 различных букв, то выведи их все.
 * Буквы различного регистра считаются одинаковыми.
 * Регистр выводимых букв не влияет на результат.
 * Закрой потоки.
 *
 * Пример 1 данных входного файла:
 * zBk yaz b-kN
 *
 * Пример 1 вывода:
 * abkny
 *
 * Пример 2 данных входного файла:
 * caAC
 * A, aB? bB
 *
 * Пример 2 вывода:
 * abc
 *
 * Подсказка: использовать TreeSet
 *
 *
 * Requirements:
 * 1. Программа должна использовать класс TreeSet.
 * 2. У объекта типа TreeSet вызови метод add для добавления элементов.
 * 3. Программа должна выводить результат на экран.
 * 4. Вывод программы должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<Character> set = new TreeSet<>();
        final List<String> strings = Files.readAllLines(Paths.get(args[0]));
        for (String string : strings) {
            final char[] chars = string.toLowerCase()
                    .replaceAll("\\P{Alpha}", "")
                    .toCharArray();
            for (char c : chars) {
                set.add(c);
            }
        }
        set.stream()
                .limit(5)
                .forEach(System.out::print);
    }
}
