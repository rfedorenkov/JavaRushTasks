package com.javarush.task.jdk13.task09.task0906;

/**
 * Логирование стек трейса
 * Реализовать метод log так, чтобы он выводил на экран имя класса и имя метода (в котором вызывается метод log),
 * а также переданное сообщение. Имя класса, имя метода и сообщение разделить двоеточием с пробелом.
 * Пример вывода: com.javarush.task.jdk13.task09.task0906.Solution: main: In method
 * Получение имени класса из StackTraceElement: String className = element.getClassName();
 *
 * Требования:
 * 1. В методе log нужно выводить сообщение на экран.
 * 2. Выведенное сообщение должно содержать имя класса, метод которого вызвал метод log.
 * 3. Выведенное сообщение должно содержать имя метода, который вызвал метод log.
 * 4. Выведенное сообщение должно содержать переданное сообщение.
 * 5. Вывод должен соответствовать примеру из задания.
*/

public class Solution {

    public static void main(String[] args) {
        log("In method");
    }

    public static void log(String text) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        System.out.printf("%s: %s: %s%n", className, methodName, text);
    }
}
