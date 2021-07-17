package com.javarush.task.task26.task2605;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Трудолюбие - душа всякого дела и залог благосостояния
 * Расставь volatile там, где необходимо.
 *
 *
 * Requirements:
 * 1. Класс Solution должен содержать private static поле ScheduledExecutorService interruptScheduledExecutor.
 * 2. Класс Solution должен содержать private static поле Thread taskThread.
 * 3. Класс Solution должен содержать private static поле RethrowableTask task.
 * 4. Класс RethrowableTask должен содержать private поле Throwable throwable.
 * 5. Класс RethrowableTask должен содержать private поле Runnable runnable.
 * 6. Расставь volatile там, где необходимо.
 */

public class Solution {
    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(() -> {
                    System.out.println("A");
                    throw new RuntimeException("it's test");
                }, 1_000, TimeUnit.MILLISECONDS
        );

        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        taskThread.start();

        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(() -> taskThread.interrupt(), timeout, unit);
        Thread.sleep(unit.toMillis(timeout));
        try {
            task.rethrow();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void run() {
            try {
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}
