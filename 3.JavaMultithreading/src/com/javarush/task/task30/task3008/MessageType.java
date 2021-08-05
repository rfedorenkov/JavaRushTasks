package com.javarush.task.task30.task3008;

/**
 * Класс отвечает за тип сообщений пересылаемых между клиентом и сервером.
 */
public enum MessageType {
    /**
     * Запрос имени.
     */
    NAME_REQUEST,

    /**
     * Имя пользователя.
     */
    USER_NAME,

    /**
     * Имя принято.
     */
    NAME_ACCEPTED,

    /**
     * Текстовое сообщение.
     */
    TEXT,

    /**
     * Пользователь добавлен.
     */
    USER_ADDED,

    /**
     * Пользователь удален.
     */
    USER_REMOVED
}
