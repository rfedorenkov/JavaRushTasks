package com.javarush.task.jdk13.task09.task0920;

/**
 * Обратный отсчет от 5 до 0
 * В цикле идет обратный отсчет от 5 до 0.
 * Добавь задержку используя Thread.sleep(100);
 * Оберни вызов sleep в try..catch.
 *
 * Требования:
 * 1. Программа должна выводить отсчет от 5 до 0.
 * 2. Программа должна выводить на экран новое число каждые 100 миллисекунд.
 * 3. Программа должна использовать метод "Thread.sleep(100);".
 * 4. В методе main необходимо использовать блок try..catch.
 * 5. В методе main не выбрасывать исключения.
*/

public class Solution {
    public static void main(String[] args) {
        for (int i = 5; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
