package com.javarush.task.task38.task3802;

import java.io.FileReader;

/**
 * Проверяемые исключения (checked exception)
 * Напиши реализацию метода veryComplexMethod().
 * Он должен всегда кидать какое-нибудь проверяемое исключение.
 * Кинуть исключение (throw) явно нельзя.
 *
 *
 * Requirements:
 * 1. Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.
 * 2. Метод veryComplexMethod класса veryComplexClass должен бросать исключение.
 * 3. Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).
 * 4. Метод veryComplexMethod не должен быть приватным.
*/
public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        new FileReader("");
    }

    public static void main(String[] args) {
        try {
            new VeryComplexClass().veryComplexMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
