package com.javarush.task.jdk13.task09.task0909;

/**
 * Исключение при работе с массивами
 * Перехватить исключение, возникающее при выполнении кода: array[8] = 5;
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
            int[] array = new int[2];
            array[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}