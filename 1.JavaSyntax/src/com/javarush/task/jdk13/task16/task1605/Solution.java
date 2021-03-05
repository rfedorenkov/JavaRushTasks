package com.javarush.task.jdk13.task16.task1605;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Пробрасываем исключения
 * Есть четыре не статических метода method1(), method2(), method3(), method4().
 * Использую ключевое слово throws, сделай так, что бы method1() и method2() пробрасывали
 * любые проверяемые исключения, а method3() и method4() не проверяемые.
 *
 * Требования:
 * 1. Нужно чтобы в классе Solution было 4 публичных не статических метода: method1(), method2(), method3(), method4().
 * 2. Нужно чтобы методы method1() и method2() выбрасывали любые проверяемые исключения.
 * 3. Нужно чтобы методы method3() и method4() выбрасывали любые непроверяемые исключения.
*/

public class Solution {

    public void method1() throws FileNotFoundException {

    }
    public void method2() throws IOException {

    }
    public void method3() throws ArithmeticException {

    }
    public void method4() throws NullPointerException {

    }
}
