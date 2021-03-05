package com.javarush.task.jdk13.task01.task0103;

/**
 * На дворе 32 век
 * Сейчас 3126 год. Мой друг родился 8 лет назад.
 * Напиши программу, выводящую на экран год рождения моего друга.
 *
 *
 * Требования:
 * 1. В программе должен использоваться вывод на экран.
 * 2. Выведенный год должен состоять из 4 цифр.
 * 3. Выведенный год должен начинаться с "31".
 * 4. Выведенный год должен соответствовать заданию.
*/

public class Solution {
    static final int YEAR_NOW = 3126;
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println(deductionOfYears(YEAR_NOW, 8));
    }

    static int deductionOfYears(int thisYear, int differenceOfYears) {
        return thisYear - differenceOfYears;
    }
}
