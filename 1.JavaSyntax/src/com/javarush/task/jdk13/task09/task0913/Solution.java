package com.javarush.task.jdk13.task09.task0913;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Исключения
 * Есть метод, который выбрасывает два исключения, унаследованные от Exception,
 * и два унаследованных от RuntimeException: NullPointerException, ArithmeticException,
 * FileNotFoundException, URISyntaxException. Нужно перехватить NullPointerException и FileNotFoundException,
 * но не перехватывать ArithmeticException и URISyntaxException. Как это сделать?
 *
 * Требования:
 * 1. В методе main необходимо вызывать метод method1.
 * 2. В методе main необходимо перехватывать исключение NullPointerException.
 * 3. В методе main необходимо перехватывать исключение FileNotFoundException.
 * 4. В методе main исключение FileNotFoundException не перехватывать.
 * 5. В методе main исключение URISyntaxException не перехватывать.
 * 6. Метод method1 не изменять.
*/

public class Solution {

    public static int i = (int) (Math.random() * 4);

    public static void main(String[] args) throws Exception {
        try {
            method1();
        } catch (NullPointerException | FileNotFoundException e) {
            System.out.println(e);
        }
    }

    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        if (i == 0) {
            throw new NullPointerException();
        } else if (i == 1) {
            throw new ArithmeticException();
        } else if (i == 2) {
            throw new FileNotFoundException();
        } else if (i == 3) {
            throw new URISyntaxException("", "");
        }
    }
}
