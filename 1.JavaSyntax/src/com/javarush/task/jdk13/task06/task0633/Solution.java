package com.javarush.task.jdk13.task06.task0633;

/**
 * Вырезаем середину
 * Дан двумерный массив chars.
 * Тебе нужно заменить в методе main все внутренние элементы на дефис (минус).
 *
 * Пример массива:
 * a b c d e f
 * j h i j k l
 * m n o p q r
 * s t u v w x
 *
 * После отработки программы массив должен содержать:
 * a b c d e f
 * j - - - - l
 * m - - - - r
 * s t u v w x
 *
 * Обрати внимание: дополнительно делать инициализацию/заполнение/вывод массива chars не нужно:
 * в некоторых случаях это может отрицательно повлиять на тестирование.
 *
 *
 * Требования:
 * 1. В методе main необходимо заменить все внутренние элементы массива chars на дефис (см. пример в условии).
*/

public class Solution {
    public static char[][] chars;

    public static void main(String[] args) {
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (i != 0 && j != 0 && i != chars.length - 1 && j != chars[i].length - 1) {
                    chars[i][j] = '-';
                }
            }
        }
    }
}
