package com.javarush.task.jdk13.task09.task0905;

/**
 * Метод возвращает результат – глубину его стек-трейса
 * Релизовать метод, который возвращает результат – глубину
 * его стек-трейса – количество методов в нем (количество элементов в списке).
 * Это же число нужно в методе вывести на экран.
 *
 * Требования:
 * 1. В методе getStackTraceDepth необходимо возвращать глубину своего стек-трейса.
 * 2. В методе getStackTraceDepth необходимо выводить на экран глубину своего стек-трейса.
 * 3. Воспользуйся методом Thread.currentThread().getStackTrace().
 * 4. В методе main необходимо вызывать метод getStackTraceDepth.
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        int length = Thread.currentThread().getStackTrace().length;
        System.out.println(length);
        return length;
    }
}

