package com.javarush.task.task25.task2502;

import java.util.*;

/**
 * Машину на СТО не повезем!
 * Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
 * Выкинь исключение в случае некорректных данных.
 *
 * Подсказка: если что-то не то с колесами, то это не машина!
 * Сигнатуры не менять.
 *
 *
 * Requirements:
 * 1. Enum Wheel в классе Solution менять нельзя.
 * 2. Сигнатуры в классе Car менять нельзя.
 * 3. Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
 * 4. В случае возврата неправильных данных о колесах, нужно кинуть исключение.
 * 5. Инициализируй поле wheels полученными данными.
*/

public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            String[] wheelNamesFromDB = loadWheelNamesFromDB();
            if (wheelNamesFromDB.length != 4) {
                throw new IllegalArgumentException();
            }
            wheels = new ArrayList<>();
            for (String wheel : wheelNamesFromDB) {
                wheels.add(Wheel.valueOf(wheel));
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {

    }
}
