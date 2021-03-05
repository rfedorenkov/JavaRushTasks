package com.javarush.task.jdk13.task02.task0218;

/**
 * Дублирование строки
 * Реализуй метод print3. Метод должен вывести на экран переданную строку 3 раза. Каждый раз - с новой строки.
 *
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Метод main не должен вызывать функцию System.out.println или System.out.print.
 * 3. Метод print3 должен выводить текст на экран.
 * 4. Метод main должен вызвать метод print3 только один раз.
 * 5. Метод print3 должен выводить на экран строку 3 раза. Каждый раз - с новой строки.
*/

public class Solution {
    public static void print3(String text) {
        for (int i = 0; i < 3; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        print3("I love you!");
    }
}
