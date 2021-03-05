package com.javarush.task.jdk13.task03.task0318;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Как захватить мир
 * Введи с клавиатуры имя и число, а затем выведи на экран строку: Через «число» лет «имя» захватит мир. Му-ха-ха!
 *
 * Пример:
 * Через 8 лет Вася захватит мир. Му-ха-ха!
 *
 * Последовательность вводимых данных имеет большое значение.
 *
 *
 * Требования:
 * 1. Программа должна выводить текст.
 * 2. Программа должна считывать данные с клавиатуры.
 * 3. Выведенный текст должен содержать введенное имя.
 * 4. Выведенный текст должен содержать введенное число.
 * 5. Выведенный текст должен полностью соответствовать заданию.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        int age = Integer.parseInt(br.readLine());

        System.out.printf("Через %d лет %s захватит мир. Му-ха-ха!", age, name);
        br.close();
    }
}
