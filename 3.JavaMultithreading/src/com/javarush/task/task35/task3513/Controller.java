package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;

/**
 * Класс следит за нажатием клавиш.
 */
public class Controller extends KeyAdapter {
    // Модель
    private Model model;
    // Отображение
    private View view;

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
}

//3. Сделай класс Controller потомком класса KeyAdapter.
//4. Добавь в класс Controller метод getGameTiles вызывающий такой же метод у модели.
//5. Добавь в класс Controller метод getScore возвращающий текущий счет (model.score).