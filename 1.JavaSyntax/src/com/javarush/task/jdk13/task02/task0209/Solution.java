package com.javarush.task.jdk13.task02.task0209;

/**
 * Три собаки - это сила
 * Создай 3 объекта типа Dog (собака). Сохрани каждый экземпляр в отдельную переменную.
 * Присвой им имена "Max", "Bella", "Jack".
 *
 *
 * Требования:
 * 1. Программа не должна выводить текст на экран.
 * 2. В методе main должно быть только три переменные.
 * 3. Переменным сразу должны быть присвоены значения.
 * 4. Каждому объекту типа Dog должно быть присвоено имя.
 * 5. В классе Dog должна быть одна переменная name.
 * 6. В классе Dog не должно быть методов.
*/

public class Solution {
    public static void main(String[] args) {
        Dog max = new Dog();
        max.name = "Max";

        Dog bella = new Dog();
        bella.name = "Bella";

        Dog jack = new Dog();
        jack.name = "Jack";
    }

    public static class Dog {
        public String name;
    }
}
