package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime исключения (unchecked exception)
 * Напиши реализацию метода methodThrowsClassCastException().
 * Он должен всегда кидать Runtime исключение ClassCastException.
 *
 * Напиши реализацию метода methodThrowsNullPointerException().
 * Он должен всегда кидать Runtime исключение NullPointerException.
 *
 * Кинуть исключение (throw) явно нельзя.
 *
 *
 * Requirements:
 * 1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
 * 2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
 * 3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
 * 4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
*/
public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        List<Object> list = new LinkedList<>();
        list = (ArrayList) list;
    }

    public void methodThrowsNullPointerException() {
        byte[] arr = null;
        arr[0] = 0;
    }

    public static void main(String[] args) {

    }
}
