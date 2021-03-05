package com.javarush.task.task19.task1904;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * И еще один адаптер
 * Адаптировать Scanner к PersonScanner.
 * Классом-адаптером является PersonScannerAdapter.
 * В классе адаптере создать приватное финальное поле Scanner fileScanner.
 * Поле инициализировать в конструкторе с одним аргументом типа Scanner.
 *
 * Данные в файле хранятся в следующем виде:
 * Иванов Иван Иванович 31 12 1950
 * Петров Петр Петрович 31 12 1957
 *
 * В файле хранится большое количество людей, данные одного человека находятся в одной строке.
 * Метод read() должен читать данные только одного человека.
 *
 *
 * Требования:
 * 1. PersonScanner должен быть интерфейсом.
 * 2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
 * 3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
 * 4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
 * 5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
 * 6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать
 * данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) {
        try {
            PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(new FileReader("./1")));
            System.out.println(adapter.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            if (!fileScanner.hasNextLine()) {
                throw new RuntimeException("File end");
            }
            String[] data = fileScanner.nextLine().split(" ");

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];

            int day = Integer.parseInt(data[3]);
            int month = Integer.parseInt(data[4]) - 1;
            int year = Integer.parseInt(data[5]);

            Date birthday = new GregorianCalendar(year, month, day).getTime();
            return new Person(firstName, middleName, lastName, birthday);
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}
