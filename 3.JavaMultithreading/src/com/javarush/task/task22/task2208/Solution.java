package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Формируем WHERE
 * Сформируй часть запроса WHERE используя StringBuilder.
 * Если значение null, то параметр не должен попадать в запрос.
 *
 * Пример:
 * {name=Ivanov, country=Ukraine, city=Kiev, age=null}
 *
 * Результат:
 * name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
 *
 *
 * Требования:
 * 1. Метод getQuery должен принимать один параметр типа Map.
 * 2. Метод getQuery должен иметь тип возвращаемого значения String.
 * 3. Метод getQuery должен быть статическим.
 * 4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null) {
                String format = String.format("%s = '%s'", key, value);
                if (result.length() != 0) {
                    result.append(" and ");
                }
                result.append(format);
            }
        }
        return result.toString();
    }
}
