package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.CashMachine.RESOURCE_PATH;


public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH+"verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH+"login_en");
    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage(res.getString("before"));
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String card = ConsoleHelper.readString();
            String pin = ConsoleHelper.readString();
            if (!card.matches("^[0-9]\\d*") || card.length() != 12 || !pin.matches("^[0-9]\\d*") || pin.length() != 4)
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            else {
                if(validCreditCards.containsKey(card)&&validCreditCards.getString(card).equals(pin)) {
                    ConsoleHelper.writeMessage(res.getString("success.format"));
                    break;
                }
                else
                    ConsoleHelper.writeMessage(res.getString("not.verified.format"));
            }
        }
    }
}
