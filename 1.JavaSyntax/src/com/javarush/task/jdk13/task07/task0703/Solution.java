package com.javarush.task.jdk13.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 2 массива
 * 1. Создать массив на 10 строк.
 * 2. Создать массив на 10 чисел.
 * 3. Ввести с клавиатуры 10 строк, заполнить ими массив строк.
 * 4. В каждую ячейку массива чисел записать длину строки из массива строк,
 * индекс/номер ячейки которой совпадает с текущим индексом из массива чисел.
 * Вывести содержимое массива чисел на экран, каждое значение выводить с новой строки.
 *
 * Требования:
 * 1. Программа должна создавать массив и инициализировать его значением new String[10].
 * 2. Программа должна создавать массив и инициализировать его значением new int[10].
 * 3. Программа должна считывать строки для массива с клавиатуры.
 * 4. Программа должна в массив чисел записать длины строк из массива строк, а затем их вывести на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = new String[10];
        int[] integers = new int[10];

        for (int i = 0; i < strings.length; i++) {
            String s = br.readLine();
            strings[i] = s;
            integers[i] = s.length();
        }

        for (int integer : integers) {
            System.out.println(integer);
        }
    }
}
