package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Что внутри папки?
 * Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.
 *
 * Первым делом считай путь к папке с консоли.
 * Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
 * Затем посчитай и выведи следующую информацию:
 *
 * Всего папок - [количество папок в директории и поддиректориях]
 * Всего файлов - [количество файлов в директории и поддиректориях]
 * Общий размер - [общее количество байт, которое хранится в директории]
 *
 * Используй только классы и методы из пакета java.nio.
 *
 * Квадратные скобки [ ] выводить на экран не нужно.
 *
 *
 * Requirements:
 * 1. Метод main должен считывать путь к папке с консоли.
 * 2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
 * 3. Используй только классы и методы из пакета java.nio.
 * 4. На консоль должна быть выведена следующая информация:
 * "Всего папок - [количество папок в директории и поддиректориях]".
 * 5. На консоль должна быть выведена следующая информация:
 * "Всего файлов - [количество файлов в директории и поддиректориях]".
 * 6. На консоль должна быть выведена следующая информация:
 * "Общий размер - [общее количество байт, которое хранится в директории]".
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        // Считываем с консоли путь к папке
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());

        // Если введеный путь не является директорией
        if (!Files.isDirectory(path)) {
            // Выводим сообщеие и завершаем работу
            System.out.println(path + " - не папка");
        } else {
            // Создаем 3 счетчика (директории, файлов и общий размер)
            AtomicInteger countDirectories = new AtomicInteger();
            AtomicInteger countFiles = new AtomicInteger();
            AtomicLong countBytes = new AtomicLong();

            // Проходимся по папкам
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    // Проверяем, что директория не является изначальной
                    if (!dir.equals(path)) {
                        // Увеличиваем счетчик директорий
                        countDirectories.incrementAndGet();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Увеличиваем счетчик файлов
                    countFiles.incrementAndGet();
                    // Увеличиваем счетчик размера файла
                    countBytes.addAndGet(attrs.size());
                    return FileVisitResult.CONTINUE;
                }
            });

            // Выводим результат
            System.out.println("Всего папок - " + countDirectories);
            System.out.println("Всего файлов - " + countFiles);
            System.out.println("Общий размер - " + countBytes);
        }
    }
}
