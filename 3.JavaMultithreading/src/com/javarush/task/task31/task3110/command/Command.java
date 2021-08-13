package com.javarush.task.task31.task3110.command;

/**
 * Интерфейс отвечает за выполнение комманд.
 * Каждая комманда должна реализовывать данный интерфейс.
 */
public interface Command {

    /**
     * Метод выполняет команду.
     *
     * @throws Exception Возможны ошибки.
     */
    void execute() throws Exception;
}
