package com.javarush.task.jdk13.task08.task0807;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * LinkedList и ArrayList
 * Нужно создать два списка – LinkedList и ArrayList.
 *
 * Требования:
 * 1. Программа должна содержать только три метода.
 * 2. Метод createArrayList() должен создавать и возвращать список ArrayList.
 * 3. Метод createLinkedList() должен создавать и возвращать список LinkedList.
*/

public class Solution {
    public static Object createArrayList() {
        return new ArrayList<>();
    }

    public static Object createLinkedList() {
        return new LinkedList<>();
    }

    public static void main(String[] args) {

    }
}
