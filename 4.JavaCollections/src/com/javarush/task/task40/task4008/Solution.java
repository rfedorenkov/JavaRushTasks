package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * Работа с Java 8 DateTime API
 * Выполни задание, используя Java 8 DateTime API.
 * Реализуй метод printDate(String date).
 * Он должен в качестве параметра принимать дату (в одном из 3х форматов)
 * и выводить ее в консоль в соответствии с примером:
 *
 * 1) Для "9.10.2017 5:56:45" вывод должен быть:
 * День: 9
 * День недели: 1
 * День месяца: 9
 * День года: 282
 * Неделя месяца: 3
 * Неделя года: 42
 * Месяц: 10
 * Год: 2017
 * AM или PM: PM
 * Часы: 5
 * Часы дня: 5
 * Минуты: 56
 * Секунды: 45
 *
 * 2) Для "21.4.2014":
 * День: 21
 * День недели: 1
 * День месяца: 21
 * День года: 111
 * Неделя месяца: 4
 * Неделя года: 17
 * Месяц: 4
 * Год: 2014
 *
 * 3) Для "17:33:40":
 * AM или PM: PM
 * Часы: 5
 * Часы дня: 17
 * Минуты: 33
 * Секунды: 40
 *
 *
 * Requirements:
 * 1. Если в метод printDate передана дата в формате "дата время", он должен вывести:
 * День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM,
 * Часы, Часы дня, Минуты, Секунды.
 * 2. Если в метод printDate передана дата в формате "дата", он должен вывести:
 * День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
 * 3. Если в метод printDate передана дата в формате "время", он должен вывести:
 * AM или PM, Часы, Часы дня, Минуты, Секунды.
 * 4. Используй статический метод parse классов LocalDate и LocalTime.
*/
public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        boolean printDate = false;
        boolean printTime = false;

        DateTimeFormatter formatter = null;
        if (date.contains(".") && date.contains(":")) {
            formatter = DateTimeFormatter.ofPattern("d.M.y H:m:s");
            printDate = true;
            printTime = true;
        } else if (date.contains(".")){
            formatter = DateTimeFormatter.ofPattern("d.M.y");
            printDate = true;
        } else if (date.contains(":")) {
            formatter = DateTimeFormatter.ofPattern("H:m:ss");
            printTime = true;
        }

        if (printDate) {
            LocalDate localDate = LocalDate.parse(date, formatter);
            System.out.println("День: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День недели: " + localDate.get(ChronoField.DAY_OF_WEEK));
            System.out.println("День месяца: " + localDate.get(ChronoField.DAY_OF_MONTH));
            System.out.println("День года: " + localDate.get(ChronoField.DAY_OF_YEAR));
            System.out.println("Неделя месяца: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
            System.out.println("Неделя года: " + localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
            System.out.println("Месяц: " + localDate.get(ChronoField.MONTH_OF_YEAR));
            System.out.println("Год: " + localDate.get(ChronoField.YEAR));
        }

        if (printTime) {
            LocalTime localTime = LocalTime.parse(date, formatter);
            System.out.println("AM или PM: " + localTime.format(DateTimeFormatter.ofPattern("a")));
            System.out.println("Часы: " + localTime.get(ChronoField.HOUR_OF_AMPM));
            System.out.println("Часы дня: " + localTime.get(ChronoField.HOUR_OF_DAY));
            System.out.println("Минуты: " + localTime.get(ChronoField.MINUTE_OF_HOUR));
            System.out.println("Секунды: " + localTime.get(ChronoField.SECOND_OF_MINUTE));
        }

    }
}
