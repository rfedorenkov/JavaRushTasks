package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс менеджера статистики.
 * Отвечает за регистрацию событий в хранилище.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticManager {
    INSTANCE;

    // Хранилище статистики
    private StatisticStorage statisticStorage = new StatisticStorage();

    /**
     * Метод возвращает менеджера статистики.
     *
     * @return Менеджер статистики.
     */
    public static StatisticManager getInstance() {
        return INSTANCE;
    }

    // подсчет статистики

    // отображение статистики директору

    /**
     * Метод регистрирует событие в хранилище
     *
     * @param data Событие.
     */
    public void register(EventDataRow data) {
        statisticStorage.put(data);
//Теперь остается расставить вызовы StatisticManager в те места, которые генерируют события.


//
//4. Зарегистрируй событие для повара во время приготовления еды.

//Добавь геттер для поля dishes в класс Order, используй его при создании события.
//
//5. Зарегистрируй событие "видео выбрано" перед отображением рекламы пользователю.
//
//6. Метод register с одним параметром типа EventDataRow должен регистрировать полученное событие в statisticStorage.
//
//
//Requirements:
//1. В интерфейсе EventDataRow должен быть объявлен метод EventType getType().
//2. В классах поддерживающих интерфейс EventDataRow должен быть корректно реализован метод getType().
//3. Метод put в классе StatisticStorage должен быть реализован в соответствии с условием задачи.
//4. Метод register класса StatisticManager с одним параметром типа EventDataRow должен регистрировать
// полученное событие в statisticStorage.
//5. Повар во время приготовления еды должен генерировать соответствующее событие.
//6. Перед отображением списка видео должно быть зарегистрировано событие "видео выбрано".

    }

    /**
     * Внутренний приватный класс, который отвечает
     * за хранение статистики.
     */
    private class StatisticStorage {
        // Хранилище
        private Map<EventType, List<EventDataRow>> storage;

        /**
         * Конструктор класса.
         * Инициализирует Map storage и заполняет данными.
         */
        private StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }
        }

        /**
         * Метод добавляет в данные в хранилище.
         *
         * @param data Данные.
         */
        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }
    }
}



