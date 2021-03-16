package com.javarush.task.task19.task1911;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Ридер обертка
 * В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
 * Твоя ридер-обертка должна преобразовывать весь текст в заглавные буквы.
 * Вызови готовый метод printSomething(), воспользуйся testString.
 * Верни переменной System.out первоначальный поток.
 * Выведи модифицированную строку в консоль.
 *
 *
 * Требования:
 * 1. Класс Solution должен содержать класс TestString.
 * 2. Класс Solution должен содержать публичное статическое поле testString типа TestString,
 * которое сразу проинициализировано.
 * 3. Класс TestString должен содержать публичный void метод printSomething().
 * 4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
 * 5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream
 * c конструктором принимающим ByteArrayOutputStream).
 * 6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода
 * в консоль объекта System.out.
 * 7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
 * 8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething()
 * согласно заданию, и выводить её в консоль.
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream defaultStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        System.setOut(defaultStream);

        String result = outputStream.toString().toUpperCase();
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
