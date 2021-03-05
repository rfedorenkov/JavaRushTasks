package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Чтение файла
 * В этой задаче тебе нужно:
 * Считать с консоли имя файла.
 * Вывести в консоли (на экран) содержимое файла.
 * Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
 *
 * Требования:
 * 1. Программа должна считывать c консоли имя файла.
 * 2. Программа должна выводить на экран содержимое файла.
 * 3. Поток чтения из файла (FileInputStream) должен быть закрыт.
 * 4. BufferedReader также должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            try(FileInputStream fis = new FileInputStream(fileName)) {
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}