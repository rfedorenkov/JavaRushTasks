package com.javarush.task.task34.task3405;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Мягкие ссылки
 * Разберись в примере.
 * Внутри метода main после создания объекта типа Monkey создай мягкую ссылку (SoftReference) на него.
 *
 *
 * Requirements:
 * 1. В методе main должен быть создан объект типа Monkey с именем "Simka".
 * 2. В методе main должен быть создан SoftReference на объект monkey.
 * 3. Класс Monkey должен быть публичным.
 * 4. Класс Monkey должен быть статическим.
*/

public class Solution {
    public static Helper helper = new Helper();

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();

        Monkey monkey = new Monkey("Simka");

        //Add reference here
        SoftReference<Monkey> reference = new SoftReference<>(monkey);

        helper.callGC();

        monkey = null;

        helper.callGC();
        helper.consumeHeap();

        if (reference.get() == null)
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        void consumeHeap() {
            try {
                List<Solution> heap = new ArrayList<>(100000);
                while (!isFinalized) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("An out-of-memory exception has occurred");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " s");
        }
    }
}
