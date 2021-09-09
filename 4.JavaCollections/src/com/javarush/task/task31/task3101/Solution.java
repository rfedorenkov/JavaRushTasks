package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * Проход по дереву файлов
 * 1. На вход метода main() подаются два параметра.
 * Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла,
 * который будет содержать результат.
 * 2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(),
 * и, если понадобится, FileUtils.isExist()).
 * 3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
 * Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
 * 3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
 * 3.2. В allFilesContent.txt последовательно записать содержимое всех файлов
 * из п. 3.1. После каждого тела файла записать "\n".
 * Все файлы имеют расширение txt.
 * В качестве разделителя пути используй "/".
 * Для создания файлов используй конструктор File(String pathname).
 *
 *
 * Requirements:
 * 1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
 * 2. Нужно создать поток для записи в переименованный файл.
 * 3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть
 * записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
 * 4. Поток для записи в файл нужно закрыть.
 * 5. Не используй статические переменные.
 */

public class Solution {
    public static void main(String[] args) {
        // Путь к директории
        Path path = Paths.get(args[0]);
        File destination = getFile(args[1]);

        try {
            List<Path> files = allFilesToList(path, 50);
            // Сортируем по имени файла
            files.sort(Comparator.comparing(Path::getFileName));
            // Пишем содержимое в файл
            readPathListAndWriteToFile(files, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод получает папку содержащую данный файл и переименовывает его в allFilesContent.txt
     * @param fileName Полный путь файла.
     * @return Файл allFilesContent.txt
     */
    private static File getFile(String fileName) {
        // Полный путь существующего файла
        File resultFileAbsolutePath = new File(fileName);
        // Конечное название файла
        File destination = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");

        // Если файл уже существуюет
        if (FileUtils.isExist(destination)) {
            // Удаляем его
            FileUtils.deleteFile(destination);
        }
        // Переименовываем
        FileUtils.renameFile(resultFileAbsolutePath, destination);
        // Возвращаем созданный файл
        return destination;
    }

    /**
     * Метод читает все содержимое файлов находящиеся в списке и записывает в указанный файл.
     *
     * @param paths Список путей к файлам.
     * @param destination Файл для записи.
     * @throws IOException Возможны ошибки ввода/вывода.
     */
    private static void readPathListAndWriteToFile(List<Path> paths, File destination) throws IOException {
        try (BufferedWriter os = new BufferedWriter(new FileWriter(destination))) {
            for (Path file : paths) {
                try (BufferedReader is = new BufferedReader(new FileReader(file.toFile()))) {
                    while (is.ready()) {
                        os.write(is.readLine());
                        os.write("\n");
                    }
                }
            }
        }
    }

    /**
     * Создает список с путей к файлам, которые не превышают допустимого порога.
     *
     * @param source Путь к папке.
     * @param maxSize Порог веса файла (в байтах)
     * @return Список путей к файлам.
     * @throws IOException Возможны ошибки ввода/вывода.
     */
    private static List<Path> allFilesToList(Path source, int maxSize) throws IOException {
        List<Path> files = new ArrayList<>();
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (attrs.size() <= maxSize) {
                    files.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return files;
    }
}