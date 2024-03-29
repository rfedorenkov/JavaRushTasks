package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Запись в существующий файл
 * В метод main приходят три параметра:
 * 1) fileName - путь к файлу;
 * 2) number - число, позиция в файле;
 * 3) text - текст.
 * Записать text в файл fileName начиная с позиции number.
 * Запись должна производиться поверх старых данных, содержащихся в файле.
 * Если файл слишком короткий, то записать в конец файла.
 * Используй RandomAccessFile и его методы seek и write.
 *
 *
 * Requirements:
 * 1. В методе main класса Solution необходимо использовать RandomAccessFile.
 * 2. В методе main класса Solution программа должна записывать данные в файл
 * при помощи метода write класса RandomAccessFile.
 * 3. Запись в файл должна происходить с указанной позиции с заменой содержимого.
 * 4. Если файл слишком короткий, то запись text должна происходить в конец файла.
*/
public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            raf.seek(Math.min(Long.parseLong(args[1]), raf.length()));
            raf.write(args[2].getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
