package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс распаковки архива.
 */
public class ZipExtractCommand extends ZipCommand {

    /**
     * Метод распаковывает архив.
     *
     * @throws Exception Возможны ошибки.
     */
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Распаковка архива.");
            // Создаем новый объект класса ZipFileManager
            ZipFileManager zipFileManager = getZipFileManager();
            // Получаем введенный пользователем путь для разархивации
            ConsoleHelper.writeMessage("Введите путь для распаковки:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            // Распаковываем архив
            zipFileManager.extractAll(destinationPath);
            ConsoleHelper.writeMessage("Архив был распакован.");
        } catch (WrongZipFileException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }

    }
}