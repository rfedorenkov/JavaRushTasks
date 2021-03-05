package com.javarush.task.jdk13.task04.task0442;

import java.util.Scanner;

/**
 * Суммирование
 * Давай напишем программу, в которой нужно будет вводить числа с клавиатуры,
 * и как только будет введено -1, вывести на экран сумму всех чисел и завершить программу.
 * -1 должно учитываться в сумме.
 *
 * Подсказка: один из вариантов решения этой задачи - использовать конструкцию:
 * while (true) {
 * int number = считываем число;
 * if (проверяем, что number -1)
 * break;
 * }
 *
 *
 * Требования:
 * 1. Программа должна считывать числа c клавиатуры.
 * 2. Если пользователь ввел -1, программа должна вывести сумму всех введенных чисел на экран и завершиться.
 * 3. Программа должна посчитать сумму введенных чисел и вывести её на экран.
 * 4. В программе должен использоваться цикл for, while или do-while.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int number = scanner.nextInt();
            sum += number;
            if (number == -1) {
                break;
            }
        }
        scanner.close();
        System.out.println(sum);
    }
}
