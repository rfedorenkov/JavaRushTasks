package com.javarush.task.jdk13.task06.task0607;

/**
 * Подсчет котов
 * Создай статическую переменную int catCount в классе Cat.
 * Создай конструктор [public Cat()] и в нем увеличивай данную переменную на 1.
 *
 *
 * Требования:
 * 1. Добавь в класс Cat конструктор.
 * 2. Конструктор должен быть public.
 * 3. Добавь в класс Cat поле catCount.
 * 4. Поле catCount должно быть типа int.
 * 5. Поле catCount должно быть статическим.
 * 6. Конструктор класса должен увеличивать на 1 значение переменной catCount.
*/

public class Cat {
    private static int catCount = 0;

    public Cat() {
        catCount++;
    }

    public static void main(String[] args) {

    }
}
