package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;

    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;

    private List<RoadObject> items = new ArrayList<>();
    private int passedCarsCount = 0;

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    public void draw(Game game) {
        items.forEach(roadObject -> roadObject.draw(game));
    }

    public void move(int boost) {
        items.forEach(roadObject -> roadObject.move(boost + roadObject.speed, items));
        deletePassedItems();
    }

    public boolean checkCrush(PlayerCar player) {
        return items.stream().anyMatch(item -> item.isCollision(player));
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else if (type == RoadObjectType.DRUNK_CAR) {
            return new MovingCar(x, y);
        }
        return new Car(type, x, y);
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type, x, y);
        if (isRoadSpaceFree(roadObject)) {
            items.add(roadObject);
        }
    }

    private boolean isThornExists() {
        return items.stream().anyMatch(roadObject -> roadObject.type == RoadObjectType.THORN);
    }

    private void generateThorn(Game game) {
        if ((game.getRandomNumber(100) < 10) && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    private void deletePassedItems() {
        List<RoadObject> tmp = new ArrayList<>(items);
        for (RoadObject roadObject : tmp) {
            if (roadObject.y >= RacerGame.HEIGHT) {
                items.remove(roadObject);
                if (roadObject.type != RoadObjectType.THORN) {
                    passedCarsCount++;
                }
            }
        }
    }

    private void generateRegularCar(Game game) {
        if (game.getRandomNumber(100) < 30) {
            int carTypeNumber = game.getRandomNumber(4);
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        return items.stream().noneMatch(roadObject -> roadObject.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE));
    }

    private boolean isMovingCarExists() {
        return items.stream().anyMatch(roadObject -> roadObject.type == RoadObjectType.DRUNK_CAR);
    }

    private void generateMovingCar(Game game) {
        if ((game.getRandomNumber(100) < 10) && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR, game);
        }
    }


}



