package com.javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс космоса в котором происходит сражение космического корабля и НЛО
 * Главный класс.
 */
public class Space {
    public static Space game;

    // Ширины
    private int width;
    // Высота
    private int height;
    // Космический корабль
    private SpaceShip ship;

    // Список для хранения всех НЛО
    private List<Ufo> ufos = new ArrayList<>();
    // Список для хранения всех ракет
    private List<Rocket> rockets = new ArrayList<>();
    // Список для хранения всех бомб
    private List<Bomb> bombs = new ArrayList<>();

    /**
     * Конструктор класса.
     *
     * @param width Ширина.
     * @param height Высота.
     */
    public Space(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Геттер поля ширина.
     * @return width.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Геттер поля высота.
     * @return height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Сеттер поля космический корабль.
     * @param ship Космический корабль.
     */
    public void setShip(SpaceShip ship) {
        this.ship = ship;
    }

    /**
     * Геттер поля космический корабль.
     * @return ship.
     */
    public SpaceShip getShip() {
        return ship;
    }

    /**
     * Геттер списка НЛО.
     * @return ufos.
     */
    public List<Ufo> getUfos() {
        return ufos;
    }

    /**
     * Геттер списка ракет.
     * @return rockets.
     */
    public List<Rocket> getRockets() {
        return rockets;
    }

    /**
     * Геттер списка бомб.
     * @return bombs.
     */
    public List<Bomb> getBombs() {
        return bombs;
    }

    /**
     * Метод управляет логикой игры.
     */
    public void run() {

    }

    /**
     * Метод отвечает за отображение.
     */
    public void draw() {

    }

    /**
     * Метод засыпает на несколько миллисекунд принятых в параметре.
     *
     * @param ms Миллисекунды.
     */
    public void sleep(int ms) {

    }

    /**
     * Главный метод, запускает игру Space.
     */
    public static void main(String[] args) {

    }
}