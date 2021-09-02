package com.javarush.task.task35.task3513;

import java.awt.*;

/**
 * Класс плитки.
 * Цвета плиток находятся в диапазоне от светло-серого до красного,
 * а цвет текста зависит от цвета плитки.
 */
public class Tile {
    // Вес плитки
    int value;

    /**
     * Конструктор объекта плитки.
     * Уровень доступа равен 0.
     */
    public Tile() {
        this(0);
    }

    /**
     * Конструктор объекта плитки.
     *
     * @param value уровень доступа.
     */
    public Tile(int value) {
        this.value = value;
    }

    /**
     * Метод проверяет пустая ли плитка.
     *
     * @return true если значение поле value равно 0, иначе - false.
     */
    public boolean isEmpty() {
        return value == 0;
    }

    /**
     * Метод возвращает цвет шрифта. Новый цвет 0x776e65 в случае,
     * вес плитки меньше 16, иначе 0xf9f6f2.
     *
     * @return Цвет шрифта.
     */
    public Color getFontColor() {
        return value < 16 ? new Color(0x776e65) : new Color(0xf9f6f2);
    }

    /**
     * Метод возвращает цвет плитки в зависимости от ее веса.
     *
     * @return Цвет плитки.
     */
    public Color getTileColor() {
        switch (value) {
            case 0:
                return new Color(0xcdc1b4);
            case 2:
                return new Color(0xeee4da);
            case 4:
                return new Color(0xede0c8);
            case 8:
                return new Color(0xf2b179);
            case 16:
                return new Color(0xf59563);
            case 32:
                return new Color(0xf67c5f);
            case 64:
                return new Color(0xf65e3b);
            case 128:
                return new Color(0xedcf72);
            case 256:
                return new Color(0xedcc61);
            case 512:
                return new Color(0xedc850);
            case 1024:
                return new Color(0xedc53f);
            case 2048:
                return new Color(0xedc22e);
            default:
                return new Color(0xff0000);

        }
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}