package com.javarush.task.jdk13.task04.task0432;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Хорошего не бывает много
 * Введи с клавиатуры строку и число N больше 0.
 * Выведи на экран строку N раз, используя цикл while. Каждое значение - с новой строки.
 *
 * Пример ввода:
 * абв
 * 2
 * Пример вывода:
 * абв
 * абв
 *
 *
 * Требования:
 * 1. Программа должна считывать текст c клавиатуры.
 * 2. Программа должна выводить текст на экран.
 * 3. Каждое значение должно быть выведено с новой строки.
 * 4. Программа должна выводить на экран строку N раз.
 * 5. В программе должен использоваться цикл while.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        int repeatCount = Integer.parseInt(br.readLine());
        br.close();
        while (repeatCount-- > 0) {
            System.out.println(expression);
        }
    }
}
