package com.javarush.task.jdk13.task09.task0915;

import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.FileSystemException;

/**
 * Перехват выборочных исключений
 * 1. Разберись, какие исключения бросает метод BEAN.methodThrowExceptions.
 * 2. В методе handleExceptions вызови метод BEAN.methodThrowExceptions и обработай исключения:
 * 2.1. если возникло исключение FileSystemException, то логируй его (вызови метод BEAN.log) и пробрось дальше
 * 2.2. если возникло исключение CharConversionException или любое другое IOException,
 * то только логируй его (вызови метод BEAN.log)
 * 3. Добавь в объявление метода handleExceptions класс исключения, которое ты пробрасываешь в п.2.1.
 * 4. В методе main обработай оставшееся исключение - логируй его (вызови метод BEAN.log).
 * Используй try..catch Подсказка: Если ты захватил исключение MyException, которое не хотел захватывать,
 * его можно пробросить дальше кодом вида: catch (MyException e) { throw e; }
 *
 * Требования:
 * 1. В методе handleExceptions необходимо вызывать метод BEAN.methodThrowExceptions.
 * 2. В метод handleExceptions необходимо логировать исключение FileSystemException (вызвать метод BEAN.log),
 * а затем пробросить его дальше.
 * 3. В методе handleExceptions необходимо только логировать (вызвать метод BEAN.log)
 * исключение CharConversionException.
 * 4. Любое исключение IOException в методе handleExceptions необходимо только логировать.
 * 5. В объявление метода handleExceptions необходимо добавить класс исключения FileSystemException.
 * 6. В методе main необходимо использовать try..catch.
 * 7. В методе main необходимо логировать исключения (вызвать метод BEAN.log), которые кидает метод handleExceptions.
*/

public class Solution {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) {
        try {
            handleExceptions();
        } catch (FileSystemException e) {
            BEAN.log(e);
        }
    }

    public static void handleExceptions() throws FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        } catch (FileSystemException e) {
            BEAN.log(e);
            throw e;
        } catch (IOException e) {
            BEAN.log(e);
        }
    }

    public static class StatelessBean {

        public int i = (int) (Math.random() * 3);

        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws IOException {
            if (i == 0) {
                throw new CharConversionException();
            } else if (i == 1) {
                throw new FileSystemException("");
            } else if (i == 2) {
                throw new IOException();
            }
        }
    }
}
