package com.javarush.task.task22.task2203;

/**
 * Между табуляциями
 * Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
 * На некорректные данные бросить исключение TooShortStringException.
 * Класс TooShortStringException не менять.
 *
 *
 * Требования:
 * 1. Класс TooShortStringException должен быть потомком класса Exception.
 * 2. Метод getPartOfString должен принимать строку в качестве параметра.
 * 3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций
 * должно возникнуть исключение TooShortStringException.
 * 4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            int first = string.indexOf("\t") + 1;
            int second = string.indexOf("\t", first);
            return string.substring(first, second);
        } catch (StringIndexOutOfBoundsException | NullPointerException e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }
}
