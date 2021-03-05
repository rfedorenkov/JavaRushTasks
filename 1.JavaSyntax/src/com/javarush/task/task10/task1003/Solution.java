package com.javarush.task.task10.task1003;

/**
 * Задача №3 на преобразование целых типов
 * Добавь одну операцию по преобразованию типа, чтобы получился ответ: b = 0.
 * float f = (float)128.50;
 * int i = (int)f;
 * int b = (int)(i + f);
 *
 *
 * Требования:
 * 1. Программа должна выводить текст на экран.
 * 2. Нельзя менять команду вывода на экран.
 * 3. Метод main() должен содержать переменную f типа float.
 * 4. Метод main() должен содержать переменную i типа int.
 * 5. Метод main() должен содержать переменную b типа int.
 * 6. Начальное значение переменных при инициализации менять нельзя. Можно добавлять только операторы приведения типа.
 * 7. Программа должна выводить число 0.
*/

public class Solution {
    public static void main(String[] args) {
        float f = (float) 128.50;
        int i = (int) f;
        int b = (byte) (i + f);
        System.out.println(b);
    }
}
