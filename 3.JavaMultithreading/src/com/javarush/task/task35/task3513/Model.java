package com.javarush.task.task35.task3513;

/**
 * Класс содержит игровую логику и хранит игровое поле.
 */
public class Model {
    // Ширина игрового поля
    private static final int FIELD_WIDTH = 4;
    // Двумерный массив игрового поля состоящий из плиток (Tile)
    private Tile[][] gameTiles;

    /**
     * Конструктор объекта.
     * Создает игровое игровое поле по значению FIELD_WIDTH х FIELD_WIDTH.
     * Инициализирует двумерный массив gameTiles новыми объектами Tile.
     */
    public Model() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
    }
}