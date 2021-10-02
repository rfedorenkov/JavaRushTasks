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

    /**
     * Метод отображает на экран своё текущее состояние.
     */
    public void print() {

    }

    /**
     * Метод удаляет из матрицы полностью заполненные строки
     * и сдвигает вышележащие строки вниз.
     */
    public void removeFullLines() {

    }

    /**
     * Метод возвращает значение, которое находится в матрице с координатами x и y.
     * @param x Координата x.
     * @param y Координата y.
     * @return Значение, которое находится в матрице по указанным координатам.
     */
    public Integer getValue(int x, int y) {
        return null;
    }

    /**
     * Метод устанавливает переданное значение в ячейку матрицы с координатами x и y.
     * @param x Координата x.
     * @param y Координата y.
     * @param value Значение.
     */
    public void setValue(int x, int y, int value) {

    }
}
