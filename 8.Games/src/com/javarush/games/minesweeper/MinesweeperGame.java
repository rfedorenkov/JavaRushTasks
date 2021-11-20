package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        restart();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
            return;
        }
        while (score == 0 && gameField[y][x].isMine) {
            restart();
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                GameObject gameObject = gameField[y][x];
                if (!gameObject.isMine) {
                    gameObject.countMineNeighbors = (int) getNeighbors(gameObject).stream()
                            .filter(neighbor -> neighbor.isMine)
                            .count();
                }
            }
        }
    }

    private void openTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (gameObject.isOpen || gameObject.isFlag || isGameStopped) {
            return;
        }
        gameObject.isOpen = true;
        countClosedTiles--;

        if (gameObject.isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            if (countClosedTiles == countMinesOnField) {
                win();
            }
            score += 5;
            setScore(score);
            if (gameObject.countMineNeighbors == 0) {
                getNeighbors(gameObject).stream()
                        .filter(neighbor -> !neighbor.isOpen)
                        .forEach(neighbor -> openTile(neighbor.x, neighbor.y));
                setCellValue(x, y, "");
            } else {
                setCellNumber(x, y, gameObject.countMineNeighbors);
            }
        }
        setCellColor(x, y, Color.GREEN);
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];
        if (!isGameStopped && !gameObject.isOpen) {
            if (countFlags != 0 || gameObject.isFlag) {
                if (gameObject.isFlag) {
                    gameObject.isFlag = false;
                    countFlags++;
                    setCellValue(x, y, "");
                    setCellColor(x, y, Color.ORANGE);
                } else {
                    gameObject.isFlag = true;
                    countFlags--;
                    setCellValue(x, y, FLAG);
                    setCellColor(x, y, Color.YELLOW);
                }
            }
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "YOU LOSE", Color.BLACK, 20);
        showAllMines();
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "YOU WIN", Color.BLACK, 20);
    }

    private void restart() {
        countMinesOnField = 0;
        isGameStopped = false;
        score = 0;
        setScore(score);
        countClosedTiles = SIDE * SIDE;
        createGame();
    }

    private void showAllMines() {
        for (GameObject[] gameObjects : gameField) {
            for (GameObject gameObject : gameObjects) {
                if (gameObject.isMine) {
                    setCellValueEx(gameObject.x, gameObject.y, Color.RED, MINE);
                }
            }
        }
    }
}