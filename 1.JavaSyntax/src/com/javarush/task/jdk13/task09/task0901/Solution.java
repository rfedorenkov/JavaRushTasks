package com.javarush.task.jdk13.task09.task0901;

/**
 * Возвращаем StackTrace
 * Есть пять методов, которые вызывают друг друга. Нужно чтобы каждый метод возвращал свой StackTrace.
 *
 * Требования:
 * 1. В классе должно быть 5 методов (метод main не учитывать).
 * 2. В каждом методе нужно вызывать следующий: в main вызывать method1, в method1 вызывать method2 и т.д.
 * 3. В каждом методе нужно возвращать свой StackTrace.
 * 4. Для получения StackTrace воспользуйся Thread.currentThread().getStackTrace().
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method2() {
        method3();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method3() {
        method4();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method4() {
        method5();
        return Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method5() {
        return Thread.currentThread().getStackTrace();
    }
}
