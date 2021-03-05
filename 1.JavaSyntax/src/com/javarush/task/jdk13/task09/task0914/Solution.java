package com.javarush.task.jdk13.task09.task0914;

/**
 * Перехватывание исключений
 * 1. Есть три исключения последовательно унаследованные от Exception:
 * 2. class Exception1 extends Exception
 * 3. class Exception2 extends Exception1
 * 4. class Exception3 extends Exception2
 * 5. Есть метод, который описан так: public static void method1() throws Exception1, Exception2, Exception3
 * 6. Напиши catch, который перехватит все три Exception1, Exception2 и Exception3
 *
 * Требования:
 * 1. В методе main необходимо вызывать метод method1.
 * 2. В методе main необходимо перехватывать исключение Exception1.
 * 3. В методе main необходимо перехватывать исключение Exception2.
 * 4. В методе main необходимо перехватывать исключение Exception3.
 * 5. Метод method1 не изменять.
*/

public class Solution {
    public static void main(String[] args) {

        try {
            method1();
        } catch (Exception1 e) {
            System.out.println(e);
        }

    }

    public static void method1() throws Exception1 {
        int i = (int) (Math.random() * 3);
        if (i == 0) {
            throw new Exception1();
        } else if (i == 1) {
            throw new Exception2();
        } else if (i == 2) {
            throw new Exception3();
        }
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}
