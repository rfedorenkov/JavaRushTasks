package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Вспомогательный класс.
 */
public class Helper {

    /**
     * Метод генерирует случайную строку.
     *
     * @return Сгенерированная строка.
     */
    public static String generateRandomString() {
        return new BigInteger(130, new SecureRandom()).toString(36);
    }

    /**
     * Метод выводит переданное сообщение в консоль.
     *
     * @param message Сообщение.
     */
    static void  printMessage(String message) {
        System.out.println(message);
    }
}