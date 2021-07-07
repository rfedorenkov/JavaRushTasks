package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/**
 * Составить цепочку слов
 * В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
 * В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква
 * данного слова совпадала с первой буквой следующего не учитывая регистр.
 * Каждое слово должно участвовать 1 раз.
 * Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
 * Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
 * Слова разделять пробелом.
 * Вывести полученную строку на экран.
 *
 * Пример тела входного файла:
 * Киев Нью-Йорк Амстердам Вена Мельбурн
 *
 * Результат:
 * Амстердам Мельбурн Нью-Йорк Киев Вена
 * или
 * Вена Амстердам Мельбурн Нью-Йорк Киев
 * или
 * Мельбурн Нью-Йорк Киев Вена Амстердам
 * и т.п.
 *
 *
 * Requirements:
 * 1. Метод main должен считывать имя файла с клавиатуры.
 * 2. В классе Solution не должно быть статических полей.
 * 3. В методе getLine должен быть использован StringBuilder.
 * 4. Метод getLine должен возвращать пустую строку (пустой StringBuilder) в случае
 * если ему не были переданы параметры (слова).
 * 5. Метод getLine не должен изменять переданные ему параметры (слова).
 * 6. Все слова переданные в метод getLine должны быть включены в результирующую строку.
 * 7. Вывод на экран должен соответствовать условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        String line = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String filename = reader.readLine();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
                while (fileReader.ready()) {
                    line = fileReader.readLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        StringBuilder result = getLine(line.split(" "));
        System.out.println(result);
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = new StringBuilder();
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));

        while (isValid(wordsList)) {
            Collections.shuffle(wordsList);
        }

        wordsList.forEach(s -> result.append(s).append(" "));
        return result;
    }

    private static boolean isValid(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i).toLowerCase();
            String seconds = list.get(i + 1).toLowerCase();
            if (first.charAt(first.length() - 1) != seconds.charAt(0)) {
                return true;
            }
        }
        return false;
    }
}