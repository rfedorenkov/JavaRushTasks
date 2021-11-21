package com.javarush.games.snake;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static com.javarush.games.snake.SnakeGame.HEIGHT;
import static com.javarush.games.snake.SnakeGame.WIDTH;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private List<GameObject> snakeParts;
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;


    public Snake(int x, int y) {
        this.snakeParts = new ArrayList<>();
        IntStream.range(0, 3).forEach(i -> snakeParts.add(new GameObject(x + i, y)));
    }

    public void setDirection(Direction direction) {
        GameObject head = snakeParts.get(0);
        GameObject part = snakeParts.get(1);

        if ((this.direction == Direction.RIGHT || this.direction == Direction.LEFT) && head.x == part.x) {
            return;
        } else if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && head.y == part.y) {
            return;
        }

        if (this.direction == Direction.LEFT && direction != Direction.RIGHT) {
            this.direction = direction;
        } else if (this.direction == Direction.RIGHT && direction != Direction.LEFT) {
            this.direction = direction;
        } else if (this.direction == Direction.UP && direction != Direction.DOWN) {
            this.direction = direction;
        } else if (this.direction == Direction.DOWN && direction != Direction.UP) {
            this.direction = direction;
        }
    }

    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject snakePart = snakeParts.get(i);
            game.setCellValueEx(snakePart.x, snakePart.y,
                    Color.NONE, i == 0 ? HEAD_SIGN : BODY_SIGN,
                    isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (!checkCollision(newHead) && newHead.x >= 0 && newHead.y >= 0 && newHead.x < HEIGHT && newHead.y < WIDTH) {
            snakeParts.add(0, newHead);
            if (apple.x == newHead.x && apple.y == newHead.y) {
                apple.isAlive = false;
            } else {
                removeTail();
            }
        } else {
            isAlive = false;
        }
    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);
        switch (direction) {
            case UP:
                return new GameObject(head.x, head.y - 1);
            case DOWN:
                return new GameObject(head.x, head.y + 1);
            case LEFT:
                return new GameObject(head.x - 1, head.y);
            case RIGHT:
                return new GameObject(head.x + 1, head.y);
            default:
                throw new UnsupportedOperationException("Direction: " + direction + ", not implemented");
        }
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject head) {
        for (GameObject snakePart : snakeParts) {
            if (head.x == snakePart.x && head.y == snakePart.y) {
                return true;
            }
        }
        return false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}