package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Класс верификации кредитной карты пользователя.
 */
class LoginCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");

    /**
     * Метод проходит авторизацию пользователя по номеру карты и пин-кода.
     */
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNumber = ConsoleHelper.readString();
            String cardPin = ConsoleHelper.readString();
            if (cardNumber.length() == 12 && cardPin.length() == 4) {
                if (validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(cardPin)) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNumber));
                    break;
                } else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNumber));
                }
            } else {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}