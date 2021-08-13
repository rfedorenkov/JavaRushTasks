package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для получения списка всех файлов в какой-то папке.
 */
public class FileManager {
    // Корневой путь директории
    private Path rootPath;
    // Список относительных путей файлов внутри rootPath
    private List<Path> fileList;

    /**
     * Конструктор сформировывает список файлов.
     *
     * @param rootPath Путь к папке.
     * @throws IOException Ошибки ввода / вывода.
     */
    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    /**
     * Метод возвращает список относительных путей всех файлов,
     * которые находятся по пути rootPath, включая файлы в подпапках.
     *
     * @return Список относительных путей.
     */
    public List<Path> getFileList() {
        return fileList;
    }

    /**
     * Метод складывает в переменную класса fileList
     * все файлы, обнаруженные внутри переданного пути path,
     * Вызывая сам себя для всех объектов, обнаруженных директориях.
     *
     * @param path Путь к файлу.
     * @throws IOException Ошибки ввода / вывода.
     */
    private void collectFileList(Path path) throws IOException {
        // Если переданный файл является обычным файлом
        if (Files.isRegularFile(path)) {
            // Получаем его относительный путь относительно rootPath
            Path relativePath = rootPath.relativize(path);
            // Добавляем в список fileList
            fileList.add(relativePath);
        }

        // Если переданный файл является директорией
        if (Files.isDirectory(path)) {
            // Рекурсивно проходимся по всему содержимому директории
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    collectFileList(file);
                }
            }
        }
    }
}
