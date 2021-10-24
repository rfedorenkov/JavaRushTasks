package com.javarush.task.task37.task3706;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Давно забытый Array
 * Реализуй логику метода getData так, чтобы main отработал без исключений.
 * Остальной код не менять.
 *
 *
 * Requirements:
 * 1. Метод getData не должен возвращать null.
 * 2. Метод getData должен возвращать объект удовлетворяющий условию задачи.
 * 3. Метод getData должен быть публичным.
 * 4. Метод getData должен быть статическим.
 */
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.asList(1, 2, 3);
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
        return new Number[0];
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data) {
            list.add(number);
        }
    }
}
