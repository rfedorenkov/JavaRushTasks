package com.javarush.task.pro.task09.task0916;

/**
 * String.format()
 * Сделай так, чтобы метод format(String, int) возвращал строку в таком виде:
 * Меня зовут <name>. Я буду зарабатывать <salary>$ в месяц.
 *
 * Где <name> — это первый параметр, а <salary> — второй.
 *
 * Для этого используй метод String.format().
 *
 *
 * Требования:
 * 1. Нужно, чтобы метод format(String, int) использовал метод String.format().
 * 2. Нужно, чтобы метод format(String, int) возвращал строку согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(format("Амиго", 5000));
    }

    public static String format(String name, int salary) {
        String phrase = "Меня зовут %s. Я буду зарабатывать $%d в месяц.";
        return String.format(phrase, name, salary);
    }
}
