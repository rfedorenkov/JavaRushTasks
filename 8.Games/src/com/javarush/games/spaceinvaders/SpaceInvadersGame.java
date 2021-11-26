package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;
import com.javarush.games.spaceinvaders.gameobjects.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceInvadersGame extends Game {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;

    private static final int PLAYER_BULLETS_MAX = 1;

    private List<Star> stars;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private EnemyFleet enemyFleet;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) {
            enemyBullets.add(bullet);
        }
        setScore(score);
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE) {
            if (isGameStopped) {
                createGame();
            } else {
                Bullet bullet = playerShip.fire();
                if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                    playerBullets.add(bullet);
                }
            }
        } else if (key == Key.LEFT) {
            playerShip.setDirection(Direction.LEFT);
        } else if (key == Key.RIGHT) {
            playerShip.setDirection(Direction.RIGHT);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key == Key.LEFT && playerShip.getDirection() == Direction.LEFT)
                || (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT)) {
            playerShip.setDirection(Direction.UP);
        }
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT) {
            super.setCellValueEx(x, y, cellColor, value);
        }
    }

    private void createGame() {
        createStars();
        enemyFleet = new EnemyFleet();
        playerShip = new PlayerShip();
        enemyBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        setTurnTimer(40);
        drawScene();
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
        playerShip.draw(this);
        enemyBullets.forEach(bullet -> bullet.draw(this));
        playerBullets.forEach(bullet -> bullet.draw(this));
    }

    private void drawField() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                setCellValueEx(x, y, Color.BLACK, "");
            }
        }
        stars.forEach(star -> star.draw(this));
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int x = getRandomNumber(HEIGHT);
            int y = getRandomNumber(WIDTH);
            stars.add(new Star(x, y));
        }
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        enemyBullets.forEach(Bullet::move);
        playerShip.move();
        playerBullets.forEach(Bullet::move);
    }

    private void removeDeadBullets() {
        enemyBullets.removeIf(bullet -> !bullet.isAlive || bullet.y >= HEIGHT - 1);
        playerBullets.removeIf(bullet -> !bullet.isAlive || bullet.y + bullet.height < 0);
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        removeDeadBullets();
        if (!playerShip.isAlive) {
            stopGameWithDelay();
        }
        if (enemyFleet.getBottomBorder() >= playerShip.y) {
            playerShip.kill();
        }
        if (enemyFleet.getShipsCount() == 0) {
            playerShip.win();
            stopGameWithDelay();
        }
        score += enemyFleet.verifyHit(playerBullets);
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) {
            showMessageDialog(Color.WHITE, "YOU WIN", Color.GREEN, 20);
        } else {
            showMessageDialog(Color.WHITE, "YOU LOSE", Color.RED, 20);
        }
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) {
            stopGame(playerShip.isAlive);
        }
    }
}