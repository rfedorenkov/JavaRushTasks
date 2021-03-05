package com.javarush.task.jdk13.task07.task0707;

import java.util.ArrayList;

/**
 * 5 различных строк в списке
 * 1. Проинициализируй поле list в методе main.
 * 2. Добавь в список list 5 различных строк.
 * 3. Выведи размер списка на экран.
 * 4. Используя цикл выведи его содержимое на экран, каждое значение с новой строки.
 * Примечание: Добавляй строки в список только после того, как список инициализирован.
 *
 * Требования:
 * 1. Поле list типа ArrayList<String> должно быть проинициализировано в методе main.
 * 2. Программа должна добавить 5 любых строк в список.
 * 3. Программа должна вывести размер списка на экран.
 * 4. Программа должна вывести содержимое списка на экран, каждое значение с новой строки.
*/

public class Solution {
    
    public static ArrayList<String> list;
    
    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add("First line");
        list.add("Second line");
        list.add("Third line");
        list.add("Fourth line");
        list.add("Fifth line");

        System.out.println(list.size());

        list.forEach(System.out::println);
    }
}
