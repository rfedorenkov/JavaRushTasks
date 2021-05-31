package com.javarush.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayDeque;
import java.util.EventListener;

/**
 * Так-с... сопоставим
 * Исправь ошибки: перемести методы clone в те классы, в которых они должны быть реализованы.
 * Лишние методы удали.
 * Не удаляй метод main.
 *
 *
 * Requirements:
 * 1. В классе C должен быть реализован метод clone без параметров.
 * 2. В классе Solution должен существовать метод main.
 * 3. В классе Solution должны существовать 4 вложенных класса.
 * 4. В классе Solution должен существовать 1 метод.
 * 5. Метод clone в классе C должен возвращать объект типа C.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class A implements Serializable {

    }

    public static class B implements Remote {
    }

    @SuppressWarnings("rawtypes")
    public static class C extends ArrayDeque {
        @Override
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener {

    }
}
