package com.javarush.task.task26.task2613;

/**
 * Возможные операции для работы с банкоматом.
 */
public enum Operation {
    LOGIN, // авторизация
    INFO, // информация о счёте
    DEPOSIT, // внесение на счёт
    WITHDRAW, // снять со счёта
    EXIT; // завершение работы

    /**
     * Метод возвращает определенный элемент по переданному номеру.
     * В случае некорректных данных бросает IllegalArgumentException.
     *
     * @param i Номер пункта.
     * @return Возвращает операцию.
     */
    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {
        try {
            Operation operation = Operation.values()[i];
            if (operation == Operation.LOGIN) {
                throw new IllegalArgumentException();
            }
            return operation;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}