package com.javarush.task.task34.task3410.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.javarush.task.task34.task3410.model.Model.FIELD_CELL_SIZE;

public class LevelLoader {
    private Path levels;
    private List<String> strings;

    public LevelLoader(Path levels) {
        this.levels = levels;
        try {
            strings = Files.readAllLines(levels);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameObjects getLevel(int level) {
        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = new Player(0, 0);
        int lvl = level > 60 ? level % 60 : level;

        int y = FIELD_CELL_SIZE / 2;

        boolean startLvl = false;
        int readLvl = 0;
        for (String s : strings) {
            int x = FIELD_CELL_SIZE / 2;
            if (s.contains("Maze:")) {
                readLvl = Integer.parseInt(s.split(" ")[1]);
            }
            if (readLvl == lvl) {
                if (s.isEmpty() && startLvl) {
                    break;
                }
                if (startLvl) {
                    for (char c : s.toCharArray()) {
                        if (c == 'X') {
                            walls.add(new Wall(x, y));
                        } else if (c == '*') {
                            boxes.add(new Box(x, y));
                        } else if (c == '.') {
                            homes.add(new Home(x, y));
                        } else if (c == '@') {
                            player.setX(x);
                            player.setY(y);
                        } else if (c == '&') {
                            boxes.add(new Box(x, y));
                            homes.add(new Home(x, y));
                        }
                        x += FIELD_CELL_SIZE;
                    }
                    y += FIELD_CELL_SIZE;
                }
                if (s.isEmpty()) {
                    startLvl = true;
                }
            }
        }
        return new GameObjects(walls, boxes, homes, player);
    }
}