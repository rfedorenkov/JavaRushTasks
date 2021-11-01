package com.javarush.task.task26.task2613.exception;

/**
 * Класс исключений, когда нужно прервать текущую операцию и выйти из приложения.
 */
public class InterruptOperationException extends Exception {
    public InterruptOperationException() {
    }

    public InterruptOperationException(String message) {
        super(message);
    }
}