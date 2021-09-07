package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    // Стек для хранения предыдущих состояний игрового поля
    private Stack<Tile[][]> previousStates = new Stack<>();
    // Счет для хранения предыдущих счетов
    private Stack<Integer> previousScores = new Stack<>();
    // Можно ли сохранить
    private boolean isSaveNeeded = true;

    /**
     * Конструктор объекта.
     * Создает новое игровое поле.
     */
    public Model() {
        // Инициализируем счет и максимальный вес плитки
        score = 0;
        maxTile = 0;
        // Обновляем игровое поле
        resetGameTiles();
    }


    /**
     * Геттер игрового поля.
     *
     * @return Двумерный массив игрового поля состоящий из плиток (Tile)
     */
    public Tile[][] getGameTiles() {
        return gameTiles;
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
     * Метод проверяет, можно ли с текущей позиции сделать ход так,
     * чтобы состояние игрового поля изменилось.
     *
     * @return Если состояние игрового поля изменилось - true, иначе - false;
     */
    public boolean canMove() {
        // Проверяем есть ли свободные ячейки
        if (getEmptyTiles().size() > 0) {
            // Если есть, возвращаем true
            return true;
        }
        // В цикле проверяем
        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles[i].length - 1; j++) {
                // Есть ли есть одинаковые ячейки по вертикали и горизонтали
                if (gameTiles[i][j].equals(gameTiles[i + 1][j]) || gameTiles[i][j].equals(gameTiles[i][j + 1])) {
                    // Возвращаем true
                    return true;
                }
            }
        }
        // Если проверки не прошли, возвращаем false
        return false;
    }

    /**
     * Метод двигает массив влево, если это возможно, то добавляет новую плитку.
     */
    public void left() {
        // Проверяем, нужно ли сохранение
        if (isSaveNeeded) {
            // Если нужно, то сохраняем игровое поле в стек
            saveState(gameTiles);
        }
        boolean changes = false;
        for (Tile[] gameTile : gameTiles) {
            if (compressTiles(gameTile) | mergeTiles(gameTile)) {
                changes = true;
            }
        }
        if (changes) {
            addTile();
        }
        isSaveNeeded = true;
    }

    /**
     * Метод двигает массив вправо, если это возможно, то добавляет новую плитку.
     */
    public void right() {
        // Сохраняем игровое поле
        saveState(gameTiles);
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
        // Сохраняем игровое поле
        saveState(gameTiles);
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
        // Сохраняем игровое поле
        saveState(gameTiles);
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
        // В цикле проходимся по массиву
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = i; j < FIELD_WIDTH; j++) {
                // Если поле пустое
                if (tiles[i].isEmpty()) {
                    // И соседнее поле не пустое
                    if (!tiles[j].isEmpty()) {
                        // Меняем местами
                        Tile tmp = tiles[j];
                        tiles[j] = tiles[i];
                        tiles[i] = tmp;
                        // Регистрируем изменение
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
        // В цикле проходимся по массиву
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            // Если вес плитки больше 0
            if (tiles[i].value > 0) {
                // И если соседние плитки одинаковы
                if (tiles[i].equals(tiles[i + 1])) {
                    // Суммируем первую плитку
                    tiles[i].value += tiles[i + 1].value;
                    // Увеличиваем счет
                    score += tiles[i].value;
                    // Если вес текущий плитки больше максимального веса
                    if (tiles[i].value > maxTile) {
                        // Обновляем максимальный вес
                        maxTile = tiles[i].value;
                    }
                    // Обнуляем вес соседней плитки
                    tiles[i + 1].value = 0;
                    // Регистрируем изменение
                    changes = true;
                }
            }
        }
        // Сжимаем игровое поле
        compressTiles(tiles);
        return changes;
    }

    /**
     * Метод сохраняет текущее игровое состояние и счет в стеки
     * и устанавливает флаг isSaveNeeded равным false.
     *
     * @param gameTiles Игровое поле
     */
    private void saveState(Tile[][] gameTiles) {
        // Создаем новое игровое поле (двумерный массив)
        Tile[][] savedGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                // Заполняем его новыми объектами
                savedGameTiles[i][j] = new Tile(gameTiles[i][j].value);
            }
        }

        // Добавляем созданное игровое поле в стек
        previousStates.push(savedGameTiles);
        // Добавляем счет в стек
        previousScores.push(score);
        // Устанавливаем флаг
        isSaveNeeded = false;
    }

    /**
     * Метод восстанавливает предыдущее  игровое состояние и счет из стека.
     */
    public void rollback() {
        // Проверяем, что стеки не пусты
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            // Восстанавливаем игровое поле из стека
            gameTiles = previousStates.pop();
            // Восстанавливаем счет из стека
            score = previousScores.pop();
        }
    }

    /**
     * Метод вызывает один из методов движения случайным образом.
     */
    public void randomMove() {
        // Получаем число от 0 до 3
        int n = ((int) (Math.random() * 100)) % 4;
        // Вызываем метод в зависимости от числа
        if (n == 0) {
            left();
        } else if (n == 1) {
            right();
        } else if (n == 2) {
            up();
        } else {
            down();
        }
    }
}