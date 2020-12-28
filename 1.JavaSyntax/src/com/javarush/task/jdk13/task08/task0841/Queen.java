package com.javarush.task.jdk13.task08.task0841;

/**
 * Муравейник
 * В нашем муравейнике есть три класса муравьёв: королева (Queen), воин (Warrior) и рабочий муравей (Worker).
 * Королева – одна на весь муравейник. В ее методе populate создаются десятки воинов и сотни рабочих муравьёв.
 * Добавь код в метод main:
 * - всех рабочихих муравьев из массива workers отправь за едой (метод sendForFood);
 * - всех муравьев воинов из массива warriors отправь в бой (метод sendToBattle).
 *
 *
 * Требования:
 * 1. Метод main должен заселить муравейник вызвав метод populate ласса Queen.
 * 2. Метод main должен вызывать метод sendForFood у каждого из муравьев в массиве workers.
 * 3. Метод main должен вызывать метод sendToBattle у каждого из муравьев в массиве warriors.
 */
public class Queen {
    public static Worker[] workers;
    public static Warrior[] warriors;

    public static void main(String[] args) {
        populate();

        for (Worker worker : workers) {
            worker.sendForFood();
        }

        for (Warrior warrior : warriors) {
            warrior.sendToBattle();
        }
    }

    public static void populate() {
        workers = new Worker[800];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker();
        }

        warriors = new Warrior[70];
        for (int i = 0; i < warriors.length; i++) {
            warriors[i] = new Warrior();
        }
    }
}
