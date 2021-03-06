package com.javarush.task.jdk13.task07.task0706;

import java.io.IOException;
import java.util.Scanner;

/**
 * Улица и дома
 * 1. Создать массив на 15 целых чисел.
 * 2. Ввести в него значения с клавиатуры.
 * 3. Пускай индекс элемента массива является номером дома, а значение - числом жителей, проживающих в доме.
 * Дома с нечетными номерами расположены на одной стороне улицы, с четными — на другой.
 * Выяснить, на какой стороне улицы проживает больше жителей.
 * 4. Вывести на экран сообщение: "В домах с нечетными номерами проживает больше жителей."
 * или "В домах с четными номерами проживает больше жителей."
 * Примечание: дом с порядковым номером 0 считать четным.
 *
 * Требования:
 * 1. Программа должна создавать массив и инициализировать его значением new int[15].
 * 2. Программа должна считывать числа для массива с клавиатуры.
 * 3. Программа должна вывести сообщение "В домах с нечетными номерами проживает больше жителей.",
 * если сумма нечетных элементов массива больше суммы четных.
 * 4. Программа должна вывести сообщение "В домах с четными номерами проживает больше жителей.",
 * если сумма четных элементов массива больше суммы нечетных.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[15];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < array.length; i++) {
            int numberOfResidents = scanner.nextInt();
            if (i % 2 == 0) {
                even += numberOfResidents;
            } else {
                odd += numberOfResidents;
            }
            array[i] = numberOfResidents;
        }
        System.out.printf("В домах с %sчетными номерами проживает больше жителей.%n", even > odd ? "" : "не");
    }
}
