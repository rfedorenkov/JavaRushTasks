package com.javarush.task.task33.task3310;

/**
 * Класс для логирования исключений.
 */
public class ExceptionHandler {
    public static void log(Exception e) {
        System.out.println(e.getMessage());
    }
}