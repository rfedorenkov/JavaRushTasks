package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private final Thread thread;
    private State state;

    public LoggingStateThread(Thread target) {
        thread = target;
        state = thread.getState();
        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(state);
        while (true) {
            if (state != thread.getState()) {
                state = thread.getState();
                System.out.println(state);
            }
        }
    }
}