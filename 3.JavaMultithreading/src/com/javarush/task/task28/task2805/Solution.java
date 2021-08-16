package com.javarush.task.task28.task2805;

/**
 * Приоритеты в Threads
 * В отдельном файле создай класс MyThread унаследовавшись от Thread.
 * MyThread должен:
 * 1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
 * 2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
 * 3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда не может быть
 * больше максимального приоритета его трэд-группы.
 *
 *
 * Requirements:
 * 1. Создай класс MyThread в отдельном файле. Унаследуй его от Thread.
 * 2. В классе MyThread должны присутствовать конструкторы, аналогичные конструкторам супер-класса.
 * 3. Приоритет у объектов MyThread должен проставляться циклично, от MIN_PRIORITY до MAX_PRIORITY.
 * 4. Если у объекта MyThread установлена ThreadGroup, приоритет MyThread не должен быть
 * выше максимального приоритета ThreadGroup.
*/

public class Solution {

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread().getPriority() + " ");
        }
        //output
        //1 2 3 4 5 6 7 8 9 10 1 2

        System.out.println();
        ThreadGroup group = new ThreadGroup("someName");
        group.setMaxPriority(7);
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread(group, "name" + i).getPriority() + " ");
        }
        //output
        //3 4 5 6 7 7 7 7 1 2 3 4
    }

}
