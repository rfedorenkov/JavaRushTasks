package com.javarush.task.jdk13.task09.task0917;

/**
 * Перехват unchecked исключений
 * В методе handleExceptions обработайте все unchecked исключения.
 * Нужно вывести стек-трейс возникшего исключения используя метод printStack.
 * Можно использовать только один блок try..catch
 *
 * Требования:
 * 1. В методе handleExceptions необходимо вызывать метод method1.
 * 2. В методе handleExceptions необходимо вызывать метод method2.
 * 3. В методе handleExceptions необходимо вызывать метод method3.
 * 4. В методе handleExceptions необходимо использовать только один блок try..catch.
 * 5. В методе handleExceptions необходимо отлавливать все unchecked исключения и выводить
 * стек-трейс возникшего исключения, используя метод printStack.
 * 6. В методе handleExceptions checked исключения не отлавливать.
 * 7. Программа должна выводить на экран текст.
*/

public class Solution {
    public static void main(String[] args) {
        handleExceptions(new Solution());
    }

    public static void handleExceptions(Solution obj) {
        try {
            obj.method1();
            obj.method2();
            obj.method3();
        } catch (Exception e) {
            printStack(e);
        }
    }

    public static void printStack(Throwable throwable) {
        System.out.println(throwable);
        for (StackTraceElement element : throwable.getStackTrace()) {
            System.out.println(element);
        }
    }

    public void method1() {
        throw new NullPointerException();
    }

    public void method2() {
        throw new IndexOutOfBoundsException();
    }

    public void method3() {
        throw new NumberFormatException();
    }
}

