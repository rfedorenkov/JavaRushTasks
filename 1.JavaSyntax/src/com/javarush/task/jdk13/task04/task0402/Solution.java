package com.javarush.task.jdk13.task04.task0402;

/**
 * Цена Яблок
 * Подсчитать суммарную стоимость яблок.
 * За суммарную стоимость яблок отвечает переменная public static int applesPrice.
 *
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Метод addPrice класса Apple не должен выводить текст на экран.
 * 3. Переменная applesPrice класса Apple должна быть статической, иметь тип int и проинициализирована нулем.
 * 4. Метод main должен вызывать метод addPrice только два раза.
 * 5. Метод addPrice класса Apple должен увеличивать стоимость яблок на переданное значение.
*/

public class Solution {
    public static void main(String[] args) {
        Apple.addPrice(50);
        Apple.addPrice(100);
        System.out.println("Стоимость яблок " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;

        public static void addPrice(int applesPrice) {
            //напишите тут ваш код
            Apple.applesPrice +=applesPrice;

        }
    }
}
