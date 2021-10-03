package com.javarush.task.task22.task2213;

/**
 * Класс фигуры.
 */
public class Figure {
    // Координаты
    private int x;
    private int y;

    // Форма фигуры (состоящий из единиц и нулей)
    private int[][] matrix;

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

    /**
     * Движение фигуры влево.
     */
    public void left() {

    }

    /**
     * Движение фигуры вправо.
     */
    public void right() {

    }

    /**
     * Движение фигуры вниз.
     */
    public void down() {

    }

    /**
     * Движение фигуры вверх.
     */
    public void up() {

    }

    /**
     * Метод поворачивает фигуру.
     */
    public void rotate() {

    }

    /**
     * Падение фигуры вниз до дна.
     */
    public void downMaximum() {

    }

    /**
     * Метод проверяет, может ли фигуры быть помещена в текущую позицию.
     * @return Может ли фигура помещена в текущую позицию.
     */
    public boolean isCurrentPositionAvailable() {
        return true;
    }

    /**
     * Метод вызывается, когда фигурка
     * достигла дна или уперлась в другую фигуру.
     */
    public void landed() {

    }
}