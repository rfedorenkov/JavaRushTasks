package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

import static com.javarush.games.spaceinvaders.ShapeMatrix.*;

public class PlayerShip extends Ship {
    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);
    }

    private Direction direction = Direction.UP;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if (newDirection != Direction.DOWN) {
            this.direction = newDirection;
        }
    }

    public void verifyHit(List<Bullet> bullets) {
        if (!bullets.isEmpty() && isAlive) {
            bullets.stream().filter(bullet -> bullet.isAlive && isCollision(bullet)).forEach(bullet -> {
                kill();
                bullet.kill();
            });
        }
    }

    @Override
    public void kill() {
        if (isAlive) {
            isAlive = false;
            setAnimatedView(false, KILL_PLAYER_ANIMATION_FIRST, KILL_PLAYER_ANIMATION_SECOND, KILL_PLAYER_ANIMATION_THIRD, DEAD_PLAYER);
        }
    }

    @Override
    public Bullet fire() {
        if (isAlive) {
            return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
        }
        return null;
    }

    public void move() {
        if (isAlive) {
            if (direction == Direction.LEFT) {
                x--;

            } else if (direction == Direction.RIGHT) {
                x++;
            }
            if (x < 0) {
                x = 0;
            } else if (x + width > SpaceInvadersGame.WIDTH) {
                x = SpaceInvadersGame.WIDTH - width;
            }
        }
    }

    public void win() {
        setStaticView(WIN_PLAYER);
    }
}
