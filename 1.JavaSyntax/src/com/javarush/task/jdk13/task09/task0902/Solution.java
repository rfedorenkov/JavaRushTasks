package com.javarush.task.jdk13.task09.task0902;

/**
 * И снова StackTrace
 * Есть пять методов, которые вызывают друг друга. Нужно чтобы каждый метод возвращал имя метода,
 * вызвавшего его, полученное с помощью StackTrace.
 *
 * Требования:
 * 1. В классе должно быть 5 методов (метод main не учитывать).
 * 2. В каждом методе нужно вызывать следующий: в main вызывать method1, в method1 вызывать method2 и т.д.
 * 3. В каждом методе нужно возвращать имя метода, вызвавшего его.
 * 4. Для получения имени вызвавшего метода, используй метод getMethodName.
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }

    public static String method2() {
        method3();
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }

    public static String method3() {
        method4();
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }

    public static String method4() {
        method5();
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }

    public static String method5() {
        return Thread.currentThread()
                .getStackTrace()[2].getMethodName();
    }
}
