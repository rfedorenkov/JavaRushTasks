package com.javarush.task.task27.task2707;

/**
 * Определяем порядок захвата монитора
 * Реализуй логику метода isLockOrderNormal, который должен определять:
 * соответствует ли порядок synchronized блоков в методе someMethodWithSynchronizedBlocks - порядку передаваемых в него аргументов.
 * В случае, если сначала происходит синхронизация по o1, а потом по o2, метод должен вернуть true.
 * Если наоборот - false.
 *
 *
 * Requirements:
 * 1. Метод isLockOrderNormal должен возвращать true в случае, если синхронизация
 * в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o1, а потом по o2.
 * 2. Метод isLockOrderNormal должен возвращать false в случае, если синхронизация
 * в методе someMethodWithSynchronizedBlocks происходит сначала по объекту o2, а потом по o1.
 * 3. Метод isLockOrderNormal НЕ должен быть приватным.
 * 4. Класс Solution НЕ должен быть объявлен с модификатором final.
*/

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread oneThread = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(100);
                    synchronized (o2) {

                    }
                } catch (InterruptedException ignored) {
                }
            }
        });

        Thread twoThread = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));

        oneThread.start();
        Thread.sleep(50);
        twoThread.start();

        Thread.sleep(500);

        return twoThread.getState() != Thread.State.BLOCKED;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
