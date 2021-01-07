package com.javarush.task.jdk13.task12.task1205;

/**
 * А мне так нужно
 * Реализуй метод toCustomString, чтобы он преобразовывал Number к String по определенному правилу
 * в зависимости от типа:
 * - если аргумент является объектом Byte, то разделить его на 2 и преобразовать в строку, добавив в конце букву "b";
 * - если аргумент является объектом Integer, то разделить его на 3 и преобразовать в строку;
 * - если аргумент является объектом Double, то умножить его на 20 и преобразовать в строку;
 * - если аргумент не относится ни к одному из вышеперечисленных типов,
 * то вернуть строку "Я такого типа числа не жду!".
 *
 * Для определения типа используй оператор instanceof.
 *
 *
 * Требования:
 * 1. Метод toCustomString должен разделить входящий параметр на 2 и добавить в конце букву b,
 * если входящий параметр является объектом Byte.
 * 2. Метод toCustomString должен разделить входящий параметр на 3, если входящий параметр является объектом Integer.
 * 3. Метод toCustomString должен умножить входящий параметр на 20, если входящий параметр является объектом Double.
 * 4. Метод toCustomString должен вернуть строку "Я такого типа числа не жду!",
 * если входящий параметр не Byte, не Integer, и не Double.
 * 5. Для определения типа нужно использовать оператор instanceof.
*/

public class Solution {

    private static String UNEXPECTED_TYPE = "Я такого типа числа не жду!";

    public static void main(String[] args) {
        System.out.println(toCustomString((byte) 12));
        System.out.println(toCustomString(12));
        System.out.println(toCustomString(12.));
        System.out.println(toCustomString(12L));
    }

    public static String toCustomString(Number number) {
        if (number instanceof Byte) {
            return (Byte) number / 2 + "b";
        } else if (number instanceof Integer) {
            return String.valueOf((Integer) number / 3);
        } else if (number instanceof Double) {
            return String.valueOf((Double) number * 20);
        } else {
            return UNEXPECTED_TYPE;
        }
    }
}
