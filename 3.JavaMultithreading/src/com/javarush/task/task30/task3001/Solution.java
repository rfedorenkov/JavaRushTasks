package com.javarush.task.task30.task3001;

import java.math.BigInteger;

/**
 * Конвертер систем счислений
 * Реализуй логику метода convertNumberToOtherNumberSystem, который должен
 * переводить число number.getDigit(), из одной системы счисления (numberSystem) в другую (expectedNumberSystem).
 * Брось NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2.
 * Валидация для - number.getDigit() - целое не отрицательное.
 * Метод main не участвует в тестировании.
 *
 *
 * Requirements:
 * 1. Метод convertNumberToOtherNumberSystem (Number, NumberSystem), возвращающий тип Number, должен существовать.
 * 2. Должно бросаться исключение NumberFormatException, если переданное число некорректно в заданной системе счисления.
 * 3. Необходимо корректно реализовать метод convertNumberToOtherNumberSystem - перевод
 * числа в указанную систему счисления.
 * 4. Enum NumberSystemType должен поддерживать интерфейс NumberSystem.
 * 5. В enum-е NumberSystemType должно присутствовать 11 значений оснований систем счисления.
 * Основания: 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 и 16.
*/

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        String oldValue = number.getDigit();
        int radix = number.getNumberSystem().getNumberSystemIntValue();

        String newValue = new BigInteger(oldValue, radix)
                .toString(expectedNumberSystem.getNumberSystemIntValue());


        return new Number(expectedNumberSystem, newValue);
    }
}
