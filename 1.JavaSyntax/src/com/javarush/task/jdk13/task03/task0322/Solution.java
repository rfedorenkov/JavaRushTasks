package com.javarush.task.jdk13.task03.task0322;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Чистая любовь
 * Введи с клавиатуры три имени, а затем выведи на экран надпись: name1 + name2 + name3 = Чистая любовь, да-да!
 *
 * Пример:
 * Вася + Ева + Анжелика = Чистая любовь, да-да!
 *
 *
 * Требования:
 * 1. Программа должна выводить текст.
 * 2. Программа должна считывать данные с клавиатуры.
 * 3. Выведенный текст должен содержать введенное имя name1.
 * 4. Выведенный текст должен содержать введенное имя name2.
 * 5. Выведенный текст должен содержать введенное имя name3.
 * 6. Выведенный тест должен полностью соответствовать заданию.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameOne = reader.readLine();
        String nameTwo = reader.readLine();
        String nameThree = reader.readLine();

        System.out.printf("%s + %s + %s = Чистая любовь, да-да!", nameOne, nameTwo, nameThree);
        reader.close();

    }
}