package com.javarush.task.pro.task09.task0905;

/**
 * Восьмеричный конвертер
 * Публичный статический метод toOctal(int) должен переводить целое число, полученное в качестве входящего параметра,
 * из десятичной системы счисления в восьмеричную.
 * А публичный статический метод toDecimal(int) наоборот — из восьмеричной в десятичную.
 * Методы работают только с положительными числами. Если входящий параметр меньше или равен 0, методы возвращают 0.
 * Твоя задача — реализовать эти методы.
 *
 * Один из алгоритмов перевода десятичного числа в восьмеричное следующий:
 * i равно 0
 * while(десятичное число не равно 0) {
 * восьмеричное число = восьмеричное число + (остаток от деления десятичного числа на 8) * на 10 в степени i
 * десятичное число = десятичное число / 8
 * i увеличиваем на 1
 * }
 *
 * Один из алгоритмов перевода восьмеричного числа в десятичное следующий:
 * i равно 0
 * while(восьмеричное число не равно 0) {
 * десятичное число = десятичное число + (остаток от деления восьмеричного числа на 10) * на 8 в степени i
 * восьмеричное число = восьмеричное число / 10
 * i увеличиваем на 1
 * }
 *
 * Метод main() не принимает участие в тестировании.
 *
 * Подсказка: чтобы возвести число в степень, можно использовать метод Math.pow(число, степень).
 *
 *
 * Требования:
 * 1. Нужно чтобы метод toOctal(int) был реализован согласно условию.
 * 2. Нужно чтобы метод toDecimal(int) был реализован согласно условию.
 * 3. Методы Integer.toOctalString(int) и Long.toOctalString(int) использовать нельзя.
 * 4. Методы Integer.parseInt(String, int) и Long.parseLong(String, int) использовать нельзя.
 * 5. Методы Integer.toString(int, int) и Long.toString(long, int) использовать нельзя.
 * 6. Объект типа BigInteger использовать нельзя.
 * 7. Объект типа BigDecimal использовать нельзя.
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber +
                " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber +
                " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        int octalNumber = 0;
        if (decimalNumber > 0) {
            int i = 0;
            while (decimalNumber != 0) {
                octalNumber = octalNumber + (decimalNumber % 8) * (int) Math.pow(10, i);
                decimalNumber /= 8;
                i++;
            }
        }
        return octalNumber;
    }

    public static int toDecimal(int octalNumber) {
        int decimalNumber = 0;
        if (octalNumber > 0) {
            int i = 0;
            while (octalNumber != 0) {
                decimalNumber = decimalNumber + (octalNumber % 10) * (int) Math.pow(8, i);
                octalNumber /= 10;
                i++;
            }
        }
        return decimalNumber;
    }
}
