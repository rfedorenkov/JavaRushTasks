package com.javarush.task.task13.task1310;

/**
 * Будущий управленец
 * Добавь интерфейсы Secretary и Boss к классам Manager и Subordinate. По одному на каждый. Подумай, кому какой.
 * Унаследуй интерфейсы Secretary и Boss от интерфейсов Person и HasManagementPotential так,
 * чтобы все методы у классов Manager и Subordinate были объявлены в каком-то интерфейсе.
 *
 *
 * Требования:
 * 1. Класс Manager должен реализовывать подходящий ему интерфейс (Secretary или Boss).
 * 2. Класс Subordinate должен реализовывать подходящий ему интерфейс (Secretary или Boss).
 * 3. Секретарь (Secretary) является человеком (Person).
 * 4. Начальник (Boss) является человеком (Person), который может заставить других
 * усердно работать (HasManagementPotential).
*/

public class Solution {
    public static void main(String[] args) {
    }

    interface Person {
        void use(Person person);

        void startToWork();
    }

    interface HasManagementPotential {
        boolean inspiresOthersToWork();
    }

    interface Secretary extends Person {
    }

    interface Boss extends Person, HasManagementPotential {
    }

    class Manager implements Boss {
        @Override
        public void use(Person person) {
            person.startToWork();
        }

        @Override
        public void startToWork() {
        }

        @Override
        public boolean inspiresOthersToWork() {
            return true;
        }
    }

    class Subordinate implements Secretary {
        @Override
        public void use(Person person) {
        }

        @Override
        public void startToWork() {
        }
    }
}
