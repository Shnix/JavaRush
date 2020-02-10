package com.javarush.task.task14.task1417;

public abstract class Money {
    private double amount;

    public Money(double amount) {
        this.amount=amount;
    }

    protected Money() {
    }


    public abstract String getCurrencyName();
    public double getAmount(){
        return amount;
    }
}
