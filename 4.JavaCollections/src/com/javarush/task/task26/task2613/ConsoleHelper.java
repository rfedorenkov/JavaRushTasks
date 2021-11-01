package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Вспомогательный класс, для чтения или записи в консоль.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
        throw new RuntimeException("Illegal Access");
    }

    /**
     * Метод принимает сообщение и выводит его на консоль.
     *
     * @param message Сообщение.
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Метод считывает с консоли строку и возвращает ее.
     *
     * @return Считанную строку с консоли.
     */
    public static String readString() throws InterruptOperationException {
        try {
            String answer = bis.readLine();
            if (answer.equalsIgnoreCase("EXIT")) {
                throw new InterruptOperationException();
            }
            return answer;
        } catch (IOException ignored) {
            return "";
        }
    }

    /**
     * Метод предлагает пользователю ввести код валюты.
     * Код должен содержать 3 символа.
     *
     * @return Возвращает код в верхнем регистре.
     */
    public static String askCurrencyCode() throws InterruptOperationException {
        while (true) {
            writeMessage("Enter currency code:");
            String currencyCode = readString();

            if (currencyCode.length() == 3) {
                return currencyCode.toUpperCase();
            }
            writeMessage(res.getString("choose.currency.code"));
        }
    }

    /**
     * Метод предлагает пользователю ввести два целых положительных числа.
     * Первое число - номинал.
     * Второе число - количество банкнот.
     *
     * @param currencyCode Код валюты.
     * @return Возвращает массив из двух чисел.
     */
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            try {
                writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
                String[] split = readString().split(" ");
                if (split.length == 2) {
                    int denomination = Integer.parseInt(split[0]);
                    int count = Integer.parseInt(split[1]);
                    if (denomination > 0 && count > 0) {
                        return split;
                    }
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("The entered numbers is incorrect. Try again.");
            }
        }
    }

    /**
     * Метод предлагает пользователю номер доступной операции.
     *
     * @return Возвращает выбранную операцию.
     */
    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            writeMessage(res.getString("choose.operation"));
            writeMessage("1: - " + res.getString("operation.INFO"));
            writeMessage("2: - " + res.getString("operation.DEPOSIT"));
            writeMessage("3: - " + res.getString("operation.WITHDRAW"));
            writeMessage("4: - " + res.getString("operation.EXIT"));
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (IllegalArgumentException ignored) {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        writeMessage(res.getString("the.end"));
    }
}