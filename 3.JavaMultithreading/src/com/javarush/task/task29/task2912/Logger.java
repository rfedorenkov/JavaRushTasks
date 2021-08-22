package com.javarush.task.task29.task2912;

/**
 * Интерфейс логгирования
 */
public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}