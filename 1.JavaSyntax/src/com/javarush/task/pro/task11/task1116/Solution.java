package com.javarush.task.pro.task11.task1116;

/**
 * Правильный класс
 * Исправь ошибки в коде, чтобы программа компилировалась и работала.
 *
 *
 * Требования:
 * 1. Программа должна компилироваться и работать.
 * 2. В программе должен быть публичный класс Solution.
 * 3. В программе должен быть класс Cat.
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.name);
    }
}
class Cat {
    String name = "Tom";
}