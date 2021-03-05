package com.javarush.task.task15.task1527;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Парсер реквестов
 * Для решения этой задачи тебе нужно:
 * Считать с консоли URL-ссылку.
 * Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
 * URL содержит минимум 1 параметр.
 * Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
 * Если присутствует параметр obj, то передать его значение в нужный метод alert():
 * alert(double value) - для чисел (дробные числа разделяются точкой);
 * alert(String value) - для строк.
 * Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
 * Пример 1
 *
 * Ввод:
 * http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
 *
 * Вывод:
 * lvl view name
 *
 * Пример 2
 *
 * Ввод:
 * http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
 *
 * Вывод:
 * obj name
 * double: 3.14
 *
 *
 * Требования:
 * 1. Программа должна считывать с клавиатуры только одну строку.
 * 2. Класс Solution не должен содержать статические поля.
 * 3. Программа должна выводить данные на экран в соответствии с условием.
 * 4. Программа должна вызывать метод alert() с параметром double, если значение параметра obj
 * можно корректно преобразовать в число типа double.
 * 5. Программа должна вызывать метод alert() с параметром String, если значение параметра obj
 * нельзя корректно преобразовать в число типа double.
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.next();
        scanner.close();

        boolean isObject = false;
        String objectValue = "";
        StringBuilder sb = new StringBuilder();

        try {
            for (String s : new URL(url).getQuery().split("&")) {
                String[] split = s.split("=");

                if (split[0].equals("obj")) {
                    isObject = true;
                    objectValue = split[1];
                }

                sb.append(split[0]);
                sb.append(" ");
            }

            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);

            alert(isObject, objectValue);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private static void alert(boolean isObject, String objectValue) {
        if (isObject) {
            try {
                alert(Double.parseDouble(objectValue));
            } catch (NumberFormatException e) {
                alert(objectValue);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
