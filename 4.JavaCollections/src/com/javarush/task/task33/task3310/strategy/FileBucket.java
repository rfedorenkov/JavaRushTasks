package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;
import com.javarush.task.task33.task3310.Helper;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс для хранения сущностей в файлах.
 */
public class FileBucket {
    Path path;

    /**
     * Конструктор класса.
     * Создает временный файл, удаляет файл если он существует.
     * При завершении удаляет файл.
     */
    public FileBucket() {
        try {
            path = Files.createTempFile(Helper.generateRandomString(), null);
            Files.deleteIfExists(path);

            path.toFile().deleteOnExit();
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }


    /**
     * Метод возвращает размер файла на который указывает path.
     *
     * @return Размер файла path.
     */
    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод сериализовывает переданный entry в файл path.
     *
     * @param entry Сущность Entry.
     */
    public void putEntry(Entry entry) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            do {
                oos.writeObject(entry);
            } while ((entry = entry.next) != null);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    /**
     * Метод десериализовывает entry из файла path.
     *
     * @return Entry из path. Если размер нулевой - null;
     */
    public Entry getEntry() {
        if (getFileSize() == 0) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (Entry) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            ExceptionHandler.log(e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Удаляем файл на который указывает path.
     */
    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
