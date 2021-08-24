package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Класс менеджера статистики.
 * Отвечает за регистрацию событий в хранилище.
 * Класс является Singleton, поскольку относится ко всему ресторану.
 */
public enum StatisticManager {
    INSTANCE;

    // Хранилище статистики
    private StatisticStorage statisticStorage = new StatisticStorage();

    // Список поваров
    private Set<Cook> cooks = new HashSet<>();

    // Формат даты
    SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    /**
     * Метод возвращает менеджера статистики.
     *
     * @return Менеджер статистики.
     */
    public static StatisticManager getInstance() {
        return INSTANCE;
    }

    /**
     * Метод возвращает хранилище статистики.
     *
     * @return Хранилище статистики.
     */
    public StatisticStorage getStatisticStorage() {
        return statisticStorage;
    }

    /**
     * Метод регистрирует событие в хранилище
     *
     * @param data Событие.
     */
    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    /**
     * Метод регистрирует повара (добавляет в Set)
     *
     * @param cook Повар.
     */
    public void register(Cook cook) {
        cooks.add(cook);
    }


    /**
     * Метод достает из хранилища все данные относящиеся к отображению рекламы.
     * Подсчитывает общую прибыль за каждый день.
     *
     * @return Map с полученными значениями.
     */
    public Map<String, Double> getAdvertisementProfitMap() {
        // Создаем TreeMap
        Map<String, Double> advertisementProfitMap = new TreeMap<>();

        // Получаем список связанный с показом рекламы
        List<EventDataRow> selectedVideos = statisticStorage.getStorage(EventType.SELECTED_VIDEOS);

        // Общая прибыль полученная за все рекламные ролики
        double total = 0.0;

        // Проходимся по списку
        for (EventDataRow dataRow : selectedVideos) {
            // Приводим к классу VideoSelectedEventDataRow
            VideoSelectedEventDataRow video = (VideoSelectedEventDataRow) dataRow;
            // Получяем прибыль от рекламного ролика
            double price = video.getAmount() / 100.0;
            total += price;
            // Получаем дату
            String date = format.format(video.getDate());
            // Добавляем результат, если присутствует, то складываем
            advertisementProfitMap.merge(date, price, Double::sum);
        }

        // Добавляем общую прибыль
        advertisementProfitMap.put("Total", total);
        // Возвращаем результат
        return advertisementProfitMap;
    }

    /**
     * Метод собирает статистику по загрузке (рабочее время) повара.
     * Сгруппировывает по дням.
     */
    public Map<String, Map<String, Integer>> getCookWorkLoadingMap() {
        // Создаем TreeMap
        Map<String, Map<String, Integer>> cookWorkLoadingMap = new TreeMap<>();

        // Получаем список связанный приготовлением заказов
        List<EventDataRow> cookedOrders = statisticStorage.getStorage(EventType.COOKED_ORDER);

        // Проходимся по списку
        for (EventDataRow dataRow : cookedOrders) {
            // Приводим к классу CookedOrderEventDataRow
            CookedOrderEventDataRow cookedOrder = (CookedOrderEventDataRow) dataRow;

            // Получаем дату
            String date = format.format(cookedOrder.getDate());

            // Имя повара
            String cookName = cookedOrder.getCookName();
            // Время приготовления заказа (в минутах)
            int cookingTime = cookedOrder.getTime() / 60;

            // Если с такой датой значения не найдено
            if (!cookWorkLoadingMap.containsKey(date)) {
                // Создаем новое значение с этой датой
                cookWorkLoadingMap.put(date, new TreeMap<>());
            }

            // Создаем TreeMap со списком поваров и времени приготовления
            Map<String, Integer> cooksMaps = cookWorkLoadingMap.get(date);
            // Складываем время, если значение повторяется
            cooksMaps.merge(cookName, cookingTime, Integer::sum);
        }

        // Возвращаем результат
        return cookWorkLoadingMap;
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

        /**
         * Метод возвращает список по типу события.
         *
         * @param type Тип события.
         * @return Список по типу события.
         */
        private List<EventDataRow> getStorage(EventType type) {
            return statisticStorage.storage.get(type);
        }
    }
}

