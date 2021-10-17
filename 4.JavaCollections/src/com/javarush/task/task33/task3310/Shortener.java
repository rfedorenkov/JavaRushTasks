package com.javarush.task.task33.task3310;

/**
 * Класс, который может для любой строки вернуть некий
 * уникальный идентификатор и наоборот, по ранее полученному
 * идентификатору вернуть строку.
 */
public class Shortener {

    /**
     * Метод возвращает идентификатор 'id' для заданной стройки.
     *
     * @param string Заданная строка.
     * @return Идентификатор 'id'.
     */
    public Long getId(String string) {
        return -1L;
    }

    /**
     * Метод возвращает строку для заданного идентификатора.
     * @param id Идентификатор.
     * @return Строку или null, если передан неверный идентификатор.
     */
    public String getString(Long id) {
        return null;
    }
}