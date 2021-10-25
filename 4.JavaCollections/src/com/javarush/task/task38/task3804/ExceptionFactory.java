package com.javarush.task.task38.task3804;

public class ExceptionFactory {
    public static Throwable getException(Enum e) {
        if (e != null) {
            String message = e.toString().replaceAll("_", " ");
            message = message.charAt(0) + message.substring(1).toLowerCase();
            if (e instanceof ApplicationExceptionMessage) {
                return new Exception(message);
            } else if (e instanceof DatabaseExceptionMessage) {
                return new RuntimeException(message);
            } else if (e instanceof UserExceptionMessage) {
                return new Error(message);
            }
        }
        return new IllegalArgumentException();
    }
}