package com.javarush.task.jdk13.task08.task0817;

import java.util.*;

/**
 * Удалить людей, имеющих одинаковые имена
 * Создать словарь (Map) занести в него десять записей по принципу «фамилия» - «имя».
 * Удалить людей, имеющих одинаковые имена.
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Программа не должна считывать значения с клавиатуры.
 * 3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String,
 * String состоящих из 10 записей.
 * 4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
 * 5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
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

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Map<String, String> copy = new HashMap<>(map);
        for (String name : copy.values()) {
            boolean hasDuplicates = (int) map.values().stream().filter(name::equals).count() > 1;
            if (hasDuplicates) {
                removeItemFromMapByValue(map, name);
            }
        }

    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {

    }
}
