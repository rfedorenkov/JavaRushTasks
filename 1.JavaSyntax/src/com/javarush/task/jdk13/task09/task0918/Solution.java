package com.javarush.task.jdk13.task09.task0918;

/**
 * Создаем свои исключения
 * Есть четыре класса MyException, MyException2, MyException3, MyException4.
 * Унаследуй классы так, чтобы у тебя появилось любые два checked исключения и любые два unchecked исключения.
 *
 * Требования:
 * 1. В классе Solution должно быть 4 вложенных класса: MyException, MyException2, MyException3 и MyException4.
 * 2. Все вложенные классы должны быть унаследованы от классов исключений.
 * 3. Два класса из четырех должны быть checked исключениями.
 * 4. Два класса из четырех должны быть unchecked исключениями.
*/

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends Exception {
    }

    static class MyException2 extends MyException {
    }

    static class MyException3 extends RuntimeException {
    }

    static class MyException4 extends MyException3 {
    }
}

