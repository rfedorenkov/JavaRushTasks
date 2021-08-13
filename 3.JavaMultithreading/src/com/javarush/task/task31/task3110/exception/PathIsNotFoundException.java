package com.javarush.task.task31.task3110.exception;

/**
 * Класс, который отвечает за ошибки в пути распаковки архива,
 * или путь к файлу, который будет заархивирован, или любой
 * другой путь.
 */
public class PathIsNotFoundException extends Exception {
    public PathIsNotFoundException() {
    }

    public PathIsNotFoundException(String message) {
        super(message);
    }
}
