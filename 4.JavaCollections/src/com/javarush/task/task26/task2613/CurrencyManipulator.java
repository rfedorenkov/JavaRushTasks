package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Класс для хранения всей информации по выбранной валюте.
 */
public class CurrencyManipulator {
    // Код валюты, например, USD. Состоит из трех букв.
    private String currencyCode;
    // Map<номинал, количество>.
    private Map<Integer, Integer> denominations;

    /**
     * Конструктор класса.
     *
     * @param currencyCode Код валюты.
     */
    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    /**
     * Геттер кода валюты.
     *
     * @return Код валюты.
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Метод добавляет номинал и количество банкнот.
     *
     * @param denomination Номинал валюты.
     * @param count        Количество банкнот.
     */
    public void addAmount(int denomination, int count) {
        denominations.merge(denomination, count, Integer::sum);
    }

    /**
     * Метод считает общую сумму денег для выбранной валюты.
     *
     * @return Общая сумма денег.
     */
    public int getTotalAmount() {
        return denominations.entrySet().stream()
                .mapToInt(entry -> (entry.getKey() * entry.getValue()))
                .sum();
    }

    /**
     * Метод проверяет, добавлены ли какие-то банкноты.
     *
     * @return true - если добавлены, если нет - false.
     */
    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

    /**
     * Метод проверяет, есть ли данная сумма денег на счету. Если есть возвращает true.
     *
     * @param expectedAmount Сумма денег для снятия.
     * @return Возвращает true, если сумма есть.
     */
    public boolean isAmountAvailable(int expectedAmount) {
        return getTotalAmount() >= expectedAmount;
    }

    /**
     * Метод возвращает номинал и количество банкнот.
     *
     * @param expectedAmount Сумма денег для снятия.
     * @return Map номинал и количество банкнот.
     */
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        Map<Integer, Integer> resultMap = new HashMap<>();
        map.putAll(denominations);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer count = entry.getValue();
            for (int i = 0; i < entry.getValue(); i++) {
                Integer denomination = entry.getKey();
                if (isAmountAvailable(denomination) && denomination <= expectedAmount && count != 0) {
                    expectedAmount -= denomination;
                    resultMap.merge(denomination, 1, Integer::sum);
                    count--;
                }
            }
        }

        if (expectedAmount != 0) {
            throw new NotEnoughMoneyException("There are no banknotes available at the ATM");
        } else {
            for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
                Integer denomination = entry.getKey();
                addAmount(denomination, -entry.getValue());
                if (denominations.get(denomination) == 0) {
                    denominations.remove(denomination);
                }
            }
        }
        return resultMap;
    }
}