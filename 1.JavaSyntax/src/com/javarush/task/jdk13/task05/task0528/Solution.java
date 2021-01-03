package com.javarush.task.jdk13.task05.task0528;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Вывести на экран сегодняшнюю дату
 * Выведи на экран текущую дату в таком формате: "21 02 2014".
 *
 *
 * Требования:
 * 1. Дата должна содержать день, месяц и год, разделенные пробелом.
 * 2. День должен соответствовать текущему.
 * 3. Месяц должен соответствовать текущему.
 * 4. Год должен соответствовать текущему.
 * 5. Всю дату нужно вывести в одной строке.
*/

public class Solution {
    public static void main(String[] args) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd MM yyy");
        System.out.print(format.format(LocalDate.now()));
    }
}
