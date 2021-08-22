package com.javarush.task.task29.task2912;

/**
 * Телефонное логгирование
 */
public class PhoneLogger extends AbstractLogger {

    public PhoneLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}