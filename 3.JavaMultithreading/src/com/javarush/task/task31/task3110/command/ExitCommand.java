package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;

/**
 * Класс для завершении программы.
 */
public class ExitCommand implements Command {

    /**
     * Метод завершает программу.
     */
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Работа архиватора завершена.");
    }
}
