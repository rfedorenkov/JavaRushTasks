package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс для работы с консолью.
 */
public class ConsoleHelper {
    private static Scanner console = new Scanner(System.in);

    /**
     * Выводит сообщение в консоль.
     *
     * @param message Сообщение.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Метод читает с консоли строку.
     *
     * @return Возвращает считанную строку.
     */
    public static String readString() {
        return console.nextLine();
    }

    /**
     * Метод считывает с консоли число.
     *
     * @return Возвращает считанное число.
     */
    public static int readInt() {
        try {
            return Integer.parseInt(readString().trim());
        } catch (NumberFormatException e) {
            writeMessage("Недопустимое число. Попробуйте снова.");
            return readInt();
        }
    }
}
