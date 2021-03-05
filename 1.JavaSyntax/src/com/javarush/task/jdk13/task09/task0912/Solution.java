package com.javarush.task.jdk13.task09.task0912;

/**
 * Исключение при работе с числами
 * Перехватить исключение, возникающее при выполнении кода: int num=Integer.parseInt("XYZ");
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
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}
