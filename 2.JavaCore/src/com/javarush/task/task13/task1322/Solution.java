package com.javarush.task.task13.task1322;

/**
 * Интерфейс SimpleObject
 * Создай класс StringObject и реализуй в нем интерфейс SimpleObject с параметром типа String.
 * Программа должна компилироваться.
 *
 *
 * Требования:
 * 1. Класс StringObject должен реализовывать интерфейс SimpleObject.
 * 2. Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
 * 3. В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
 * 4. Класс StringObject должен существовать в классе Solution.
 * 5. Класс StringObject должен быть статическим.
*/

public class Solution {

    public static void main(String[] args) {
        SimpleObject<String> stringObject = new StringObject();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    public static class StringObject implements SimpleObject<String> {

        @Override
        public SimpleObject<String> getInstance() {
            return new StringObject();
        }
    }

}
