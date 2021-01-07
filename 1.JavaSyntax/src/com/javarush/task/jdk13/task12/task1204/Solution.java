package com.javarush.task.jdk13.task12.task1204;

/**
 * Числа и строки
 * Метод add должен складывать входящие аргуметы и возвращать строку вида:
 * a+b=sum
 *
 * Например, если передать в метод (7, 8), он должен вернуть строку 7+8=15.
 *
 * Но сейчас метод работает неправильно. Твоя задача его починить.
 *
 *
 * Требования:
 * 1. Метод add должен возвращать строку согласно условию.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(add(5, 0)); // 5+0=5
        System.out.println(add(6, 18)); // 6+18=24
        System.out.println(add(53, 148)); // 53+148=201
        System.out.println(add(236, 4667)); // 236+4667=4903
    }

    public static String add(int a, int b) {
        return a + "+" + b + "=" + (a + b);
    }
}
