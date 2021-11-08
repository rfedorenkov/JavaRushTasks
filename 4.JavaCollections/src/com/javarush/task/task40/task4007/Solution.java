package com.javarush.task.task40.task4007;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Работа с датами
 * Реализуй метод printDate(String date).
 * Он должен в качестве параметра принимать дату (в одном из 3х форматов) и выводить ее в консоль в соответствии с примером:
 *
 * 1) Для "21.4.2014 15:56:45" вывод должен быть:
 * День: 21
 * День недели: 1
 * День месяца: 21
 * День года: 111
 * Неделя месяца: 4
 * Неделя года: 17
 * Месяц: 4
 * Год: 2014
 * AM или PM: PM
 * Часы: 3
 * Часы дня: 15
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
 * Используй класс Calendar.
 *
 *
 * Requirements:
 * 1. Если в метод printDate передана дата в формате "дата время", он должен вывести: День, День недели,
 * День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
 * 2. Если в метод printDate передана дата в формате "дата", он должен вывести: День, День недели,
 * День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
 * 3. Если в метод printDate передана дата в формате "время", он должен вывести: AM или PM,
 * Часы, Часы дня, Минуты, Секунды.
 * 4. Используй статический метод getInstance класса Calendar для получения календаря.
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
        SimpleDateFormat sdf;
        Calendar calendar = Calendar.getInstance();
        boolean printDate = false;
        boolean printTime = false;

        try {
            if (date.contains(".") && (date.contains(":"))) {
                sdf = new SimpleDateFormat("dd.M.yyyy hh:mm:ss");
                calendar.setTime(sdf.parse(date));
                printDate = true;
                printTime = true;
            } else if (date.contains(".")) {
                sdf = new SimpleDateFormat("dd.M.yyyy");
                calendar.setTime(sdf.parse(date));
                printDate = true;
            } else if (date.contains(":")) {
                sdf = new SimpleDateFormat("hh:mm:ss");
                calendar.setTime(sdf.parse(date));
                printTime = true;
            }

            if (printDate) {
                System.out.println("День: " + calendar.get(Calendar.DATE));
                int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) - 1);
                dayOfWeek = dayOfWeek == 0 ? 7 : dayOfWeek;
                System.out.println("День недели: " + dayOfWeek);
                System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
                System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
                System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
                System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
                System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
                System.out.println("Год: " + calendar.get(Calendar.YEAR));
            }

            if (printTime) {
                System.out.println("AM или PM: " + (calendar.getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.ENGLISH)));
                System.out.println("Часы: " + calendar.get(Calendar.HOUR));
                System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
                System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
                System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
