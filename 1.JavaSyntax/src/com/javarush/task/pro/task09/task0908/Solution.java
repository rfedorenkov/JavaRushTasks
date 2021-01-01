package com.javarush.task.pro.task09.task0908;

import java.util.regex.Pattern;

/**
 * Двоично-шестнадцатеричный конвертер
 * Публичный статический метод toHex(String) должен переводить строковое представление двоичного числа,
 * полученное в качестве входящего параметра, из двоичной системы счисления в шестнадцатеричную
 * и возвращать его строковое представление. А публичный статический метод toBinary(String)
 * наоборот — из строкового представления шестнадцатеричного числа в строковое представление двоичного числа.
 * <p>
 * Методы работают только с не пустыми строками.
 * Если входящий параметр — пустая строка или null, то оба метода возвращают пустую строку.
 * Если входящий параметр метода toHex(String) содержит любой символ, кроме 0 или 1, то метод возвращает пустую строку.
 * Если входящий параметр метода toBinary(String) содержит любой символ, кроме цифр от 0 до 9
 * или латинскую букву от a до f (в нижнем регистре), то метод возвращает пустую строку.
 * <p>
 * Твоя задача — реализовать эти методы.
 * <p>
 * Один из алгоритмов перевода строкового представления двоичного числа в строковое представление
 * шестнадцатеричного числа следующий:
 * <p>
 * Проверяем длину строки, полученной входящим параметром. Она должна быть кратна 4.
 * Если это не так, то добавляем нужное количество 0 в начало строки.
 * Берем каждые четыре символа (бита) и проверяем, какому символу шестнадцатеричной кодировки он соответствует.
 * Например:
 * <p>
 * двоичное представление — "100111010000", где "1001" — "9", "1101" — "d", "0000" — "0",
 * шестнадцатеричное представление — "9d0".
 * Один из алгоритмов перевода строкового представления шестнадцатеричного числа в строковое представление
 * двоичного числа следующий:
 * Берем каждый символ и проверяем какому двоичному числу (4 бита) он соответствует.
 * <p>
 * Например:
 * <p>
 * шестнадцатеричное представление — "9d0", где "9" — "1001", "d" — "1101", "0" — "0000",
 * двоичное представление — "100111010000".
 * Метод main() не принимает участие в тестировании.
 * <p>
 * <p>
 * Требования:
 * 1. Нужно, чтобы метод toHex(String) был реализован согласно условию.
 * 2. Нужно, чтобы метод toBinary(String) был реализован согласно условию.
 * 3. Методы Integer.toBinaryString(int) и Long.toBinaryString(int) использовать нельзя.
 * 4. Методы Integer.toHexString(int) и Long.toHexString(int) использовать нельзя.
 * 5. Методы Integer.parseInt(String, int) и Long.parseLong(String, int) использовать нельзя.
 * 6. Методы Integer.toString(int, int) и Long.toString(long, int) использовать нельзя.
 * 7. Объект типа BigInteger использовать нельзя.
 * 8. Объект типа BigDecimal использовать нельзя.
 */

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        StringBuilder hexNumber = new StringBuilder();
        if (binaryNumber != null && !binaryNumber.isEmpty() && Pattern.matches("[0-1]+", binaryNumber)) {
            StringBuilder tmp = new StringBuilder(binaryNumber);
            while (tmp.length() % 4 != 0) {
                tmp.insert(0, "0");
            }
            for (int i = 0; i < tmp.length(); i+=4) {
                String part = tmp.substring(i, i + 4);
                hexNumber.append(
                        switch (part) {
                            case "0001" -> "1";
                            case "0010" -> "2";
                            case "0011" -> "3";
                            case "0100" -> "4";
                            case "0101" -> "5";
                            case "0110" -> "6";
                            case "0111" -> "7";
                            case "1000" -> "8";
                            case "1001" -> "9";
                            case "1010" -> "a";
                            case "1011" -> "b";
                            case "1100" -> "c";
                            case "1101" -> "d";
                            case "1110" -> "e";
                            case "1111" -> "f";
                            default -> "0";
                        }
                );
            }
        }
        return hexNumber.toString();
    }

    public static String toBinary(String hexNumber) {
        StringBuilder binaryNumber = new StringBuilder();
        if (hexNumber != null && !hexNumber.isEmpty() && Pattern.matches("[0-9a-f]+", hexNumber)) {
            for (int i = 0; i < hexNumber.length(); i++) {
                binaryNumber.append(
                        switch (hexNumber.charAt(i)) {
                            case '1' -> "0001";
                            case '2' -> "0010";
                            case '3' -> "0011";
                            case '4' -> "0100";
                            case '5' -> "0101";
                            case '6' -> "0110";
                            case '7' -> "0111";
                            case '8' -> "1000";
                            case '9' -> "1001";
                            case 'a' -> "1010";
                            case 'b' -> "1011";
                            case 'c' -> "1100";
                            case 'd' -> "1101";
                            case 'e' -> "1110";
                            case 'f' -> "1111";
                            default -> "0000";
                        });
            }
        }
        return binaryNumber.toString();
    }
}
