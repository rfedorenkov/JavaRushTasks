package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Вспомогательный класс, для чтения или записи в консоль.
 */
public class ConsoleHelper {
    private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
        throw new RuntimeException("Object cannot be created.");
    }

    /**
     * Метод выводит сообщение в консоль.
     *
     * @param message Сообщение, которое нужно вывести в консоль.
     */
    public static <T> void writeMessage(T message) {
        System.out.println(message);
    }

    /**
     * Метод для чтения строки с консоли.
     *
     * @return Возвращает считанную с консоли строку.
     */
    public static String readString() throws IOException {
        return console.readLine();
    }

    /**
     * Метод просит пользователя выбрать блюдо и добавляет его в список.
     *
     * @return Возвращает список выбранных блюд.
     */
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Выберите блюдо из списка, которое желаете заказать: (для завершения введите 'exit')");
        writeMessage(Dish.allDishesToString());
        while (true) {
            String order = readString().toUpperCase();
            if (order.equalsIgnoreCase("exit")) {
                writeMessage("Оформление заказа завершено.");
                break;
            }

            try {
                dishes.add(Dish.valueOf(order));
            } catch (IllegalArgumentException e) {
                writeMessage(String.format("%s блюда нет.", order));
            }

        }
        return dishes;
    }
}