package com.javarush.task.jdk13.task06.task0605;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Индекс массы тела
 * Напиши программу, которая будет считывать введенные пользователем вес в килограммах,
 * рост — в метрах и выводить на экран сообщение об индексе массы тела.
 * Реализуй статический метод класса Body. Метод должен определить индекс массы тела и вывести на экран сообщение:
 * "Недовес: меньше, чем 18.5" — если индекс массы тела меньше 18.5 (не включительно),
 * "Нормальный: между 18.5 и 25" — если индекс массы тела между 18.5 и 25 (не включительно),
 * "Избыточный вес: между 25 и 30" — если индекс массы тела между 25 и 30 (не включительно),
 * "Ожирение: 30 или больше" — если индекс массы тела 30 или больше.
 *
 * Подсказка: Индекс массы тела = вес в кг / (рост в метрах * рост в метрах).
 *
 * Пример вывода для 68.4 и 1.77:
 * Нормальный: между 18.5 и 25
 *
 *
 * Требования:
 * 1. Метод calculateMassIndex должен выводить текст на экран.
 * 2. Метод calculateMassIndex должен выводить "Недовес: меньше, чем 18.5" на экран,
 * если индекс массы тела меньше 18.5 (не включительно).
 * 3. Метод calculateMassIndex должен выводить "Нормальный: между 18.5 и 25" на экран,
 * если индекс массы тела между 18.5 и 25 (не включительно).
 * 4. Метод calculateMassIndex должен выводить "Избыточный вес: между 25 и 30" на экран,
 * если индекс массы тела между 25 и 30 (не включительно).
 * 5. Метод calculateMassIndex должен выводить "Ожирение: 30 или больше" на экран,
 * если индекс массы тела 30 или больше.
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            double bodyMassIndex = weight / (height * height);

            if (bodyMassIndex < 18.5) {
                System.out.println("Недовес: меньше, чем 18.5");
            } else if (bodyMassIndex < 25) {
                System.out.println("Нормальный: между 18.5 и 25");
            } else if (bodyMassIndex < 30) {
                System.out.println("Избыточный вес: между 25 и 30");
            } else {
                System.out.println("Ожирение: 30 или больше");
            }
        }
    }
}
