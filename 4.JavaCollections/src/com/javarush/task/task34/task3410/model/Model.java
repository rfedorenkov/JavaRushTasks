package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;

import java.nio.file.Paths;
import java.util.Set;

public class Model {
    public static final int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("./4.JavaCollections/src/com/javarush/task/task34/task3410/res/levels.txt"));


    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }

    public void restartLevel(int level) {
        gameObjects = levelLoader.getLevel(level);
    }

    public void restart() {
        restartLevel(currentLevel);
    }

    public void startNextLevel() {
        restartLevel(++currentLevel);
    }

    public void move(Direction direction) {
        Player player = gameObjects.getPlayer();
        if (checkWallCollision(player, direction)) {
            return;
        }
        if (checkBoxCollisionAndMoveIfAvailable(direction)) {
            return;
        }

        int x = getXForDirection(direction);
        int y = getYForDirection(direction);
        player.move(x, y);
        checkCompletion();
    }

    public boolean checkWallCollision(CollisionObject gameObject, Direction direction) {
        return gameObjects.getWalls().stream().anyMatch(wall -> gameObject.isCollision(wall, direction));
    }

    public boolean checkBoxesCollision(CollisionObject gameObject, Direction direction) {
        return gameObjects.getBoxes().stream().anyMatch(box -> gameObject.isCollision(box, direction));
    }

    public boolean checkBoxCollisionAndMoveIfAvailable(Direction direction) {
        Player player = gameObjects.getPlayer();

        int x = getXForDirection(direction);
        int y = getYForDirection(direction);
        for (Box box : gameObjects.getBoxes()) {
            if (player.isCollision(box, direction)) {
                if (!checkWallCollision(box, direction) && !checkBoxesCollision(box, direction)) {
                    box.move(x, y);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkCompletion() {
        Set<Box> boxes = gameObjects.getBoxes();
        Set<Home> homes = gameObjects.getHomes();
        int count = homes.size();
        for (Home home : homes) {
            for (Box box : boxes) {
                if (home.getX() == box.getX() && home.getY() == box.getY()) {
                    count--;
                }
            }
        }
        if (count == 0) {
            eventListener.levelCompleted(currentLevel);
        }
    }

    private int getXForDirection(Direction direction) {
        return (direction == Direction.LEFT) ? -FIELD_CELL_SIZE : (direction == Direction.RIGHT) ? FIELD_CELL_SIZE : 0;
    }

    private int getYForDirection(Direction direction) {
        return (direction == Direction.UP) ? -FIELD_CELL_SIZE : (direction == Direction.DOWN) ? FIELD_CELL_SIZE : 0;
    }
}