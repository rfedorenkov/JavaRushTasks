package com.javarush.task.pro.task06.task0614;

/**
 * Вспоминаем геометрию
 * Посмотри, что делает программа. Расставь модификатор final всем переменным с неизменными значениями.
 *
 *
 * Требования:
 * 1. Модификатор final должен быть установлен всем константам.
*/

public class Solution {
    public static final double pi = 3.14;
    public static double radius = 2.5;
    public static double diameter = 5;

    public static void main(String[] args) {
        System.out.println("Плошадь круга равна : " + pi*radius*radius);
        System.out.println("Периметр круга равен : " + pi*diameter);
    }
}
