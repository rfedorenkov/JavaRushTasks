package com.javarush.task.task29.task2912;

/**
 * Логировать в консоль
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to console: " + message);
    }
}