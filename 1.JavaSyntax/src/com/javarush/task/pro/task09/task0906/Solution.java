package com.javarush.task.pro.task09.task0906;

/**
 * Двоичный конвертер
 * Публичный статический метод toBinary(int) должен переводить целое число,
 * полученное в качестве входящего параметра, из десятичной системы счисления в двоичную
 * и возвращать его строковое представление.
 * А публичный статический метод toDecimal(String) наоборот — из строкового представления
 * двоичного числа в десятичное число.
 * Методы работают только с положительными числами и не пустыми строками.
 * Если входящий параметр меньше или равен 0, метод toBinary(int) возвращает пустую строку.
 * Если входящий параметр — пустая строка или null, то метод toDecimal(String) возвращает 0.
 * Твоя задача — реализовать эти методы.
 *
 * Один из алгоритмов перевода десятичного числа в представление двоичного числа следующий:
 * while(десятичное число не равно 0) {
 * двоичное представление = остаток от деления десятичного числа на 2 + двоичное представление
 * десятичное число = десятичное число / 2
 * }
 *
 * Один из алгоритмов перевода представления двоичного числа в десятичное число следующий:
 * for (int i = 0; i < длины двоичного представления; i++) {
 * десятичное число = десятичное число + число из двоичного представления * на 2 в степени i
 * }
 *
 * Изначально берется крайнее правое число из двоичного представления. С каждой итерацией цикла
 * берется следующее число ближе к началу двоичного представления.
 *
 * Подсказка: чтобы возвести число к степени можно использовать метод Math.pow(число, степень).
 * Метод main() не принимает участие в тестировании.
 *
 *
 * Требования:
 * 1. Нужно, чтобы метод toBinary(int) был реализован согласно условию.
 * 2. Нужно, чтобы метод toDecimal(String) был реализован согласно условию.
 * 3. Методы Integer.toBinaryString(int) и Long.toBinaryString(int) использовать нельзя.
 * 4. Методы Integer.parseInt(String, int) и Long.parseLong(String, int) использовать нельзя.
 * 5. Методы Integer.toString(int, int) и Long.toString(long, int) использовать нельзя.
 * 6. Объект типа BigInteger использовать нельзя.
 * 7. Объект типа BigDecimal использовать нельзя.
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1111111111111111111111111111111";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        String binaryNumber = "";
        if (decimalNumber > 0) {
            while (decimalNumber != 0) {
                binaryNumber = (decimalNumber % 2) + binaryNumber;
                decimalNumber /= 2;
            }
        }
        return binaryNumber;
    }

    public static int toDecimal(String binaryNumber) {
        int decimalNumber = 0;
        if (binaryNumber != null && !binaryNumber.isEmpty()) {
            for (int i = 0; i < binaryNumber.length(); i++) {
                int value = Character.getNumericValue(binaryNumber.charAt(binaryNumber.length() - 1 - i));
                decimalNumber += value * (int) Math.pow(2, i);
            }
        }
        return decimalNumber;
    }
}
