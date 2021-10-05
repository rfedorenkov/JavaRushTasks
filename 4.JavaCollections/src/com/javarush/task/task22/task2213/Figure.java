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

    //Тетрис(16)
    //Напиши свою реализацию методов left(), right(), up(), down() в классе Figure.
    //Подумай, что должны делать эти методы?
    //Обрати внимание: в процессе реализации некоторых методов тебе надо будет проверять нарушение границ игрового поля,
    // делать это нужно с помощью существующего метода isCurrentPositionAvailable().
    //
    //
    //Requirements:
    //1. Метод left() должен уменьшать значение поля x на единицу, если это возможно(не нарушены границы игрового поля).
    //2. Метод right() должен увеличивать значение поля x на единицу, если это возможно(не нарушены границы игрового поля).
    //3. Метод up() должен уменьшать значение поля y на единицу.
    //4. Метод down() должен увеличивать значение поля y на единицу.

    /**
     * Движение фигуры влево.
     */
    public void left() {
        x--;
        if (!isCurrentPositionAvailable()) {
            x++;
        }
    }

    /**
     * Движение фигуры вправо.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable()) {
            x--;
        }
    }

    /**
     * Движение фигуры вниз.
     */
    public void down() {
        y++;
        if (!isCurrentPositionAvailable()) {
            y--;
        }
    }

    /**
     * Движение фигуры вверх.
     */
    public void up() {
        y--;
        if (!isCurrentPositionAvailable()) {
            y++;
        }
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