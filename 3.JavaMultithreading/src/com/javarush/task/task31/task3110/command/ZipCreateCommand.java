package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для создания архива (упаковки файлов в архив).
 */
public class ZipCreateCommand extends ZipCommand {

    /**
     * Метод создает архив.
     *
     * @throws Exception Возможны ошибки.
     */
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            // Создаем новый объект класса ZipFileManager
            ZipFileManager zipFileManager = getZipFileManager();
            // Получаем введенный пользователем путь архива
            ConsoleHelper.writeMessage("Введите полное имя файла или директории для архивации:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            // Создаем архив
            zipFileManager.createZip(sourcePath);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}
