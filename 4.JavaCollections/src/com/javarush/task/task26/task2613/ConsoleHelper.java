package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import javax.naming.OperationNotSupportedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+"common_en");

    public static void writeMessage(String message){
        System.out.println(message);
    }


    public static String readString() throws InterruptOperationException {
        try {
            String task = bis.readLine();
            if (task.toUpperCase().equals("EXIT"))
                throw new InterruptOperationException();
            return task;
        } catch (IOException e) {
        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        while(true){
            writeMessage(res.getString("choose.currency.code"));
            String code = readString();
            if(code.length()==3)
                return code.toUpperCase();
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while (true) {
            System.out.println(res.getString("choose.denomination.and.count.format"));
            String input = readString();
            if (input.matches("^[1-9]\\d* [1-9]\\d*"))
                return input.split(" ");
            else writeMessage(res.getString("invalid.data"));
        }
    }

    public static Operation askOperation() throws InterruptOperationException{
        Operation operation = null;
        while(true) {
            writeMessage("Введите код команды 1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT");
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            return operation;
        }
    }

    public static void printExitMessage(){
        writeMessage("Всего доброго");
    }
}
