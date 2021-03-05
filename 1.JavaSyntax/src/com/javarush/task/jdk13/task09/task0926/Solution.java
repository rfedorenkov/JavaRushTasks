package com.javarush.task.jdk13.task09.task0926;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Список из массивов чисел
 * В методе createList:
 * - создать список, элементами которого будут массивы чисел;
 * - добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно;
 * - заполнить массивы любыми данными.
 *
 * Требования:
 * 1. Программа не должна считывать данные с клавиатуры.
 * 2. В методе createList необходимо объявить и инициализировать переменную типа ArrayList<int[]>.
 * 3. В методе createList необходимо вернуть созданный список.
 * 4. В методе createList необходимо добавить в список 5 элементов.
 * 5. Каждый элемент в списке должен быть массивом чисел.
 * Длина первого должна быть 5 элементов, второго - 2, следующих - 4, 7, 0 соответственно.
 * 6. Программа должна выводить на экран все массивы из списка. Каждый массив с новой строки.
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2, 3, 4, 5});
        list.add(new int[]{1, 2});
        list.add(new int[]{1, 2, 3, 4});
        list.add(new int[]{1, 2, 3, 4, 5, 6, 7});
        list.add(new int[0]);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            System.out.println(Arrays.toString(array));
        }
    }
}
