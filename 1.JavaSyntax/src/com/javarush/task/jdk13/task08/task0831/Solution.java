package com.javarush.task.jdk13.task08.task0831;

import java.util.Arrays;

/**
 * Любимые настолки
 * Составь собственный ТОП-10 любимых настольных игр.
 *
 * Требования:
 * 1. В методе main нужно заполнить массив collection объектами BoardGame.
 * 2. У каждого объекта BoardGame должно быть уникальное имя (поле name).
*/

public class Solution {

    public static BoardGame[] collection = new BoardGame[10];

    public static void main(String[] args) {
        collection[0] = new BoardGame("Шахматы");
        collection[1] = new BoardGame("Карты");
        collection[2] = new BoardGame("Шашки");
        collection[3] = new BoardGame("Монополия");
        collection[4] = new BoardGame("Нарды");
        collection[5] = new BoardGame("Морской Бой");
        collection[6] = new BoardGame("UNO");
        collection[7] = new BoardGame("Крестики нолики");
        collection[8] = new BoardGame("Змеи и лестницы");
        collection[9] = new BoardGame("Дженга");

        System.out.println(Arrays.toString(collection));
    }
}