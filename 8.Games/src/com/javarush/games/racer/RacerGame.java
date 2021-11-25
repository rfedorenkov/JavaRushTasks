package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;

    private static final int RACE_GOAL_CARS_COUNT = 40;

    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private FinishLine finishLine;
    private ProgressBar progressBar;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellColor(x, y, color);
        }
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
        } else if (finishLine.isCrossed(player)) {
            win();
        } else {
            roadManager.generateNewRoadObjects(this);
            if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) {
                finishLine.show();
            }
            moveAll();
        }
        score -=5;
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.LEFT) {
            player.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            player.setDirection(Direction.RIGHT);
        } else if (key == Key.UP) {
            player.speed = 2;
        } else if (key == Key.SPACE && isGameStopped) {
            createGame();
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT || key == Key.RIGHT && player.getDirection() == Direction.RIGHT) {
            player.setDirection(Direction.NONE);
        } else if (key == Key.UP) {
            player.speed = 1;
        }
    }

    private void createGame() {
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        isGameStopped = false;
        score = 3500;
        setTurnTimer(40);
        drawScene();
    }

    private void drawScene() {
        drawField();
        progressBar.draw(this);
        roadMarking.draw(this);
        finishLine.draw(this);
        roadManager.draw(this);
        player.draw(this);

    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (x == CENTER_X) {
                    setCellColor(x, y, Color.WHITE);
                } else if (x >= ROADSIDE_WIDTH && x < WIDTH - ROADSIDE_WIDTH) {
                    setCellColor(x, y, Color.DIMGREY);
                } else {
                    setCellColor(x, y, Color.GREEN);
                }
            }
        }
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
        player.move();

    }

    private void gameOver() {
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.RED, "GAME OVER", Color.BLACK, 20);
        player.stop();
    }

    private void win() {
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.ORANGE, "YOU WIN", Color.BLACK, 20);
    }

}
