package com.javarush.task.task35.task3513;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Класс следит за нажатием клавиш.
 */
public class Controller extends KeyAdapter {
    // Максимальный вес плитки, при достижении которого игра будет выиграна
    private static final int WINNING_TILE = 2048;
    // Модель
    private Model model;
    // Отображение
    private View view;

    /**
     * Конструктор контролера.
     * Инициализирует модель и создает отображение с параметром this.
     *
     * @param model Модель.
     */
    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);
    }

    /**
     * Метод вызывает у модели аналогичный метод, который возвращает игровое поле.
     *
     * @return Двумерный массив игрового поля состоящий из плиток (Tile)
     */
    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    /**
     * Метод возвращает количество очков (счета) у модели.
     *
     * @return Количество очков (счет).
     */
    public int getScore() {
        return model.score;
    }


    /**
     * Геттер поля view.
     *
     * @return поле view (отображение).
     */
    public View getView() {
        return view;
    }

    /**
     * Перезапуск игры.
     */
    public void resetGame() {
        // Обнуляем счет и максимальный вес плитки
        model.score = 0;
        model.maxTile = 0;
        // Перезапускаем игру, вызываем аналогичный метод у модели.
        model.resetGameTiles();
        // Устанавливаем флаги false у представления
        view.isGameWon = false;
        view.isGameLost = false;
    }

    /**
     * Переопределяем метод, для регистрации нажатий клавиш.
     *
     * @param e Событие.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Если была нажата клавиша ESC - вызываем метод resetGame
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }
        // Если нет ходов
        if (!model.canMove()) {
            // Игра проиграна
            view.isGameLost = true;
        }
        // Если оба флага isGameLost и isGameWon равны false
        if (!view.isGameWon && !view.isGameLost) {
            // Обрабатываем нажатие клавиш и вызываем аналогичный метод у модели
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    model.right();
                    break;
                case KeyEvent.VK_UP:
                    model.up();
                    break;
                case KeyEvent.VK_DOWN:
                    model.down();
                    break;
            }
        }

        // Если максимальный вес плитки достигнут предела
        if (model.maxTile == WINNING_TILE) {
            // Игра выиграна
            view.isGameWon = true;
        }

        // Перерисовываем отображение
        view.repaint();
    }
}