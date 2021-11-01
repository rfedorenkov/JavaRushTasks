package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс фабрика. Создает и хранит манипуляторы.
 */
public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
        throw new RuntimeException("Illegal Access");
    }

    /**
     * Метод возвращает нужный манипулятор или создает новый, если не был найден.
     *
     * @param currencyCode Код валюты.
     * @return Манипулятор.
     */
    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator manipulator = map.get(currencyCode.toUpperCase());
        if (manipulator == null) {
            manipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, manipulator);
            return manipulator;
        }
        return manipulator;
    }

    /**
     * Метод возвращает коллекцию всех манипуляторов.
     *
     * @return Коллекция манипуляторов.
     */
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
