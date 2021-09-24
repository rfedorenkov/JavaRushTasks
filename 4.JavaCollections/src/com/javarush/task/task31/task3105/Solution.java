package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Добавление файла в архив
 * В метод main приходит список аргументов.
 * Первый аргумент - полный путь к файлу fileName.
 * Второй аргумент - путь к zip-архиву.
 * Добавить файл (fileName) внутрь архива в директорию 'new'.
 * Если в архиве есть файл с таким именем, то заменить его.
 *
 * Пример входных данных:
 * C:/result.mp3
 * C:/pathToTest/test.zip
 *
 * Файлы внутри test.zip:
 * a.txt
 * b.txt
 *
 * После запуска Solution.main архив test.zip должен иметь такое содержимое:
 * new/result.mp3
 * a.txt
 * b.txt
 *
 * Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив
 * все энтри вместе с добавленным файлом.
 * Пользоваться файловой системой нельзя.
 *
 *
 * Requirements:
 * 1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать
 * из него все содержимое.
 * 2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
 * 3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
 * 4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
 * 5. Потоки для работы с архивом должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        String zipFile = args[1];

        List<Content> contents = getContents(zipFile);

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

        zos.putNextEntry(new ZipEntry("new/" + file.getName()));

        Files.copy(file.toPath(), zos);

        for (Content content : contents) {
            if (!content.getFileName().equals("new/" + file.getName())) {
                content.saveToZip(zos);
            }
        }

        zos.close();
    }

    private static List<Content> getContents(String fileName) throws IOException {
        List<Content> contents = new ArrayList<>();
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(fileName))) {
            ZipEntry entry;
            byte[] buffer = new byte[8 * 1024];
            while ((entry = zis.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, len);
                }
                contents.add(new Content(entry.getName(), baos));
            }
        }
        return contents;
    }

    private static class Content {
        String fileName;
        ByteArrayOutputStream buffer;

        public Content(String fileName, ByteArrayOutputStream buffer) {
            this.fileName = fileName;
            this.buffer = buffer;
        }

        public String getFileName() {
            return fileName;
        }

        void saveToZip(ZipOutputStream zos) throws IOException {
            ZipEntry entry = new ZipEntry(fileName);
            zos.putNextEntry(entry);
            zos.write(buffer.toByteArray());
            zos.closeEntry();
        }
    }
}
