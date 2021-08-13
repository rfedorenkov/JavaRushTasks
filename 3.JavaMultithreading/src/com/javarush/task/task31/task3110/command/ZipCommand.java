package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Абстрактный класс комманд.
 */
public abstract class ZipCommand implements Command {

    /**
     * Метод возвращает файловый менеджер архива.
     *
     * @return Файловый менеджер архива.
     * @throws Exception Возможны ошибки.
     */
    public ZipFileManager getZipFileManager() throws Exception {
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}