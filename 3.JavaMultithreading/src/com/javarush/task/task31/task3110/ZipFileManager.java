package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Класс менеджер архива.
 * Данный класс совершает операции над файлом архива (ZIP).
 */
public class ZipFileManager {
    // Полный путь zip файла
    private final Path zipFile;

    /**
     * Конструктор для создания менеджера архива.
     *
     * @param zipFile Путь к архиву
     */
    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    /**
     * Создание ZIP архива.
     * Сначала в ZipOutputStream кладем ZipEntry, а затем записываем содержимое файла.
     * При записи файл автоматически сжимается, а при чтении восстанавливается.
     * ZipEntry может быть не только файлом, но и папкой.
     *
     * @param source Путь к файлу, который будем архивировать.
     * @throws Exception Разные ошибки.
     */
    public void createZip(Path source) throws Exception {
        // Проверяем, существует ли директория, где будет создаваться архив
        // При необходимости создаем ее
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory)) {
            Files.createDirectories(zipDirectory);
        }

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();

                // Добавляем каждый файл в архив
                for (Path fileName : fileNames) {
                    addNewZipEntry(zipOutputStream, source, fileName);
                }
            } else if (Files.isRegularFile(source)) {
                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {
                // Если переданный source не директория и не файл, бросаем исключение
                throw new PathIsNotFoundException("Вы неверно указали имя файла или директории.");
            }
        }
    }

    /**
     * Метод возвращает список свойств файлов в архиве.
     *
     * @return Список свойств файлов в архиве.
     * @throws Exception Возможны ошибки.
     */
    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем является ли содержимое zipFile обычным файлом
        if (!Files.isRegularFile(zipFile)) {
            // Если это не файл, то бросаем исключение WrongZipFileException
            throw new WrongZipFileException(zipFile + " - Не является zip файлом.");
        }

        // Создаем список с элементами типа FileProperties
        List<FileProperties> list = new ArrayList<>();
        // Создаем поток ZipInputStream, для файла из переменной zipFile
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipFile))) {
            // Проходимся по всем элементам ZipEntry потока ZipInputStream
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Считываем содержимое элемента
                // Для этого используем временный буфер и метод copyData
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zis, baos);

                // Создаем объект класса FileProperties и добавляем в список
                list.add(new FileProperties(entry.getName(), entry.getSize(),
                        entry.getCompressedSize(), entry.getMethod()));

            }
        }
        return list;
    }

    /**
     * Метод распаковывает архив в указанную папку.
     *
     * @param outputFolder Путь, куда будет распакован архив.
     * @throws Exception Возможны ошибки.
     */
    public void extractAll(Path outputFolder) throws Exception {
        // Проверяем, есть ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            // Если файла нет, то бросаем исключение WrongZipFileException
            throw new WrongZipFileException(zipFile + " - Архива не существуюет");
        }

        // Создаем поток ZipInputStream, для файла из переменной zipFile
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipFile))) {
            // Если директория outputFolder не существует, то ее создаем
            if (Files.notExists(outputFolder)) {
                Files.createDirectories(outputFolder);
            }

            // Проходимся по всем элементам ZipEntry потока ZipInputStream
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Получаем путь файла
                Path path = Paths.get(entry.getName());
                // Совмещаем путь с другими папками
                Path fileFullName = outputFolder.resolve(path);

                Path parent = fileFullName.getParent();

                // Если родительских папок не существует
                if (Files.notExists(parent)) {
                    // Создаем папки
                    Files.createDirectories(parent);
                }

                // Записываем файл с архива в папку outputFolder
                try (OutputStream os = Files.newOutputStream(fileFullName)) {
                    copyData(zis, os);
                }
            }
        }
    }

    /**
     * Метод удаляет файл из архива.
     *
     * @param path Путь к файлу.
     * @throws Exception Возможны ошибки.
     */
    public void removeFile(Path path) throws Exception {
        removeFiles(Collections.singletonList(path));
    }

    /**
     * Метод удаляет файлы из архива.
     *
     * @param pathList Список относительных путей файлов для удаления.
     * @throws Exception Возможны ошибки.
     */
    public void removeFiles(List<Path> pathList) throws Exception {
        // Проверяем, есть ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            // Если файла нет, то бросаем исключение WrongZipFileException
            throw new WrongZipFileException(zipFile + " - Архива не существуюет");
        }

        // Создаем временный файл архива в директории по умолчанию
        Path tempZipFile = Files.createTempFile(null, null);

        // Создаем поток ZipInputStream, для файла из переменной zipFile
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {
            // Проходимся по всем элементам ZipEntry потока ZipInputStream
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Получаем путь файла в архиве
                Path pathFile = Paths.get(entry.getName());
                if (pathList.contains(pathFile)) {
                    // Если файл есть в списке, то выводим сообщение, что удалили файл
                    com.javarush.task.task31.task3110.ConsoleHelper.writeMessage(String.format("Файл %s удален из архива.", pathFile.toString()));
                } else {
                    // Если файла нет в списке, то перезаписываем во временный архив
                    zos.putNextEntry(new ZipEntry(entry));
                    // Записываем в tempZipFile
                    copyData(zis, zos);
                    // Закрываем элемент архива
                    zos.closeEntry();
                    zis.closeEntry();
                }
            }
        }

        // Заменяем оригинальный файл архива временным
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Метод добавляет файл в архива.
     *
     * @param absolutePath Путь к файлу.
     * @throws Exception Возможны ошибки.
     */
    public void addFile(Path absolutePath) throws Exception {
        addFiles(Collections.singletonList(absolutePath));
    }

    /**
     * Метод добавляет файл в архив.
     *
     * @param absolutePathList Список абсолютных путей файлов для добавления.
     * @throws Exception Возможны ошибки.
     */
    public void addFiles(List<Path> absolutePathList) throws Exception {
        // Проверяем, есть ли zip файл
        if (!Files.isRegularFile(zipFile)) {
            // Если файла нет, то бросаем исключение WrongZipFileException
            throw new WrongZipFileException(zipFile + " - Архива не существуюет");
        }

        // Создаем временный файл архива в директории по умолчанию
        Path tempZipFile = Files.createTempFile(null, null);

        // Создаем поток ZipInputStream, для файла из переменной zipFile
        try (ZipInputStream zis = new ZipInputStream(Files.newInputStream(zipFile));
             ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(tempZipFile))) {
            // Создаем список существующих файлов в архиве
            List<Path> archivePaths = new ArrayList<>();
            // Проходимся по всем файлам оригинального архива
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                // Получаем путь файла в архиве
                Path pathFile = Paths.get(entry.getName());
                // Добавляем в список
                archivePaths.add(pathFile);
                // Перезаписываем во временный архив
                zos.putNextEntry(new ZipEntry(entry));
                // Записываем в tempZipFile
                copyData(zis, zos);
                // Закрываем элемент архива
                zos.closeEntry();
                zis.closeEntry();
            }

            // Проверяем список добавляемых файлов
            for (Path path : absolutePathList) {
                // Если файла не существует, то кидаем исключение PathIsNotFoundException
                if (!Files.isRegularFile(path)) {
                    throw new PathIsNotFoundException("Файл не был найден.");
                } else {
                    // Проверяем, есть ли файл уже в архиве
                    if (archivePaths.contains(path.getFileName())) {
                        ConsoleHelper.writeMessage(String.format("Файл %s уже в архиве.", path.toString()));
                    } else {
                        // Если файла нет, то добавляем в архив
                        addNewZipEntry(zos, path.getParent(), path.getFileName());
                        ConsoleHelper.writeMessage(String.format("Файл %s был добавлен в архив.", path.toString()));
                    }
                }
            }
        }

        // Заменяем оригинальный файл архива временным
        Files.move(tempZipFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Метод добавляет новый элемент в архив.
     *
     * @param zipOutputStream Поток записи.
     * @param filePath        Путь к файлу.
     * @param fileName        Имя файла.
     * @throws Exception Возможны ошибки.
     */
    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        // Получаем полный путь, для файла с именем fileName, расположенным в директории filePath
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            // Создаем новый элемент архива ZipEntry
            ZipEntry entry = new ZipEntry(fileName.toString());
            // Добавляем в поток архива созданный элемент архива
            zipOutputStream.putNextEntry(entry);
            // Копируем данные из InputStream в переданный zipOutputStream
            copyData(inputStream, zipOutputStream);
            // Закрываем элемент архива
            zipOutputStream.closeEntry();
        }
    }

    /**
     * Метод читает данные из in и записывает в out, пока не вычитает все.
     *
     * @param in  Поток чтения.
     * @param out Поток записи.
     * @throws Exception Возможны ошибки.
     */
    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}