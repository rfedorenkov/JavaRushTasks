package com.javarush.task.jdk13.task09.task0911;

import java.util.HashMap;

/**
 * Исключение при работе с коллекциями Map
 * Перехватить исключение, возникающее при выполнении кода:
 * HashMap<String, String> map = new HashMap<String, String>(null);
 * Вывести исключение на экран любым способом (вывод должен содержать тип возникшего исключения).
 *
 * Требования:
 * 1. Программа должна выводить сообщение на экран.
 * 2. В программе должен быть блок try-catch.
 * 3. Программа должна отлавливать исключения конкретного типа, возникающее в указанной строке.
 * 4. Выведенное сообщение должно содержать тип возникшего исключения.
 * 5. Имеющийся код в методе main не удалять.
*/

public class Solution {

    public static void main(String[] args) {
        try {
            HashMap<String, String> map = new HashMap<>(null);
            System.out.println(map);
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }
}
