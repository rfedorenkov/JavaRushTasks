package com.javarush.task.task32.task3209;

/**
 * Класс обработки исключений.
 */
public class ExceptionHandler {

    /**
     * Метод выводит в консоль кратное описание исключения.
     *
     * @param e Исключение.
     */
    public static void log(Exception e) {
        System.out.println(e.toString());
    }
}