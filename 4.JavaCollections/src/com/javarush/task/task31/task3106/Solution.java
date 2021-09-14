package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * Разархивируем файл
 * В метод main приходит список аргументов.
 * Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
 * Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
 * Записать разархивированный файл в resultFileName.
 * Архив внутри может содержать файл большой длины, например, 50Mb.
 * Внутри архива может содержаться файл с любым именем.
 *
 * Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
 * C:/result.mp3
 * C:/pathToTest/test.zip.003
 * C:/pathToTest/test.zip.001
 * C:/pathToTest/test.zip.004
 * C:/pathToTest/test.zip.002
 *
 *
 * Requirements:
 * 1. В методе main нужно создать ZipInputStream для архива, собранного из кусочков файлов.
 * Файлы приходят аргументами в main, начиная со второго.
 * 2. Создай поток для записи в файл, который приходит первым аргументом в main.
 * Запиши туда содержимое файла из архива.
 * 3. Поток для чтения из архива должен быть закрыт.
 * 4. Поток для записи в файл должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        // Проверяем переданные аргументы
        checkArgs(args);

        // Получаем имя результирующего файла
        File resultFileName = new File(args[0]);
        // Имена частей файла
        List<String> fileParts = getSortedFileParts(args);

        // Создаем отдельный поток для каждого файла
        List<InputStream> fileInputStreams = getFileInputStreams(fileParts);

        try (ZipInputStream zis = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))) {
            while (zis.getNextEntry() != null) {
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(resultFileName))) {
                    copyData(zis, bos);
                }
            }
        }
    }

    private static void checkArgs(String... args) {
        if (args.length <= 2) {
            throw new RuntimeException("Введите имя файла и имена частей архива");
        }
    }

    private static List<String> getSortedFileParts(String... parts) {
        // Создаем список с именами частей файлов
        List<String> fileParts = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
        // Сортируем
        Collections.sort(fileParts);
        return fileParts;
    }

    private static List<InputStream> getFileInputStreams(List<String> fileParts) throws FileNotFoundException {
        List<InputStream> list = new ArrayList<>();
        for (String filePart : fileParts) {
            list.add(new FileInputStream(filePart));
        }
        return list;
    }

    private static void copyData(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = is.read(buffer)) > 0) {
            os.write(buffer, 0, len);
        }
    }
}
