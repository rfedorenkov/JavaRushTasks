package com.javarush.task.task25.task2509;

import java.util.concurrent.*;

/**
 * Все не так легко, как кажется
 * 1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable.
 * 2. Реализуй логику метода cancel в классе SocketTask.
 * 3. Реализуй логику метода cancel для локального класса внутри метода newTask в классе SocketTask.
 *
 *
 * Requirements:
 * 1. Определение класса SocketTask, его поля и сигнатуры методов менять нельзя.
 * 2. Метод cancel в классе SocketTask должен закрывать используемые классом ресурсы.
 * 3. Метод cancel для локального класса внутри метода newTask должен закрывать ресурсы SocketTask и вызвать cancel у родительского класса.
 * 4. Метод у родительского класса должен быть вызван, даже если во время закрытия ресурсов было выкинуто исключение.
*/

public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
