package com.javarush.task.jdk13.task02.task0208;

/**
 * Коты - это хорошо
 * Создай объект типа Cat 2 раза. Сохрани каждый экземпляр в свою переменную. Имена переменных должны быть разными.
 *
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. В методе main должно быть только две переменные.
 * 3. Переменным сразу должны быть присвоены значения.
 * 4. В классе Cat не должно быть переменных.
 * 5. В классе Cat не должно быть методов.
*/

public class Solution {
    public static void main(String[] args) {
        Cat boris = new Cat();
        Cat vasiliy = new Cat();
    }

    public static class Cat {

    }
}