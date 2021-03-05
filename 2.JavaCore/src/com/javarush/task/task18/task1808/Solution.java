package com.javarush.task.task18.task1808;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Разделение файла
 * Считать с консоли три имени файла: файл1, файл2, файл3.
 * Разделить файл1 по следующему критерию:
 * Первую половину байт записать в файл2, вторую половину байт записать в файл3.
 * Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
 * Закрыть потоки.
 *
 *
 * Требования:
 * 1. Программа должна три раза считать имена файлов с консоли.
 * 2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
 * 3. Первую половину байт из первого файла нужно записать во второй файл.
 * 4. Вторую половину байт из первого файла нужно записать в третий файл.
 * 5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
 */

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileOne = scanner.next();
        String fileTwo = scanner.next();
        String fileThree = scanner.next();

        try (FileInputStream is = new FileInputStream(fileOne);
             FileOutputStream os1 = new FileOutputStream(fileTwo);
             FileOutputStream os2 = new FileOutputStream(fileThree)) {
            byte[] bytes = new byte[is.available()];
            int count = is.read(bytes);
            os1.write(bytes, 0, (count - count / 2));
            os2.write(bytes, (count - count / 2), count / 2);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
