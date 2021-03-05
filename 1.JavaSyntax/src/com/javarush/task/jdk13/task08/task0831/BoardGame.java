package com.javarush.task.jdk13.task08.task0831;

public class BoardGame {

    String name;

    public BoardGame() {
    }

    public BoardGame(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
