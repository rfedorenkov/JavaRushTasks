package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вспомогательный класс, для чтения или записи в консоль.
 */
public class ConsoleHelper {
    private final static String TEXT_INPUT_ERROR = "Произошла ошибка при попытке ввода текста. Попробуйте еще раз.";
    private final static String NUMBER_INPUT_ERROR = "Произошла ошибка при попытке ввода числа. Попробуйте еще раз.";

    private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Метод выводит сообщение message в консоль.
     *
     * @param message Сообщение.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Метод считывает строку с консоли.
     *
     * @return Возвращает прочитанную строку.
     */
    public static String readString() {
        try {
            return console.readLine();
        } catch (IOException e) {
            writeMessage(TEXT_INPUT_ERROR);
            return readString();
        }
    }

    /**
     * Метод возвращает введенное число.
     *
     * @return Возвращает прочитанное число.
     */
    public static int readInt() {
        try {
            return Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            System.out.println(NUMBER_INPUT_ERROR);
            return readInt();
        }
    }
}