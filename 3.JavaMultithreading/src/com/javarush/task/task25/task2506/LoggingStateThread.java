package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private final Thread thread;

    public LoggingStateThread(Thread target) {
        thread = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state, lastState = null;

        do {
            state = thread.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        } while (state != State.TERMINATED);
    }
}