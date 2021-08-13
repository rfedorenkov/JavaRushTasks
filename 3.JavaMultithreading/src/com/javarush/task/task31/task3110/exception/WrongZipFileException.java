package com.javarush.task.task31.task3110.exception;

/**
 * Класс, который отвечает за ошибки, если будет
 * попытка сделать что-нибудь с архивом, которого не существует.
 */
public class WrongZipFileException extends Exception {

    public WrongZipFileException() {
    }

    public WrongZipFileException(String message) {
        super(message);
    }
}
