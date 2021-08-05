package com.javarush.task.task30.task3008;

import java.io.Serializable;

/**
 * Класс отвечающий за пересылаемые сообщения.
 */
public class Message implements Serializable {
    /**
     * Тип сообщения.
     */
    private final MessageType type;

    /**
     * Данные сообщения.
     */
    private final String data;

    /**
     * Конструктор принимающий тип сообщеия.
     * Инициализация data - null;
     *
     * @param type Тип сообщения.
     */
    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    /**
     * Конструктор принимающий тип и данные сообщения.
     *
     * @param type Тип сообщения.
     * @param data Данные сообщения.
     */
    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    /**
     * Геттер поля data.
     *
     * @return Возвращает данные сообщения.
     */
    public String getData() {
        return data;
    }

    /**
     * Геттер поля type.
     *
     * @return Возвращает тип сообщения.
     */
    public MessageType getType() {
        return type;
    }
}