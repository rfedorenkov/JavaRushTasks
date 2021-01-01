package com.javarush.task.jdk13.task05.task0523;

/**
 * Конструктор
 * Разберись, что делает программа. Найди и исправь одну ошибку в классе Circle. Метод main изменять нельзя.
 *
 * Подсказка: изучи конструктор по умолчанию.
 *
 *
 * Требования:
 * 1. Метод main изменять нельзя.
 * 2. Программа должна вывести слово "Red" на экран.
 * 3. Метод getDescription класса Color должен возвращать значение переменной description.
 * 4. Метод setDescription класса Color должен устанавливать значение переменной description.
*/

public class Circle {
    public Color color;

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.color.setDescription("Red");
        System.out.println(circle.color.getDescription());
    }

    public Circle() {
        color = new Color();
    }

    public class Color {
        String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
