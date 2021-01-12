package com.javarush.task.jdk13.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/**
 * Налоговая и зарплаты
 * Создать словарь (Map) и занести в него десять записей по принципу: «фамилия» - «зарплата».
 * Удалить из словаря всех людей, у которых зарплата ниже 500.
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. Программа не должна считывать значения с клавиатуры.
 * 3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer
 * состоящих из 10 записей по принципу «фамилия» - «зарплата».
 * 4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Pushkin", 1000);
        map.put("Solzhenitsyn", 400);
        map.put("Turgenev", 501);
        map.put("Nabokov", 350);
        map.put("Bulgakov", 440);
        map.put("Bunin", 460);
        map.put("Gogol", 470);
        map.put("Dostoyevsky", 700);
        map.put("Tolstoy", 900);
        map.put("Chekhov", 890);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        map.values().removeIf(i -> i < 500);
    }

    public static void main(String[] args) {

    }
}