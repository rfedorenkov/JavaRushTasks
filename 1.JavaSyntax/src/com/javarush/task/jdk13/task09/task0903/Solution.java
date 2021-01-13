package com.javarush.task.jdk13.task09.task0903;

/**
 * Кто меня вызывал?
 * Есть пять методов, которые вызывают друг друга.
 * Нужно чтобы метод вернул номер строки кода, из которого вызвали этот метод.
 * Воспользуйся функцией: element.getLineNumber().
 *
 * Требования:
 * 1. В классе должно быть 5 методов (метод main не учитывать).
 * 2. В каждом методе нужно вызывать следующий: в main вызывать method1, в method1 вызывать method2 и т.д.
 * 3. В каждом методе нужно возвращать номер строки кода, из которого вызвали этот метод.
 * 4. Для получения номера строки, используй метод getLineNumber класса StackTraceElement.
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        method2();
        return Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method2() {
        method3();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method3() {
        method4();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method4() {
        method5();
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }

    public static int method5() {
        return  Thread.currentThread().getStackTrace()[2].getLineNumber();
    }
}
