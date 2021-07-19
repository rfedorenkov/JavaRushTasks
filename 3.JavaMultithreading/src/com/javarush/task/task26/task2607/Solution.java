package com.javarush.task.task26.task2607;

/**
 * Вежливость - это искусственно созданное хорошее настроение
 * В классе Solution создай public static класс IntegerHolder.
 * IntegerHolder должен быть для типа int (имя переменной должно быть value),
 * быть thread safe и изменяемым.
 * В этом классе должны быть два public метода get и set.
 *
 *
 * Requirements:
 * 1. Класс Solution должен содержать public static класс IntegerHolder.
 * 2. Класс IntegerHolder должен содержать private поле value типа int.
 * 3. Класс IntegerHolder должен содержать public метод get(), который должен вернуть value.
 * 4. Класс IntegerHolder должен содержать public метод set(int value),
 * который должен установить value переданным значением.
 * 5. Класс IntegerHolder должен быть thread safe.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class IntegerHolder {
        private int value;

        public synchronized int get() {
            return value;
        }

        public synchronized void set(int value) {
            this.value = value;
        }
    }
}
