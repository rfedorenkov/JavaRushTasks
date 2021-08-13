package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Класс для удаления файла из архива.
 */
public class ZipRemoveCommand extends ZipCommand {

    /**
     * Метод удаляет файл из архива.
     *
     * @throws Exception Возможны ошибки.
     */
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Удаление файла из архива.");
        // Создаем новый объект класса ZipFileManager
        ZipFileManager zipFileManager = getZipFileManager();
        // Получаем введенный пользователем путь архива
        ConsoleHelper.writeMessage("Введите полный путь файла в архиве:");
        Path sourcePath = Paths.get(ConsoleHelper.readString());
        // Удаляем файл из архива архив
        zipFileManager.removeFile(sourcePath);
        ConsoleHelper.writeMessage("Удаление из архива завершено.");
    }
}
