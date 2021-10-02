package com.javarush.task.task22.task2213;

/**
 * Класс игрового поля.
 * Отвечает за хранение данных о текущих занятых и свободных клетках на поле игры.
 */
public class Field {
    //Ширины
    private int width;
    // Высота
    private int height;
    // Матрица поля
    private int[][] matrix;

    /**
     * Конструктор игрового поля.
     * @param width Ширина поля.
     * @param height Высота поля.
     */
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new int[height][width];
    }

    /**
     * Геттер ширины поля.
     * @return width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Геттер высоты поля.
     * @return height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Геттер матрицы поля.
     * @return matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }
}
