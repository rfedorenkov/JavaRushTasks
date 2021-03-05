package com.javarush.task.jdk13.task08.task0813;

import java.util.HashSet;
import java.util.Set;

/**
 * 20 слов на букву «Л»
 * Создать множество строк (Set), занести в него 20 слов на букву «Л».
 *
 * Требования:
 * 1. Не изменяй объявление метода createSet().
 * 2. Метод createSet() должен создавать и возвращать множество (реализация HashSet).
 * 3. Множество из метода createSet() должно содержать 20 слов на букву «Л».
*/

public class Solution {
    public static Set<String> createSet() {
        Set<String> set = new HashSet<>();
        set.add("Лиса");
        set.add("Лось");
        set.add("Лягушка");
        set.add("Лестница");
        set.add("Ловушка");
        set.add("Ледник");
        set.add("Лаванда");
        set.add("Лавр");
        set.add("Лево");
        set.add("Лень");
        set.add("Лапа");
        set.add("Лошадь");
        set.add("Лопух");
        set.add("Ложка");
        set.add("Левша");
        set.add("Липа");
        set.add("Лопасть");
        set.add("Лор");
        set.add("Ледокол");
        set.add("Ложь");
        return set;
    }

    public static void main(String[] args) {

     }
}
