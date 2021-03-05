package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/**
 * Писатель в файл с консоли
 * В этой задаче тебе нужно:
 * Прочесть с консоли имя файла.
 * Считывать строки с консоли, пока пользователь не введет строку "exit".
 * Вывести абсолютно все введенные строки в файл, каждую строчку — с новой строки.
 *
 * Требования:
 * 1. Программа должна считывать c консоли имя файла.
 * 2. Создай и используй объект типа BufferedWriter.
 * 3. Программа не должна ничего считывать из файловой системы.
 * 4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
 * 5. Программа должна записать все введенные строки (включая "exit") в файл: каждую строчку — с новой строки.
 * 6. Метод main должен закрывать объект типа BufferedWriter после использования.
 * 7. Метод main не должен выводить данные на экран.
*/

public class Solution {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            String fileName = reader.readLine();

            String next = "";
            while (!next.equals("exit")) {
                next = reader.readLine();
                sb.append(next).append("\n");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
