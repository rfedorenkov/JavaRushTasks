package com.javarush.task.task26.task2613.exception;

/**
 * Класс исключений, когда не сможем выдать запрашиваемую сумму.
 */
public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
    }

    public NotEnoughMoneyException(String message) {
        super(message);
    }
}