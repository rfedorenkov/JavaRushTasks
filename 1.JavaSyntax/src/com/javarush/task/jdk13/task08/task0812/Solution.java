package com.javarush.task.jdk13.task08.task0812;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Самая длинная последовательность
 * 1. Создай список чисел.
 * 2. Добавь в список 10 чисел с клавиатуры.
 * 3. Вывести на экран длину самой длинной последовательности повторяющихся чисел в списке.
 * Пример для списка 2, 4, 4, 4, 8, 8, 4, 12, 12, 14: 3 Искомое значение равно 3, т.к. самая длинная
 * последовательность повторяющихся чисел состоит из трех четверок.
 *
 * Требования:
 * 1. Программа должна выводить число на экран.
 * 2. Программа должна считывать значения с клавиатуры.
 * 3. В методе main объяви переменную типа List с типом элементов Integer и сразу проинициализируй ee.
 * 4. Программа должна добавлять в коллекцию 10 чисел, согласно условию.
 * 5. Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(scanner.nextInt());
        }

        int maximumSequenceLength = 0;
        int sequenceLength = 1;

        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i).equals(integers.get(i - 1))) {
                sequenceLength++;
            } else {
                sequenceLength = 1;
            }
            if (maximumSequenceLength < sequenceLength) {
                maximumSequenceLength = sequenceLength;
            }
        }

        System.out.println(maximumSequenceLength);
    }
}
