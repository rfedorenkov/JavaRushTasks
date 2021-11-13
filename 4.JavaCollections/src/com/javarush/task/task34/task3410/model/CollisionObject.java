package com.javarush.task.task34.task3410.model;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public abstract class CollisionObject extends GameObject {

    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int x = this.getX();
        int y = this.getY();
        if (direction == Direction.UP) {
            y -= FIELD_CELL_SIZE;
        } else if (direction == Direction.DOWN) {
            y += FIELD_CELL_SIZE;
        } else if (direction == Direction.LEFT) {
            x -= FIELD_CELL_SIZE;
        } else if (direction == Direction.RIGHT) {
            x += FIELD_CELL_SIZE;
        }
        return gameObject.getX() == x && gameObject.getY() == y;
    }
}
