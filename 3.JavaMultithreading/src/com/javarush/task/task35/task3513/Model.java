package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
     * Создает новое игровое поле.
     */
    public Model() {
        resetGameTiles();
    }

    /**
     * Метод создает новое игровое поле по значеню FIELD_WIDTH х FIELD_WIDTH.
     * Инициализирует двумерный массив gameTiles новыми объектами Tile.
     * Создает две плитки случайным образом.
     */
    protected void resetGameTiles() {
        // Инициализируем двумерный массив
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        // Заполняем его пустыми плитками
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        // Создаем две новых плитки
        addTile();
        addTile();
    }

    /**
     * Метод проверяет какие плитки пустуют, и если такие имеются,
     * меняют вес одной из них случайным образом (на 2 или 4).
     * На девять двоек приходится одна четверка.
     */
    private void addTile() {
        // Получаем список пустых плиток
        List<Tile> emptyTiles = getEmptyTiles();

        // Проверяем, что список не пустой
        if (!emptyTiles.isEmpty()) {
            // Получаем размер списка
            int size = emptyTiles.size();
            // Получаем случайную плитку из списка
            Tile tile = emptyTiles.get((int) (size * Math.random()));
            // Устанавливаем вес плитки с вероятностью 90% - 2, 10% - 4
            tile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    /**
     * Метод возвращает список пустых плиток в массиве gameTiles.
     *
     * @return Список пустых плиток.
     */
    private List<Tile> getEmptyTiles() {
        // Создаем новый список
        List<Tile> emptyTilesList = new ArrayList<>();
        // Проверяем есть ли в двумерном массиве пустые плитки
        // Если есть, добавляем в список
        Arrays.stream(gameTiles)
                .forEach(gameTile -> Arrays.stream(gameTile)
                        .filter(Tile::isEmpty)
                        .forEach(emptyTilesList::add));
        // Возвращаем список
        return emptyTilesList;
    }
}
