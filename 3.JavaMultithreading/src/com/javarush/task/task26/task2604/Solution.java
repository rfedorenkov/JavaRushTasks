package com.javarush.task.task26.task2604;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Для того, чтобы усовершенствовать ум, надо больше размышлять, чем заучивать
 * Расставь volatile там, где необходимо.
 *
 *
 * Requirements:
 * 1. Класс Solution должен содержать public static final поле String DEFAULT_JAVARUSH_THREAD_NAME.
 * 2. Класс Solution должен содержать private static final поле AtomicInteger createdThreadIndex.
 * 3. Класс Solution должен содержать private static final поле AtomicInteger aliveThreadIndex.
 * 4. Класс Solution должен содержать private static final поле Logger log.
 * 5. Класс Solution должен содержать private static поле boolean debugSession.
 * 6. Расставь volatile там, где необходимо.
*/

public class Solution extends Thread {
    public static final String DEFAULT_JAVARUSH_THREAD_NAME = "JavaRushThread";

    private static final AtomicInteger createdThreadIndex = new AtomicInteger();
    private static final AtomicInteger aliveThreadIndex = new AtomicInteger();

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
    }

    private static final Logger log = Logger.getLogger(Solution.class.getName());

    private static volatile boolean debugSession = true;

    public Solution() {
        this(DEFAULT_JAVARUSH_THREAD_NAME);
    }

    public Solution(String name) {
        super(name + "-" + createdThreadIndex.incrementAndGet());

        setUncaughtExceptionHandler((t, e) ->
                log.log(Level.SEVERE, "An error occurred in thread " + t.getName(), e));
    }

    public static void main(String[] args) {
        new Solution().start();
        new Solution().start();
        new Solution().start();
    }

    @Override
    public void run() {
        boolean debug = debugSession;
        if (debug) {
            log.log(Level.INFO, "Created " + getName());
        }
        try {
            aliveThreadIndex.incrementAndGet();
            log.log(Level.INFO, "Thread " + getName() + " in progress...");
            throw new RuntimeException("Oops " + getName());
        } finally {
            aliveThreadIndex.decrementAndGet();
            if (debug) {
                log.log(Level.INFO, "Exiting " + getName());
            }
        }
    }

    public static int getThreadsCreated() {
        return createdThreadIndex.get();
    }

    public static int getThreadsAlive() {
        return aliveThreadIndex.get();
    }

    public static boolean isDebug() {
        return debugSession;
    }

    public static void setDebug(boolean ds) {
        debugSession = ds;
    }
}
