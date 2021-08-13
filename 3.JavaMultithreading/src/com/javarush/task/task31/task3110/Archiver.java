package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.WrongZipFileException;

/**
 * Класс архиватор.
 * Главный класс, который архивирует и разархивирует архивы.
 */
public class Archiver {

    /**
     * Главный метод, который запускает архиватор.
     */
    public static void main(String[] args) {
        // Создаем цикл, пока не введена команда выхода
        Operation operation = null;
        do {
            try {
                // Запрашиваем операцию
                operation = askOperation();
                // Пробуем выполнить комманду
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                // Если ошибка связана с отсутствием архива
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                // В других случаях
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        } while (operation != Operation.EXIT);
    }

    /**
     * Метод выводит в консоль список доступных команд
     * для выбора одной из них.
     *
     * @return Возвращает выбранную команду.
     */
    public static Operation askOperation() {
        ConsoleHelper.writeMessage("Выберите операцию:");
        // Выводим список всех доступных операций
        for (Operation value : Operation.values()) {
            System.out.println(value.ordinal() + " - " + value.getInfo());
        }

        // Считываем с консоли номер
        int numberOperation = ConsoleHelper.readInt();
        // Проверяем диапазон введенного числа
        try {
            return Operation.values()[numberOperation];
        } catch (ArrayIndexOutOfBoundsException e) {
            ConsoleHelper.writeMessage("Выбран неверный номер. Попробуйте снова.");
            return askOperation();
        }
    }
}