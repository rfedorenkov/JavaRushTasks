package com.javarush.task.pro.task09.task0909;

/**
 * Экранирование символов
 * Выведи на экран следующий текст в две строки:
 * It's Windows path: "C:\Program Files\Java\jdk-13.0.0\bin"
 * It's Java string: \"C:\\Program Files\\Java\\jdk-13.0.0\\bin\"
 *
 * Подсказка:
 * \” – экранирование двойной кавычки;
 * \\ – экранирование обратной косой черты (\).
 *
 * Больше про экранирование символов и Escape-последовательности в Java читай в статье "Экранирование символов в Java".
 *
 *
 * Требования:
 * 1. Нужно, чтобы программа выводила текст.
 * 2. Нужно, чтобы было выведено две строки.
 * 3. Текст первой строки должен быть: It's Windows path: "C:\Program Files\Java\jdk-13.0.0\bin"
 * 4. Текст второй строки должен быть: It's Java string: \"C:\\Program Files\\Java\\jdk-13.0.0\\bin\"
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println("It's a Windows path: \"C:\\Program Files\\Java\\jdk-13.0.0\\bin\"");
        System.out.println("It's a Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk-13.0.0\\\\bin\\\"");
    }
}
