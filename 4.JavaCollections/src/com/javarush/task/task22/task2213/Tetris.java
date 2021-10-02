package com.javarush.task.task22.task2213;

/**
 * Главный класс игры Tetris.
 */
public class Tetris {

    // Игра
    static Tetris game;

    // Поле
    private Field field;
    // Фигура
    private Figure figure;

    /**
     * Геттер фигуры.
     * @return figure.
     */
    public Figure getFigure() {
        return figure;
    }

    /**
     * Сеттер фигуры.
     * @param figure Фигура.
     */
    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    /**
     * Геттер поля.
     * @return поле.
     */
    public Field getField() {
        return field;
    }

    /**
     * Сеттер поля.
     * @param field поле.
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * Метод отвечает за всю игру.
     */
    public void run() {

    }

    /**
     * Метод отвечает за один шаг в игре.
     */
    public void step() {

    }


    /**
     * Запуск игры Tetris.
     */
    public static void main(String[] args) {
        // Инициализация игры
        game = new Tetris();
        // Запуск игры
        game.run();
    }
}