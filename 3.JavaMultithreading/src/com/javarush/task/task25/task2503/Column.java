package com.javarush.task.task25.task2503;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        realOrder = new int[values().length];
        for (Column column : values()) {
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        for (int i = 0; i < realOrder.length; i++) {
            Column value = Column.values()[i];
            if (value.isShown()) {
                result.add(value);
            }
        }
//        result.sort(Comparator.reverseOrder());
        result.sort((o1, o2) -> realOrder[o1.ordinal()] >= realOrder[o2.ordinal()] ? 1 : -1);
        return result;
    }

    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
        return columnName;
    }

    /**
     * @return возвращает true, если колонка видима, иначе false
     */
    @Override
    public boolean isShown() {
        return realOrder[ordinal()] != -1;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Свдигает индексы отображаемых колонок, которые идут после скрытой.
     */
    @Override
    public void hide() {
        int index = realOrder[ordinal()];
        if (index == -1) {
            return;
        }
        realOrder[ordinal()] = -1;
        for (int i = 0; i < realOrder.length; i++) {
            int currentIndex = realOrder[i];
            if (currentIndex != -1 && currentIndex > index) {
                realOrder[i] -= 1;
            }
        }
    }
}