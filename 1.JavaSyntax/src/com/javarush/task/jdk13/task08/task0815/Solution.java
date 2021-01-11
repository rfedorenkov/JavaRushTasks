package com.javarush.task.jdk13.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/**
 * Одинаковые имя и фамилия
 * Создать словарь (Map) занести в него десять записей по принципу «Фамилия» - «Имя».
 * Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Программа не должна считывать значения с клавиатуры.
 * 3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String,
 * String состоящих из 10 записей по принципу «Фамилия» - «Имя».
 * 4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
 * 5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Pushkin", "Alexander");
        map.put("Solzhenitsyn", "Alexander");
        map.put("Turgenev", "Ivan");
        map.put("Nabokov", "Vladimir");
        map.put("Bulgakov", "Mikhail");
        map.put("Bunin", "Ivan");
        map.put("Gogol", "Nikolai");
        map.put("Dostoyevsky", "Fyodor");
        map.put("Tolstoy", "Leo");
        map.put("Chekhov", "Anton");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        return (int) map.values().stream().filter(name::equals).count();
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        return map.containsKey(lastName) ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
