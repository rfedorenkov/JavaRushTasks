package com.javarush.task.jdk13.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Удалить всех людей, родившихся летом
 * В словарь (Map<String, Date>) занести десять записей по принципу: «фамилия» - «дата рождения».
 * Удалить из словаря всех людей, родившихся летом.
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Программа не должна считывать значения с клавиатуры.
 * 3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
 * 4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("JULY 6 1946"));
        map.put("Шварценеггер", dateFormat.parse("JULY 30 1947"));
        map.put("Чан", dateFormat.parse("APRIL 7 1954"));
        map.put("Ривз", dateFormat.parse("SEPTEMBER 2 1964"));
        map.put("Депп", dateFormat.parse("JUNE 9 1963"));
        map.put("Джоли", dateFormat.parse("JUNE 4 1975"));
        map.put("Круз", dateFormat.parse("JULY 3 1962"));
        map.put("Форд", dateFormat.parse("JULY 13 1942"));
        map.put("Смит", dateFormat.parse("SEPTEMBER 25 1968"));
        map.put("Клуни", dateFormat.parse("MAY 6 1961"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        map.values().removeIf(date -> date.getMonth() > 4 && date.getMonth() < 8);
    }

    public static void main(String[] args) throws ParseException {

    }
}
