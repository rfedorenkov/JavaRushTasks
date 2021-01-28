package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * НОД
 * Давай найдем наибольший общий делитель (НОД). Для этого:
 * Введи с клавиатуры 2 целых положительных числа.
 * Выведи в консоли наибольший общий делитель.
 *
 * Требования:
 * 1. Программа должна считывать с клавиатуры 2 строки.
 * 2. Если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
 * 3. Программа должна выводить данные на экран.
 * 4. Программа должна выводить на экран наибольший общий делитель (НОД) чисел, считанных с клавиатуры,
 * и успешно завершаться.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int valueOne = Integer.parseInt(br.readLine());
        int valueTwo = Integer.parseInt(br.readLine());
        System.out.println(GCD(valueOne, valueTwo));
    }

    private static int GCD(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException();
        }
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}
