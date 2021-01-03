package com.javarush.task.jdk13.task06.task0608;

/**
 * Статические методы: int getCatCount() и setCatCount(int)
 * Реализуй в классе Cat два статических метода: int getCatCount() и setCatCount(int),
 * с помощью которых можно получить/изменить количество котов (переменную catCount).
 *
 *
 * Требования:
 * 1. В классе Cat должен быть метод getCatCount.
 * 2. Метод getCatCount должен возвращать int.
 * 3. Метод getCatCount должен возвращать значение переменной catCount.
 * 4. В классе Cat должен быть метод setCatCount, принимающий int.
 * 5. Метод setCatCount ничего не должен возвращать.
 * 6. Метод setCatCount должен присваивать переменной catCount переданное значение.
*/

public class Cat {
    private static int catCount = 0;

    public Cat() {
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    public static void setCatCount(int catCount) {
        Cat.catCount = catCount;
    }

    public static void main(String[] args) {

    }
}
