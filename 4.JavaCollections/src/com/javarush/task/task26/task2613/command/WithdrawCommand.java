package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Класс команды снятия со счёта.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    /**
     * Метод спрашивает в какой валюте снять деньги и в каком количестве.
     * Если данная сумма есть на счету и банкомат может её выдать, то данная сумма списывается
     * со счёта и выдается пользователю.
     */
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            try {
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount <= 0) {
                    throw new NumberFormatException();
                }
                if (manipulator.isAmountAvailable(amount)) {
                    Map<Integer, Integer> denominations = new TreeMap<>(Comparator.reverseOrder());
                    denominations.putAll(manipulator.withdrawAmount(amount));
                    for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
                        ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
                    }
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                    break;
                } else {
                    ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                }
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
            }
        }
    }
}