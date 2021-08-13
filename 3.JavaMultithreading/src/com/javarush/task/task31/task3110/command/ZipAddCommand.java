package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для добавления файла в архив.
 */
public class ZipAddCommand extends ZipCommand {

    /**
     * Метод добавляет файл в архив.
     *
     * @throws Exception Возможны ошибки.
     */
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Добавление нового файла в архив.");
            // Создаем новый объект класса ZipFileManager
            ZipFileManager zipFileManager = getZipFileManager();
            // Получаем введенный пользователем путь архива
            ConsoleHelper.writeMessage("Введите полное имя файла для добавления:");
            Path sourcePath = Paths.get(ConsoleHelper.readString());
            // Удаляем файл из архива архив
            zipFileManager.addFile(sourcePath);
            ConsoleHelper.writeMessage("Добавление в архив завершено.");
        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }
}