package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;

/**
 * Почитать в инете про медиану выборки
 * Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
 * Верни отсортированный массив от минимального расстояния до максимального.
 * Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.
 *
 * Пример входящего массива:
 * 13, 8, 15, 5, 17
 * медиана - 13
 *
 * Отсортированный масив:
 * 13, 15, 17, 8, 5
 *
 *
 * Requirements:
 * 1. Программа не должна выводить текст в консоль.
 * 2. Программа не должна считывать данные с консоли.
 * 3. Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
 * 4. Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве по удаленности от его медианы.
*/

public class Solution {

    public static void main(String[] args) {

    }

    /**
     * Сортирует данные в массиве по удаленности от его медианы.
     *
     * @param array Массив целых чисел.
     * @return Отсортированный массив.
     */
    public static Integer[] sort(Integer[] array) {
        // Клоннируем массив
        array = array.clone();
        // Получаем медиану массива
        double median = getMedian(array);
        // Сортируем массив по медиане выборке
        Arrays.sort(array, Comparator.comparingDouble(integer -> Math.abs(median - integer)));
        return array;
    }

    /**
     * Получает медиану массива.
     *
     * @param array Массив целых чисел.
     * @return Медиану.
     */
    private static double getMedian(Integer[] array) {
        // Сортируем массив
        Arrays.sort(array);
        // Находим середину
        int middle = array.length / 2;
        // Если количество элементов в массиве нечётное
        if (array.length % 2 != 0) {
            // Возвращаем число стоящее по середине
            return array[middle];
        } else {
            // Медиана равна полусумме двух средних чисел
            return (array[middle - 1] + array[middle]) / 2.0;
        }
    }
}
