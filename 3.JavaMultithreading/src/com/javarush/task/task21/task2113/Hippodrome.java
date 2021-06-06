package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        horses.forEach(Horse::move);
    }

    public void print() {
        horses.forEach(Horse::print);

        IntStream.range(0, 10).forEach(i -> System.out.println());
    }

    public static void main(String[] args) {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Jack", 3.0, 0));
        horses.add(new Horse("Steve", 3.0, 0));
        horses.add(new Horse("Marlin", 3.0, 0));
        game = new Hippodrome(horses);
        game.run();
    }
}