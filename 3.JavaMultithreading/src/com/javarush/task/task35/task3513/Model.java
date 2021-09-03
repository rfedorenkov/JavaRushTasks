package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс содержит игровую логику и хранит игровое поле.
 */
public class Model {
    // Ширина игрового поля
    private static final int FIELD_WIDTH = 4;
    // Двумерный массив игрового поля состоящий из плиток (Tile)
    private Tile[][] gameTiles;
    // Счет
    protected int score;
    // Максимальный вес плитки
    protected int maxTile;

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
        // Инициализируем счет и максимальный вес плитки
        score = 0;
        maxTile = 0;
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
     * Метод двигает массив влево, если это возможно, то добавляет новую плитку.
     */
    public void left() {
        boolean changes = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile)) {
                changes = true;
            }
        }
        if (changes) {
            addTile();
        }
    }

    /**
     * Метод двигает массив вправо, если это возможно, то добавляет новую плитку.
     */
    public void right() {
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    /**
     * Метод двигает массив вверх, если это возможно, то добавляет новую плитку.
     */
    public void up() {
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    /**
     * Метод двигает массив вниз, если это возможно, то добавляет новую плитку.
     */
    public void down() {
        gameTiles = rotateClockwise(gameTiles);
        left();
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
    }

    /**
     * Метод поворачивает двумерный массив на 90 градусов по часовой стрелке.
     *
     * @param tiles Двумерный массив плиток.
     */
    private Tile[][] rotateClockwise(Tile[][] tiles) {
        Tile[][] result = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                result[i][j] = tiles[FIELD_WIDTH - j - 1][i];
            }
        }
        return result;
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

    /**
     * Метод сжимает массив плиток, таким образом, чтобы все
     * пустые плитки были справа.
     *
     * @param tiles Массив плиток.
     * @return Если были изменения массива - true, иначе false.
     */
    private boolean compressTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = i; j < FIELD_WIDTH; j++) {
                if (tiles[i].isEmpty()) {
                    if (!tiles[j].isEmpty()) {
                        Tile tmp = tiles[j];
                        tiles[j] = tiles[i];
                        tiles[i] = tmp;
                        changes = true;
                    }
                }
            }
        }
        return changes;
    }

    /**
     * Метод слияния плиток в массиве плиток одних номиналов.
     *
     * @param tiles Массив плиток.
     * @return Если были изменения массива - true, иначе false.
     */
    private boolean mergeTiles(Tile[] tiles) {
        boolean changes = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value > 0) {
                if (tiles[i].value == tiles[i + 1].value) {
                    tiles[i].value += tiles[i + 1].value;
                    score += tiles[i].value;
                    if (tiles[i].value > maxTile) {
                        maxTile = tiles[i].value;
                    }
                    tiles[i + 1].value = 0;
                    changes = true;
                }
            }
        }
        compressTiles(tiles);
        return changes;
    }

    public static void main(String[] args) {
        Model model = new Model();
        Tile[][] tiles = new Tile[][]{{new Tile(8), new Tile(0), new Tile(0), new Tile(0)},
                {new Tile(4), new Tile(0), new Tile(0), new Tile(4)},
                {new Tile(0), new Tile(4), new Tile(4), new Tile(0)},
                {new Tile(0), new Tile(2), new Tile(0), new Tile(2)}};
        model.gameTiles = tiles;

        Arrays.stream(model.gameTiles)
                .map(Arrays::toString)
                .forEach(System.out::println);

        System.out.println();

        model.up();

        Arrays.stream(model.gameTiles)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
}

