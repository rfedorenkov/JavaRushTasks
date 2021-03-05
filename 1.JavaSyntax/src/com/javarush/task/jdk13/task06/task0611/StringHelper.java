package com.javarush.task.jdk13.task06.task0611;

/**
 * Класс StringHelper
 * В классе StringHelper реализуй два статических метода:
 *
 * String multiply(String s, int count) – возвращает строку, повторенную count раз;
 * String multiply(String s) – возвращает строку, повторенную 5 раз.
 * Пример:
 * Амиго -> АмигоАмигоАмигоАмигоАмиго
 *
 *
 * Требования:
 * 1. Методы класса StringHelper должны возвращать строку.
 * 2. Методы класса StringHelper должны быть статическими.
 * 3. Методы класса StringHelper должны быть public.
 * 4. Метод multiply(String s, int count) должен возвращать строку, повторенную count раз.
 * 5. Метод multiply(String s) должен возвращать строку, повторенную 5 раз.
*/

public class StringHelper {
    public static String multiply(String text) {
        return multiply(text, 5);
    }

    public static String multiply(String text, int count) {
        return String.valueOf(text).repeat(count);
    }

    public static void main(String[] args) {

    }
}
