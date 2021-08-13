package com.javarush.task.task31.task3110;

/**
 * Класс отвечающий за свойства каждого файла в архиве.
 * Свойства - это набор, состоящий из: имя файла,
 * размер файла до и после сжатия, метод сжатия.
 */
public class FileProperties {

    private String name;
    private long size;
    private long compressedSize;
    private int compressionMethod;

    /**
     * Конструктор класса.
     *
     * @param name Имя файла.
     * @param size Размер файла в байтах.
     * @param compressedSize Размер файла после сжатия в байтах.
     * @param compressionMethod Метод сжатия файла.
     */
    public FileProperties(String name, long size, long compressedSize, int compressionMethod) {
        this.name = name;
        this.size = size;
        this.compressedSize = compressedSize;
        this.compressionMethod = compressionMethod;
    }

    /**
     * Геттер поля name.
     *
     * @return Возвращает имя файла.
     */
    public String getName() {
        return name;
    }

    /**
     * Геттер поля size.
     *
     * @return Возвращает размер файла.
     */
    public long getSize() {
        return size;
    }

    /**
     * Геттер поля compressedSize.
     *
     * @return Возвращает размер после сжатия.
     */
    public long getCompressedSize() {
        return compressedSize;
    }

    /**
     * Геттер поля compressionMethod.
     *
     * @return Возвращающий метод сжатия.
     */
    public int getCompressionMethod() {
        return compressionMethod;
    }

    /**
     * Метод считает степень сжатия файла.
     *
     * @return Возвращает степень сжатия файла
     */
    public long getCompressionRatio() {
        return 100 - ((compressedSize * 100) / size);
    }

    /**
     * Метод возвращает строковое представление объекта.
     *
     * @return Строковое представление объекта.
     */
    @Override
    public String toString() {
        // Проверяем, что размер файла больше 0
        // Если размер меньше или равен 0, то возвращаем только имя
        if (size > 0) {
            return String.format("%s %d Kb (%d Kb) сжатие: %d%%",
                    name, size / 1024, compressedSize / 1024, getCompressionRatio());
        } else {
            return name;
        }
    }
}