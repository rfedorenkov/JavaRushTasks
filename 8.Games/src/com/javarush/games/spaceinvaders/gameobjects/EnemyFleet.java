package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;

    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int y = 0; y < ROWS_COUNT; y++) {
            for (int x = 0; x < COLUMNS_COUNT; x++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
        double x = STEP * COLUMNS_COUNT / 2.0 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2.0 - 1;
        double y = 5;
        ships.add(new Boss(x, y));
    }
    
    public void draw(Game game) {
        ships.forEach(enemyShip -> enemyShip.draw(game));
    }

    public void move() {
        if (!ships.isEmpty()) {
            if (direction == Direction.LEFT && getLeftBorder() < 0) {
                direction = Direction.RIGHT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            } else if (direction == Direction.RIGHT && getRightBorder() > SpaceInvadersGame.WIDTH) {
                direction = Direction.LEFT;
                ships.forEach(enemyShip -> enemyShip.move(Direction.DOWN, getSpeed()));
            } else {
                ships.forEach(enemyShip -> enemyShip.move(direction, getSpeed()));
            }
        }
    }

    private double getLeftBorder() {
        return ships.stream().mapToDouble(ship -> ship.x).min().orElse(0);
    }

    private double getRightBorder() {
        return ships.stream().mapToDouble(ship -> ship.x + ship.width).max().orElse(0);
    }

    private double getSpeed() {
        return Math.min(2.0, 3.0 / ships.size());
    }

    public Bullet fire(Game game) {
        if (ships.isEmpty()) {
            return null;
        }

        int randomNumber = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (randomNumber > 0) {
            return null;
        }

        int randomIndex = game.getRandomNumber(ships.size());
        return ships.get(randomIndex).fire();
    }

    public int verifyHit(List<Bullet> bullets) {
        int score = 0;
        if (bullets.isEmpty()) {
            return score;
        }
        for (EnemyShip ship : ships) {
            for (Bullet bullet : bullets) {
                if (ship.isCollision(bullet) && ship.isAlive && bullet.isAlive) {
                    score += ship.score;
                    ship.kill();
                    bullet.kill();
                }
            }
        }
        return score;
    }

    public void deleteHiddenShips() {
        ships.removeIf(enemyShip -> !enemyShip.isVisible());
    }

    public double getBottomBorder() {
        return ships.stream().mapToDouble(enemyShip -> enemyShip.y + enemyShip.height).max().orElse(0);
    }

    public int getShipsCount() {
        return ships.size();
    }
}