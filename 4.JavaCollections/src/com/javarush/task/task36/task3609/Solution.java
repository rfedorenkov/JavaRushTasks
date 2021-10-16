package com.javarush.task.task36.task3609;

/**
 * Рефакторинг MVC
 * Перемести некоторые методы в нужные классы, что бы получить паттерн MVC.
 * Если необходимо - внеси изменения в метод main, которые отражают внесенные тобой изменения.
 * Поведение программы при этом не должно измениться.
 * НЕ изменяй названия классов, методов и полей.
 *
 *
 * Requirements:
 * 1. Вывод программы должен остаться без изменений.
 * 2. Необходимо переместить метод void increaseSpeed(int) из класса CarModel в класс CarController.
 * 3. Необходимо переместить метод void decreaseSpeed(int) из класса CarModel в класс CarController.
 * 4. В методе main класса Solution метод increaseSpeed необходимо вызывать у контроллера, а не у модели.
 * 5. В методе main класса Solution метод decreaseSpeed необходимо вызывать у контроллера, а не у модели.
*/
public class Solution {
    public static void main(String[] args) {
        // Fetch car record from the database
        CarModel model = CarModel.retrieveCarFromDatabase();

        // Create a view to show the car's speed on a speedometer (the console)
        SpeedometerView view = new SpeedometerView();

        CarController controller = new CarController(model, view);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(15);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(50);
        controller.updateView();

        // Update the model data
        controller.decreaseSpeed(7);
        controller.updateView();
    }
}