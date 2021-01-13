package com.javarush.task.jdk13.task09.task0910;

import java.util.ArrayList;

/**
 * Исключение при работе с коллекциями List
 * Перехватить исключение, возникающее при выполнении кода: String s = list.get(18);
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
            ArrayList<String> list = new ArrayList<>();
            String s = list.get(18);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}