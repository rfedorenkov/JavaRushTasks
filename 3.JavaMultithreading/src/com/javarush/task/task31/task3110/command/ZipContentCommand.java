package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.FileProperties;
import com.javarush.task.task31.task3110.ZipFileManager;

/**
 * Класс для просмотра содержимого архива.
 */
public class ZipContentCommand extends ZipCommand {

    /**
     * Метод просматривает содержимое архива.
     *
     * @throws Exception Возможны ошибки.
     */
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        // Создаем новый объект класса ZipFileManager
        ZipFileManager zipFileManager = getZipFileManager();
        ConsoleHelper.writeMessage("Содержимое архива:");
        // Получаем список файла архива и выводим в консоль
        zipFileManager.getFilesList()
                .stream()
                .map(FileProperties::toString)
                .forEach(ConsoleHelper::writeMessage);
        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
