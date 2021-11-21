package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;

    private int[][] gameField;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                createGame();
                drawScene();
            }
            return;
        }

        if (canUserMove()) {
            if (key == Key.LEFT) {
                moveLeft();
                drawScene();
            } else if (key == Key.RIGHT) {
                moveRight();
                drawScene();
            } else if (key == Key.UP) {
                moveUp();
                drawScene();
            } else if (key == Key.DOWN) {
                moveDown();
                drawScene();
            }
        } else {
            gameOver();
        }

    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        isGameStopped = false;
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void drawScene() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private void createNewNumber() {
        if (getMaxTileValue() == 2048) {
            win();
        }
        do {
            int x = getRandomNumber(SIDE);
            int y = getRandomNumber(SIDE);

            if (gameField[x][y] == 0) {
                gameField[x][y] = getRandomNumber(10) == 9 ? 4 : 2;
                break;
            }
        } while (true);
    }

    private void setCellColoredNumber(int x, int y, int value) {
        Color color = getColorByValue(value);
        String text = value == 0 ? "" : String.valueOf(value);
        setCellValueEx(x, y, color, text);
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2:
                return Color.TOMATO;
            case 4:
                return Color.AQUA;
            case 8:
                return Color.PAPAYAWHIP;
            case 16:
                return Color.LINEN;
            case 32:
                return Color.DODGERBLUE;
            case 64:
                return Color.ORANGERED;
            case 128:
                return Color.CORNFLOWERBLUE;
            case 256:
                return Color.CRIMSON;
            case 512:
                return Color.TURQUOISE;
            case 1024:
                return Color.DIMGRAY;
            case 2048:
                return Color.GOLD;
            default:
                return Color.KHAKI;
        }
    }

    private boolean compressRow(int[] row) {
        boolean compress = false;
        for (int i = 0; i < row.length - 1; i++) {
            for (int j = i + 1; j < row.length; j++) {
                if (row[i] == 0 && row[j] != 0) {
                    int tmp = row[i];
                    row[i] = row[j];
                    row[j] = tmp;
                    compress = true;
                }
            }
        }
        return compress;
    }

    private boolean mergeRow(int[] row) {
        boolean merge = false;
        for (int i = 0; i < row.length - 1; i++) {
            if (row[i] != 0 && row[i] == row[i + 1]) {
                row[i] += row[i + 1];
                row[i + 1] = 0;
                merge = true;
                score += row[i];
                setScore(score);
            }
        }
        return merge;
    }

    private void moveLeft() {
        boolean change = false;
        for (int[] row : gameField) {
            if (compressRow(row) | mergeRow(row) | compressRow(row)) {
                change = true;
            }
        }

        if (change) {
            createNewNumber();
        }
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] tmpArray = new int[SIDE][SIDE];
        for (int i = 0; i < gameField.length; i++) {
            for (int j = 0; j < gameField[i].length; j++) {
                tmpArray[j][gameField.length - i - 1] = gameField[i][j];
            }
        }
        gameField = tmpArray;
    }

    private int getMaxTileValue() {
        int max = 0;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (max < gameField[i][j]) {
                    max = gameField[i][j];
                }
            }
        }
        return max;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.ORANGE, "YOU WIN", Color.BLACK, 20);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "YOU LOSE", Color.BLACK, 20);
    }

    private boolean canUserMove() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (gameField[i][j] == 0) {
                    return true;
                } else {
                    if (i < SIDE - 1 && gameField[i][j] == gameField[i + 1][j]) {
                        return true;
                    } else if (j < SIDE - 1 && gameField[i][j] == gameField[i][j + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

