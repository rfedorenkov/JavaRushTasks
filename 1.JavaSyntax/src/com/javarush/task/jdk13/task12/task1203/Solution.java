package com.javarush.task.jdk13.task12.task1203;

/**
 * Сознательный выбор
 * При сужении типа может произойти отбрасывание части числа. А может и не произойти.
 * Реализуй методы isByte, isShort, isInt.
 * Они должны определять, можно ли входящий аргумент "безболезненно" преобразовать к типам byte, short и int.
 *
 *
 * Требования:
 * 1. Метод isByte должен возвращать true если входящий аргумент может быть сужен к byte без потерь.
 * 2. Метод isShort должен возвращать true если входящий аргумент может быть сужен к short без потерь.
 * 3. Метод isInt должен возвращать true если входящий аргумент может быть сужен к int без потерь.
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(isByte(12)); // true
        System.out.println(isShort(130999)); // false
        System.out.println(isInt(1999939990L)); // true
        System.out.println(isInt(19999999939990L)); // false
    }

    public static boolean isByte(long l) {
        return (byte) l == l;
    }

    public static boolean isShort(long l) {
        return (short) l == l;
    }

    public static boolean isInt(long l) {
        return (int) l == l;
    }
}
