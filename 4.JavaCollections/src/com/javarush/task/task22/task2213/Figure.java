package com.javarush.task.task22.task2213;

/**
 * Класс фигуры.
 */
public class Figure {
    // Координаты
    private int x;
    private int y;

    // Форма фигуры (состоящий из единиц и нулей)
    private int[][] matrix = new int[3][3];

    /**
     *
     * @param x
     * @param y
     * @param matrix
     */
    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    /**
     * Геттер координаты x.
     * @return Координату x.
     */
    public int getX() {
        return x;
    }

    /**
     * Геттер координаты y.
     * @return Координату y.
     */
    public int getY() {
        return y;
    }

    /**
     * Геттер формы фигуры.
     * @return Матрицу matrix.
     */
    public int[][] getMatrix() {
        return matrix;
    }
}