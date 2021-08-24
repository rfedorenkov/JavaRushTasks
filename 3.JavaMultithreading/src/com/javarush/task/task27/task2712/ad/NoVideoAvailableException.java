package com.javarush.task.task27.task2712.ad;

/**
 * Класс не проверяемого исключения, если не получается подобрать рекламные ролики.
 */
public class NoVideoAvailableException extends RuntimeException {

    public NoVideoAvailableException() {
    }

    public NoVideoAvailableException(String message) {
        super(message);
    }
}

