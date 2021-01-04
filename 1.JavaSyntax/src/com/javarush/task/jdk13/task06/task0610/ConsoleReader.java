package com.javarush.task.jdk13.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Класс ConsoleReader
 * В классе ConsoleReader реализуй четыре статических метода:
 *
 * String readString() – читает с клавиатуры строку;
 * int readInt() – читает с клавиатуры число;
 * double readDouble() – читает с клавиатуры дробное число;
 * boolean readBoolean() – читает с клавиатуры строку "true" или "false"
 * и возвращает соответствующую логическую переменную — true или false.
 * Внимание: создавай переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода.
 *
 * Требования:
 * 1. Метод readString должен считывать и возвращать строку (тип String).
 * 2. Метод readInt должен считывать и возвращать число (тип int).
 * 3. Метод readDouble должен считывать и возвращать дробное число (тип double).
 * 4. Метод readBoolean должен считывать и возвращать логическую переменную (тип boolean).
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static int readInt() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }

    public static double readDouble() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(br.readLine());

    }

    public static boolean readBoolean() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Boolean.parseBoolean(br.readLine());
    }

    public static void main(String[] args) throws Exception {

    }
}
