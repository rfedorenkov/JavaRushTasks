package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс участника чата. Модель.
 */
public class ClientGuiModel {
    // Хранится список всех участников чата
    private final Set<String> allUserNames = new HashSet<>();
    // Хранится новое сообщение, которое получил клиент
    private String newMessage;

    /**
     * Геттер allUserNames.
     *
     * @return Возвращает немодифицированный список участников чата.
     */
    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    /**
     * Геттер newMessage.
     *
     * @return Возвращает сообщение.
     */
    public String getNewMessage() {
        return newMessage;
    }

    /**
     * Сеттер newMessage.
     *
     * @param newMessage Устанавливает сообщение.
     */
    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    /**
     * Метод добавляет имя участника в список всех участников чата.
     *
     * @param newUserName Имя нового пользователя.
     */
    public void addUser(String newUserName) {
        allUserNames.add(newUserName);
    }

    /**
     * Метод удаляет имя участника из списка всех участников чата.
     *
     * @param userName Имя пользователя.
     */
    public void deleteUser(String userName) {
        allUserNames.remove(userName);
    }
}