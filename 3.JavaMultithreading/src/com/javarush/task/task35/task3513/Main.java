package com.javarush.task.task35.task3513;

import javax.swing.*;

/**
 * Класс, который запускает игру 2048.
 */
public class Main {
    /**
     * Запуск игры 2048
     */
    public static void main(String[] args) {
        // Создаем модель
        Model model = new Model();
        // Создаем контролер (отображение создается в контролере)
        Controller controller = new Controller(model);
        // Создаем даилоговое окно игры
        JFrame game = new JFrame();
        // Устанавливаем название игры в окне
        game.setTitle("2048");
        // Закрытие программы при закрытии окна
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Устанавливаем размер окна
        game.setSize(450, 500);
        // Запрещаем изменение размера
        game.setResizable(false);
        // Добавляем отображение
        game.add(controller.getView());
        // Размещаем окно по центру
        game.setLocationRelativeTo(null);
        // Делаем окно видимым
        game.setVisible(true);
    }
}