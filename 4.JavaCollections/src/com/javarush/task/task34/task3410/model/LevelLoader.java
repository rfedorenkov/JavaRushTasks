package com.javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level) {
        int x = Model.FIELD_CELL_SIZE / 2;
        int y = Model.FIELD_CELL_SIZE / 2;
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(x, y));
        walls.add(new Wall(x, y));
        Set<Home> homes = Collections.singleton(new Home(x, y));
        Set<Box> boxes = Collections.singleton(new Box(x, y));
        return new GameObjects(walls, boxes, homes,new Player(x, y));
    }
}